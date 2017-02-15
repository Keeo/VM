package cz.cvut.fit.run.vm.runtime.instruction;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-7.html#jvms-4.10.1.9.ldc
 * https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html#jvms-6.5
 * https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-4.html#jvms-4.10.1.9.ldc
 */
public class InstructionBuilder {
    public Instruction build(byte[] code, int pc) {
        try {
            DataInputStream dis = new DataInputStream(new ByteArrayInputStream(code, pc, code.length - pc));
            switch (unsignedToBytes(dis.readByte())) {
                case 0x0:
                case 0x92: // converts int to char
                    return new Nop();
                case 0x1:
                    return new AConstNull();
                case 0x11:
                    return new SIPush(dis.readShort());
                case 0x9f:
                    return new IfICmpEQ(dis.readShort());
                case 0xa0:
                    return new IfICmpNE(dis.readShort());
                case 0xa1:
                    return new IfICmpLT(dis.readShort());
                case 0xa2:
                    return new IfICmpGE(dis.readShort());
                case 0xa3:
                    return new IfICmpGT(dis.readShort());
                case 0xa4:
                    return new IfICmpLE(dis.readShort());
                case 0x99:
                    return new IfEQ(dis.readByte(), dis.readByte());
                case 0x9a:
                    return new IfNE(dis.readByte(), dis.readByte());
                case 0x9b:
                    return new IfLT(dis.readByte(), dis.readByte());
                case 0x9c:
                    return new IfGE(dis.readByte(), dis.readByte());
                case 0x9d:
                    return new IfGT(dis.readByte(), dis.readByte());
                case 0x9e:
                    return new IfLE(dis.readByte(), dis.readByte());
                case 0xc6:
                    return new IfNull(dis.readShort());
                case 0xc7:
                    return new IfNonNull(dis.readShort());
                case 0x60:
                    return new IAdd();
                case 0x64:
                    return new ISub();
                case 0x68:
                    return new IMul();
                case 0x78:
                    return new IShL();
                case 0x7e:
                    return new IAnd();
                case 0xac:
                    return new IReturn();
                case 0xb0:
                    return new AReturn();
                case 0xb1:
                    return new Return();
                case 0xb2:
                    return new GetStatic(dis.readByte(), dis.readByte());
                case 0xb5:
                    return new PutField(dis.readByte(), dis.readByte());
                case 0xb3:
                    return new PutStatic(dis.readByte(), dis.readByte());
                case 0xb8:
                    return new InvokeStatic(dis.readByte(), dis.readByte());
                case 0x15:
                    return new ILoad(dis.readByte());
                case 0x1a:
                    return new ILoadN(0);
                case 0x1b:
                    return new ILoadN(1);
                case 0x1c:
                    return new ILoadN(2);
                case 0x1d:
                    return new ILoadN(3);
                case 0x33:
                    return new BALoad();
                case 0x36:
                    return new IStore(dis.readByte());
                case 0x3b:
                    return new IStoreN(0);
                case 0x3c:
                    return new IStoreN(1);
                case 0x3d:
                    return new IStoreN(2);
                case 0x3e:
                    return new IStoreN(3);
                case 0x3:
                    return new IConst(0);
                case 0x4:
                    return new IConst(1);
                case 0x5:
                    return new IConst(2);
                case 0x6:
                    return new IConst(3);
                case 0x7:
                    return new IConst(4);
                case 0x8:
                    return new IConst(5);
                case 0xbb:
                    return new New(dis.readByte(), dis.readByte());
                case 0xbc:
                    return new NewArray(dis.readByte());
                case 0xbd:
                    return new ANewArray(dis.readShort());
                case 0xbe:
                    return new ArrayLength();
                case 0x54:
                    return new BAStore();
                case 0x59:
                    return new Dup();
                case 0xb6:
                    return new InvokeVirtual(dis.readByte(), dis.readByte());
                case 0xb7:
                    return new InvokeSpecial(dis.readByte(), dis.readByte());
                case 0x19:
                    return new ALoad(dis.readByte());
                case 0x2a:
                    return new ALoadN(0);
                case 0x2b:
                    return new ALoadN(1);
                case 0x2c:
                    return new ALoadN(2);
                case 0x2d:
                    return new ALoadN(3);
                case 0x2e:
                    return new IALoad();
                case 0x32:
                    return new AALoad();
                case 0x34:
                    return new CALoad();
                case 0x3a:
                    return new AStore(dis.readByte());
                case 0x4b:
                    return new AStoreN(0);
                case 0x4c:
                    return new AStoreN(1);
                case 0x4d:
                    return new AStoreN(2);
                case 0x4e:
                    return new AStoreN(3);
                case 0x4f:
                    return new IAStore();
                case 0x53:
                    return new AAStore();
                case 0x55:
                    return new CAStore();
                case 0x57:
                    return new Pop();
                case 0x10:
                    return new BiPush(dis.readByte());
                case 0xb4:
                    return new GetField(dis.readByte(), dis.readByte());
                case 0xa7:
                    return new GoTo(dis.readByte(), dis.readByte());
                case 0xab:
                    return new LookupSwitch(dis, pc);
                case 0x84:
                    return new IInc(dis.readByte(), dis.readByte());
                //case 0x12:
                //    return new LdcInstruction(dis.readByte());
                default:
                    throw new RuntimeException("Unknown instruction: " + Integer.toHexString(code[pc]));
            }
        } catch (IOException exception) {
            throw new RuntimeException("Corrupted byte code");
            //return null;
        }
    }

    public static int unsignedToBytes(byte b) {
        return b & 0xFF;
    }
}

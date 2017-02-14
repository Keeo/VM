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
                case 0x60:
                    return new IAdd();
                case 0x64:
                    return new ISub();
                case 0x68:
                    return new IMul();
                case 0xb1:
                    return new Return();
                case 0xb2:
                    return new GetStatic(dis.readByte(), dis.readByte());
                case 0xb8:
                    return new InvokeStatic(dis.readByte(), dis.readByte());
                case 0x15:
                    return new ILoad(dis.readByte());
                case 0x1b:
                    return new ILoadN(1);
                case 0x1c:
                    return new ILoadN(2);
                case 0x1d:
                    return new ILoadN(3);
                case 0x36:
                    return new IStore(dis.readByte());
                case 0x3c:
                    return new IStoreN(1);
                case 0x3d:
                    return new IStoreN(2);
                case 0x3e:
                    return new IStoreN(3);
                case 0x7:
                    return new IConst(4);
                case 0x10:
                    return new BiPush(dis.readByte());
                //case 0x12:
                //    return new LdcInstruction(dis.readByte());
                default:
                    throw new RuntimeException("Unknown instruction: " + Integer.toHexString(code[pc]));
            }
        } catch (IOException exception) {
            throw new RuntimeException("Corrupted byte code");
        }
    }

    public static int unsignedToBytes(byte b) {
        return b & 0xFF;
    }
}

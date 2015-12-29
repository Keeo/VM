package cz.cvut.fit.run.vm.runtime.instruction;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-7.html#jvms-4.10.1.9.ldc
 * https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-4.html#jvms-4.10.1.9.ldc
 */
public class InstructionBuilder {
    public Instruction build(byte[] code, int pc) {
        try {
            DataInputStream dis = new DataInputStream(new ByteArrayInputStream(code, pc, code.length - pc));
            switch (dis.readByte()) {
                case 0x12:
                    return new LdcInstruction(dis.readByte());
                default:
                    throw new RuntimeException("Unknown instruction: " + Integer.toHexString(code[pc]));
            }
        } catch (IOException exception) {
            throw new RuntimeException("Corrupted byte code");
        }
    }
}

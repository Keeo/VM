package cz.cvut.fit.run.vm.classfile.attribute;

import java.util.Arrays;

/**
 * Created by Keo on 8.12.2015.
 */
public class Code extends Attribute {

    public short maxStack;
    public short maxLocals;
    public byte[] code;
    public Attribute[] attributes;

    public Code(short nameIndex, int length) {
        super(nameIndex, length);
    }

    /*
    u2 exception_table_length;
    {   u2 start_pc;
        u2 end_pc;
        u2 handler_pc;
        u2 catch_type;
    } exception_table[exception_table_length];
    */

    @Override
    public String toString() {
        return "Code{" +
                "maxStack=" + maxStack +
                ", maxLocals=" + maxLocals +
                ", code=" + Arrays.toString(code) +
                ", attributes=" + Arrays.toString(attributes) +
                '}';
    }
}

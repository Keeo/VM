package cz.cvut.fit.run.vm.classfile.constant;

import cz.cvut.fit.run.vm.runtime.operant.Value;

/**
 * Created by Keo on 8.12.2015.
 */
public abstract class Constant {
    public short type;

    public Constant(int type) {
        this.type = (short)type;
    }

    public Constant(short type) {
        this.type = type;
    }

    public Value getOperand(Constant[] constants) {
        throw new RuntimeException("Value conversion not implemented");
    }
}

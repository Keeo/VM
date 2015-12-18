package cz.cvut.fit.run.vm.classfile.constant;

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
}

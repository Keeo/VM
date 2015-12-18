package cz.cvut.fit.run.vm.classfile.constant;

/**
 * Created by Keo on 8.12.2015.
 */
public class ConstantInteger extends Constant {
    int integer;

    public ConstantInteger(int type, int integer) {
        super(type);
        this.integer = integer;
    }

    @Override
    public String toString() {
        return "ConstantInteger{" +
                "type=" + type +
                ", integer=" + integer +
                '}';
    }
}

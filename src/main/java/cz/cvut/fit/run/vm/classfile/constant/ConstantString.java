package cz.cvut.fit.run.vm.classfile.constant;

/**
 * Created by Keo on 9.12.2015.
 */
public class ConstantString extends Constant {
    short index;

    public ConstantString(int type, short index) {
        super(type);
        this.index = index;
    }
}

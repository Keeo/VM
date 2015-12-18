package cz.cvut.fit.run.vm.classfile.constant;

/**
 * Created by Keo on 9.12.2015.
 */
public class ConstantClass extends Constant {
    public short index;

    public ConstantClass(int type, short index) {
        super(type);
        this.index = index;
    }
}

package cz.cvut.fit.run.vm.classfile.constant;

/**
 * Created by Keo on 9.12.2015.
 */
public class ConstantFieldref extends Constant {
    short classIndex;
    short nameAndTypeIndex;

    public ConstantFieldref(int type, short classIndex, short nameAndTypeIndex) {
        super(type);
        this.classIndex = classIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }
}

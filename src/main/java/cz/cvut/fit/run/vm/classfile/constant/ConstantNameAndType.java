package cz.cvut.fit.run.vm.classfile.constant;

/**
 * Created by Keo on 9.12.2015.
 */
public class ConstantNameAndType extends Constant {
    short nameIndex;
    short descriptorIndex;

    public ConstantNameAndType(int type, short nameIndex, short descriptorIndex) {
        super(type);
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
    }
}

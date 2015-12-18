package cz.cvut.fit.run.vm.classfile.attribute;

/**
 * Created by Keo on 8.12.2015.
 */
public class ConstantValue extends Attribute {
    public short valueIndex;

    public ConstantValue(short nameIndex, int length) {
        super(nameIndex, length);
    }

    @Override
    public String toString() {
        return "ConstantValue{" +
                "valueIndex=" + valueIndex +
                '}';
    }
}

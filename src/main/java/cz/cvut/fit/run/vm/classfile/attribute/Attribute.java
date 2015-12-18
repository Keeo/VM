package cz.cvut.fit.run.vm.classfile.attribute;

/**
 * Created by Keo on 8.12.2015.
 */
public class Attribute {
    public short nameIndex;
    public int length;

    public Attribute(short nameIndex, int length) {
        this.nameIndex = nameIndex;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "nameIndex=" + nameIndex +
                ", length=" + length +
                '}';
    }
}

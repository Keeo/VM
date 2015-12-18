package cz.cvut.fit.run.vm.classfile.attribute;

/**
 * Created by Keo on 9.12.2015.
 */
public class Exception extends Attribute {

    public short[] exceptionIndexes;

    public Exception(short nameIndex, int length) {
        super(nameIndex, length);
    }
}

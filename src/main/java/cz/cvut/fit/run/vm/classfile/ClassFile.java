package cz.cvut.fit.run.vm.classfile;

import cz.cvut.fit.run.vm.classfile.attribute.Attribute;
import cz.cvut.fit.run.vm.classfile.constant.Constant;

/**
 * Created by Keo on 8.12.2015.
 */
public class ClassFile {
    public short minorVersion;
    public short majorVersion;

    public Constant[] constants;

    public short accessFlags;
    public short thisClassIndex;
    public short superClassIndex;

    public short[] interfaces;

    public Field[] fields;
    public Method[] methods;
    public Attribute[] attributes;
}

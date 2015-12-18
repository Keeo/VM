package cz.cvut.fit.run.vm.classfile;

import cz.cvut.fit.run.vm.classfile.attribute.Attribute;

import java.util.Arrays;

/**
 * Created by Keo on 8.12.2015.
 */
public class Item {
    public short accessFlags;
    public short nameIndex;
    public short descriptionIndex;
    public Attribute[] attributes;

    @Override
    public String toString() {
        return "Item{" +
                "accessFlags=" + accessFlags +
                ", nameIndex=" + nameIndex +
                ", descriptionIndex=" + descriptionIndex +
                ", attributes=" + Arrays.toString(attributes) +
                '}';
    }
}

package cz.cvut.fit.run.vm.classfile.facade;

import cz.cvut.fit.run.vm.classfile.Field;
import cz.cvut.fit.run.vm.classfile.constant.ConstantUtf8;

/**
 * Created by Keo on 13.2.2017.
 */
public class FField {
    public FClass fClass;
    public Field field;

    public FField(FClass fClass, Field field) {
        this.fClass = fClass;
        this.field = field;
    }

    public String getDescription() {
        ConstantUtf8 constantUtf8 = (ConstantUtf8) fClass.classFile.constants[field.descriptionIndex];
        return constantUtf8.string;
    }

    public String getName() {
        ConstantUtf8 constantUtf8 = (ConstantUtf8) fClass.getConstants()[field.nameIndex];
        return constantUtf8.string;
    }

    public FField() {
    }
}

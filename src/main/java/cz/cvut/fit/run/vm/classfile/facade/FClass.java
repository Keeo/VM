package cz.cvut.fit.run.vm.classfile.facade;

import cz.cvut.fit.run.vm.classfile.ClassFile;
import cz.cvut.fit.run.vm.classfile.constant.Constant;
import cz.cvut.fit.run.vm.classfile.constant.ConstantClass;
import cz.cvut.fit.run.vm.classfile.constant.ConstantUtf8;

/**
 * Created by Keo on 9.12.2015.
 */
public class FClass {
    ClassFile classFile;

    public FClass(ClassFile classFile) {
        this.classFile = classFile;
    }

    public String getFullClassName() {
        return this.convertConstantPointerToString(classFile.thisClassIndex);
    }

    public FMethod[] getMethods() {
        FMethod[] fMethods = new FMethod[classFile.methods.length];
        for (int i = 0; i < fMethods.length; i++) {
            fMethods[i] = new FMethod(this, classFile.methods[i], classFile.constants);
        }
        return fMethods;
    }

    public String convertConstantPointerToString(int index) {
        Constant constant = classFile.constants[index];

        if (constant instanceof ConstantClass) {
            ConstantClass constantClass = (ConstantClass) constant;
            ConstantUtf8 constantUtf8 = (ConstantUtf8) classFile.constants[constantClass.index];
            return constantUtf8.string;
        }

        if (constant instanceof ConstantUtf8) {
            return ((ConstantUtf8) constant).string;
        }

        throw new RuntimeException("Unknown pointer to get string from: " + constant.getClass().getName());
    }

    public FMethod getMethod(String name) {
        for(FMethod fMethod : getMethods()) {
            if (fMethod.getName().equals(name)) {
                return fMethod;
            }
        }

        throw new RuntimeException("Method " + name + " was not found in class " + this.getFullClassName());
    }

    public FField[] getFields() {
        FField[] fFields = new FField[classFile.fields.length];
        for(int i = 0; i < fFields.length; i++) {
            fFields[i] = new FField(this, classFile.fields[i]);
        }
        return fFields;
    }

    public FField getField(String name) {
        for(FField fField : getFields()) {
            if (fField.getName().equals(name)) {
                return fField;
            }
        }

        throw new RuntimeException("Field " + name + " was not found in class " + this.getFullClassName());
    }

    public Constant[] getConstants() {
        return classFile.constants;
    }
}

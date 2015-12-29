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
        ConstantClass constantClass = (ConstantClass) classFile.constants[classFile.thisClassIndex];
        ConstantUtf8 constantUtf8 = (ConstantUtf8) classFile.constants[constantClass.index];
        return constantUtf8.string;
    }

    public FMethod[] getMethods() {
        FMethod[] fMethods = new FMethod[classFile.methods.length];
        for (int i = 0; i < fMethods.length; i++) {
            fMethods[i] = new FMethod(this, classFile.methods[i], classFile.constants);
        }
        return fMethods;
    }

    public Constant[] getConstants() {
        return classFile.constants;
    }
}

package cz.cvut.fit.run.vm.classfile.facade;

import cz.cvut.fit.run.vm.classfile.ClassFile;
import cz.cvut.fit.run.vm.classfile.constant.ConstantClass;
import cz.cvut.fit.run.vm.classfile.constant.ConstantUTF8;

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
        ConstantUTF8 constantUTF8 = (ConstantUTF8) classFile.constants[constantClass.index];
        return constantUTF8.string;
    }

    public FMethod[] getMethods() {
        FMethod[] fMethods = new FMethod[classFile.methods.length];
        for (int i = 0; i < fMethods.length; i++) {
            fMethods[i] = new FMethod(classFile.methods[i], classFile.constants);
        }
        return fMethods;
    }
}

package cz.cvut.fit.run.vm.classfile.facade;

import com.sun.org.apache.xpath.internal.SourceTree;
import cz.cvut.fit.run.vm.classfile.ClassFile;
import cz.cvut.fit.run.vm.classfile.constant.Constant;
import cz.cvut.fit.run.vm.classfile.constant.ConstantClass;
import cz.cvut.fit.run.vm.classfile.constant.ConstantUtf8;
import org.omg.CORBA.FREE_MEM;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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

    public int getFieldIndex(String fieldName) {
        FField[] fields = getFields();
        if (fields.length == 0) {
            throw new RuntimeException("Cannot get index field when we dont have any fields.");
        }

        int position = 0;
        for (FField fField : this.getFields()) {
            if (fField.getName().equals(fieldName)) {
                return position;
            }
            position++;
        }

        throw new RuntimeException("We were not able to find field we wanted.");
    }

    /**\
     * https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-2.html#jvms-2.9
     */
    public FMethod getClassInitMethod() {
        for(FMethod fMethod : this.getMethods()) {
            if (fMethod.getName().equals("<cinit>") &&
                    fMethod.getDescription().equals("()V")) {
                return fMethod;
            }
        }
        System.out.println("Class " + this.getFullClassName() + " is without init method.");
        return null;
    }

    public Constant[] getConstants() {
        return classFile.constants;
    }

    /**
     * https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-5.html#jvms-5.5
     */
    boolean isInitialized = false;
    public void initialize() {
        if (isInitialized) {
            return;
        }
        isInitialized = true;

        FMethod initMethod = this.getClassInitMethod();
        if (initMethod != null) {
            throw new NotImplementedException();
        }
    }
}

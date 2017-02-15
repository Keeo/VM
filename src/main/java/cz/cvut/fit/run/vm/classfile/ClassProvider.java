package cz.cvut.fit.run.vm.classfile;

import cz.cvut.fit.run.vm.classfile.facade.FClass;
import cz.cvut.fit.run.vm.classfile.facade.FField;
import cz.cvut.fit.run.vm.classfile.facade.FMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Keo on 9.12.2015.
 */
public class ClassProvider {
    public ClassFileLoader classFileLoader;
    public HashMap<String, FClass> classes;

    public ClassProvider(ClassFileLoader classFileLoader) {
        this.classFileLoader = classFileLoader;
        this.classes = new HashMap<>();
    }

    public void addClassFileFromPath(String path) throws IOException {
        ClassFile classFile = classFileLoader.loadClassFile(new FileInputStream(path));
        FClass fClass = new FClass(classFile);
        classes.put(fClass.getFullClassName(), fClass);
        System.out.println("> Class loaded - " + fClass.getFullClassName());
    }

    public void addGlobalClass(FClass fClass) {
        classes.put(fClass.getFullClassName(), fClass);
        System.out.println("> Global class loaded - " + fClass.getFullClassName());
    }

    public FClass getClass(String className) {
        return classes.get(className);
    }

    public FMethod getMethod(String className, String methodName) {
        return this.getClass(className).getMethod(methodName);
    }

    public FField getField(String className, String fieldName) {
        return this.getClass(className).getField(fieldName);
    }

    public FMethod getMainMethod() {
        for (FClass fClass : classes.values()) {
            for (FMethod fMethod : fClass.getMethods()) {
                if (fMethod.getName().equals("main")) {
                    return fMethod;
                }
            }
        }
        throw new RuntimeException("Main function not found.");
    }
}

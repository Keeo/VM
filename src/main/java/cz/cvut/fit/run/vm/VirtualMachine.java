package cz.cvut.fit.run.vm;

import cz.cvut.fit.run.vm.classfile.ClassFileLoader;
import cz.cvut.fit.run.vm.classfile.ClassProvider;
import cz.cvut.fit.run.vm.classfile.facade.FMethod;

import java.io.IOException;

/**
 * Created by Keo on 8.12.2015.
 */
public class VirtualMachine {
    ClassProvider classProvider = new ClassProvider(new ClassFileLoader());

    public static void main(String[] args) throws IOException {
        VirtualMachine virtualMachine = new VirtualMachine(args);
        virtualMachine.run();
    }

    public VirtualMachine(String[] classFiles) throws IOException {
        for (String classFile : classFiles) {
            classProvider.addClassFileFromPath(classFile);
        }
    }

    void run() {
        FMethod fMethod = classProvider.getMainMethod();
        // todo: create frame
    }
}

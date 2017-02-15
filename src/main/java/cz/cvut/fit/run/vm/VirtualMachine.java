package cz.cvut.fit.run.vm;

import cz.cvut.fit.run.vm.classfile.ClassFileLoader;
import cz.cvut.fit.run.vm.classfile.ClassProvider;
import cz.cvut.fit.run.vm.classfile.facade.FClass;
import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.Heap;
import cz.cvut.fit.run.vm.runtime.RuntimeEnvironment;
import cz.cvut.fit.run.vm.runtime.java.lang.NString;
import cz.cvut.fit.run.vm.runtime.java.lang.Object;

import java.io.IOException;

/**
 * Created by Keo on 8.12.2015.
 */
public class VirtualMachine {
    public static ClassProvider classProvider = new ClassProvider(new ClassFileLoader());

    public static void main(String[] args) throws IOException {
//        String[] classFiles = {
//                "src/test/fixtures/sat/SatSolver.class",
//                "src/test/fixtures/sat/Expression.class",
//                "src/test/fixtures/sat/ExpressionLink.class",
//                "src/test/fixtures/sat/Stack.class"
//        };
        String[] classFiles = {
                "src/test/fixtures/demo/ArrayComplex.class",
                //"src/test/fixtures/demo/ComplexNumber.class",
        };
        VirtualMachine virtualMachine = new VirtualMachine(classFiles);
        virtualMachine.run();
    }

    public VirtualMachine(String[] classFiles) throws IOException {
        for (String classFile : classFiles) {
            classProvider.addClassFileFromPath(classFile);
        }

        classProvider.addGlobalClass(new Object());
        classProvider.addGlobalClass(new NString());
    }

    void run() {
        RuntimeEnvironment runtimeEnvironment = new RuntimeEnvironment(
                new Frame(classProvider.getMainMethod()),
                Heap.getInstance());

        runtimeEnvironment.execute();
    }
}

package cz.cvut.fit.run.vm.runtime;

import cz.cvut.fit.run.vm.classfile.ClassProvider;

/**
 * Created by Keo on 9.12.2015.
 */
public class RuntimeEnvironment {
    Frame frame;
    ClassProvider classProvider;
    ObjectHeap objectHeap;

    public RuntimeEnvironment(Frame frame, ClassProvider classProvider, ObjectHeap objectHeap) {
        this.frame = frame;
        this.classProvider = classProvider;
        this.objectHeap = objectHeap;
    }
}

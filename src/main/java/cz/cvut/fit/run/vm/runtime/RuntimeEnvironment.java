package cz.cvut.fit.run.vm.runtime;

import cz.cvut.fit.run.vm.classfile.ClassProvider;

import java.util.Stack;

/**
 * Created by Keo on 9.12.2015.
 */
public class RuntimeEnvironment {
    Stack<Frame> frames = new Stack<>();
    ClassProvider classProvider;
    Heap objectHeap;

    public RuntimeEnvironment(Frame frame, ClassProvider classProvider, Heap objectHeap) {
        this.classProvider = classProvider;
        this.objectHeap = objectHeap;
        frames.push(frame);
    }

    public void execute() {
        for (String s : this.classProvider.classes.keySet()) {
            System.out.println(s);
        }

        this.frames.peek().execute(frames);
    }
}

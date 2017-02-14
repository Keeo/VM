package cz.cvut.fit.run.vm.runtime;

import cz.cvut.fit.run.vm.classfile.ClassProvider;

import java.util.Stack;

/**
 * Created by Keo on 9.12.2015.
 */
public class RuntimeEnvironment {
    Stack<Frame> frames = new Stack<>();
    Heap objectHeap;

    public RuntimeEnvironment(Frame frame, Heap objectHeap) {
        this.objectHeap = objectHeap;
        frames.push(frame);
    }

    public void execute() {
        while(!frames.isEmpty()) {
            this.frames.peek().execute(frames);
        }
    }
}

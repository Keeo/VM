package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;

import java.util.Stack;

/**
 * Created by Keo on 22.12.2015.
 */
public abstract class Instruction {
    public abstract void execute(Frame frame, Stack<Frame> stack);

    public int size() {
        return 1;
    }
}

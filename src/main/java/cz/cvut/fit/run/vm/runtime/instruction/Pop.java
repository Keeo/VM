package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public class Pop extends Instruction {
    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        this.echo();

        frame.operandStack.pop();
        frame.pc += 1;
    }
}

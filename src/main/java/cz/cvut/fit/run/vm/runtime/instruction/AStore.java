package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.Value;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public class AStore extends Instruction {
    int index;

    public AStore(int index) {
        this.index = index;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        this.echo();

        Value value = frame.operandStack.pop();
        assert(value.isReference());
        frame.locals[index] = value;

        frame.pc += 2;
    }
}

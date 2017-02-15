package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.Value;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public class AReturn extends Instruction {
    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        System.out.println("[I] AReturn");

        Value ref = frame.operandStack.pop();
        assert(ref.isReference());

        frame.operandStack.clear();
        frame.pc = 0;
        stack.pop();
        stack.peek().operandStack.push(ref);
    }
}

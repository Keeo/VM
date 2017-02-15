package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.Value;

import java.util.Stack;

/**
 * Created by Keo on 14.2.2017.
 */
public class Dup extends Instruction {
    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        System.out.println("[I] Dup");

        Value v = frame.operandStack.peek();
        frame.operandStack.push(v.copy());

        frame.pc += 1;
    }
}

package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;

import java.util.Stack;

/**
 * Created by Keo on 14.2.2017.
 */
public class IMul extends Instruction {
    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        System.out.println("[I] IMul");

        ValueInteger a = (ValueInteger) frame.operandStack.pop();
        ValueInteger b = (ValueInteger) frame.operandStack.pop();
        frame.operandStack.push(new ValueInteger(a.integer * b.integer));

        frame.pc += 1;
    }
}

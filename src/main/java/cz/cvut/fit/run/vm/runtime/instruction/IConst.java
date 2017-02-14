package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;

import java.util.Stack;

/**
 * Created by Keo on 14.2.2017.
 */
public class IConst extends Instruction {
    int constant;

    public IConst(int constant) {
        this.constant = constant;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        frame.operandStack.push(new ValueInteger(constant));

        frame.pc += 1;
    }
}

package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public class IAnd extends Instruction {
    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        this.echo();

        ValueInteger value2 = (ValueInteger) frame.operandStack.pop();
        ValueInteger value1 = (ValueInteger) frame.operandStack.pop();
        frame.operandStack.push(new ValueInteger(value1.integer & value2.integer));

        frame.pc += 1;
    }
}

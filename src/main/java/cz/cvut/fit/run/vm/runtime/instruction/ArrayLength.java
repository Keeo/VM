package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.ValueArrayReference;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public class ArrayLength extends Instruction {
    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        ValueArrayReference valueArrayReference = (ValueArrayReference) frame.operandStack.pop();
        frame.operandStack.push(new ValueInteger(valueArrayReference.size));

        frame.pc += 1;
    }
}

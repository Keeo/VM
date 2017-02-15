package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.Heap;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;
import cz.cvut.fit.run.vm.runtime.operant.ValueObjectReference;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public class IAStore extends Instruction {

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        ValueInteger value = (ValueInteger) frame.operandStack.pop();
        ValueInteger index = (ValueInteger) frame.operandStack.pop();
        ValueObjectReference arrayReference = (ValueObjectReference) frame.operandStack.pop();

        Heap.getInstance().heap[arrayReference.heap + index.integer] = value;

        frame.pc += 1;
    }
}

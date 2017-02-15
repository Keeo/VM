package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.Heap;
import cz.cvut.fit.run.vm.runtime.operant.ValueArrayReference;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public class IAStore extends Instruction {

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        System.out.println("[I] IAStore");

        ValueInteger value = (ValueInteger) frame.operandStack.pop();
        ValueInteger index = (ValueInteger) frame.operandStack.pop();
        ValueArrayReference valueArrayReference = (ValueArrayReference) frame.operandStack.pop();
        //System.out.println("Stored value:" + value.integer + " into position:" + (index.integer + valueArrayReference.heap));
        Heap.getInstance().heap[valueArrayReference.heap + index.integer] = value;

        frame.pc += 1;
    }
}

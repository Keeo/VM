package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.Heap;
import cz.cvut.fit.run.vm.runtime.operant.ValueArrayReference;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;
import cz.cvut.fit.run.vm.runtime.operant.ValueObjectReference;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public class IALoad extends Instruction {

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        System.out.println("[I] IALoad");

        ValueInteger index = (ValueInteger) frame.operandStack.pop();
        ValueArrayReference valueArrayReference = (ValueArrayReference) frame.operandStack.pop();

        ValueInteger value = (ValueInteger) Heap.getInstance().heap[valueArrayReference.heap + index.integer];
        frame.operandStack.push(value);

        frame.pc += 1;
    }
}

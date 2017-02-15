package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.Heap;
import cz.cvut.fit.run.vm.runtime.operant.Value;
import cz.cvut.fit.run.vm.runtime.operant.ValueArrayReference;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public class AALoad extends Instruction {

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        System.out.println("[I] AALoad");

        ValueInteger index = (ValueInteger)frame.operandStack.pop();
        ValueArrayReference valueArrayReference = (ValueArrayReference)frame.operandStack.pop();
        Value value = Heap.getInstance().heap[valueArrayReference.heap + index.integer];
        frame.operandStack.push(value);

        frame.pc += 1;
    }
}

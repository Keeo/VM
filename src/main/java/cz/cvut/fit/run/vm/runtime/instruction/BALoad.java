package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.Heap;
import cz.cvut.fit.run.vm.runtime.operant.ValueArrayReference;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public class BALoad extends Instruction {
    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        this.echo();

        ValueInteger index = (ValueInteger) frame.operandStack.pop();
        ValueArrayReference valueArrayReference = (ValueArrayReference) frame.operandStack.pop();

        ValueInteger value = (ValueInteger) Heap.getInstance().heap[valueArrayReference.heap + index.integer];
        //System.out.println("Loaded value:" + value.integer + " from position:" + (index.integer + valueArrayReference.heap));
        frame.operandStack.push(value);

        frame.pc += 1;
    }
}

package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.Heap;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;
import cz.cvut.fit.run.vm.runtime.operant.ValueObjectReference;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public class NewArray extends Instruction {
    int type;

    public NewArray(byte type) {
        this.type = type;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        ValueInteger count = (ValueInteger) frame.operandStack.pop();
        Heap heap = Heap.getInstance();

        ValueObjectReference valueObjectReference = heap.createArray(type, count.integer);
        frame.operandStack.push(valueObjectReference);
        frame.pc += 2;
    }
}

package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public abstract class If extends Instruction {

    int offset;

    public If(byte indexbyte1, byte indexbyte2) {
        this.offset = (indexbyte1 << 8) | indexbyte2;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        ValueInteger value = (ValueInteger) frame.operandStack.pop();
        if (compare(value.integer)) {
            frame.pc += offset;
        } else {
            frame.pc += 3;
        }
    }

    protected abstract boolean compare(int value);
}

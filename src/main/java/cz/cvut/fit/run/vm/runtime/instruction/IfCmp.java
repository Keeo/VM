package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.Value;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public abstract class IfCmp extends Instruction {
    int offset;

    public IfCmp(byte indexbyte1, byte indexbyte2) {
        this.offset = (indexbyte1 << 8) | indexbyte2;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        Value b = frame.operandStack.pop();
        Value a = frame.operandStack.pop();
        if (this.compare(a, b)) {
            frame.pc += offset;
        } else {
            frame.pc +=3;
        }
    }

    abstract boolean compare(Value a, Value b);
}

package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.Value;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public abstract class IfCmp extends Instruction {
    int offset;

    public IfCmp(short offset) {
        this.offset = offset;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        this.echo();

        Value b = frame.operandStack.pop();
        Value a = frame.operandStack.pop();
        if (this.compare(a, b)) {
            frame.pc += offset;
        } else {
            frame.pc += 3;
        }
    }

    abstract boolean compare(Value a, Value b);
}

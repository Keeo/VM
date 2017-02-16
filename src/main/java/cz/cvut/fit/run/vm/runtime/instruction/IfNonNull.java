package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.ReferenceInterface;
import cz.cvut.fit.run.vm.runtime.operant.Value;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public class IfNonNull extends Instruction {
    int offset;

    public IfNonNull(short offset) {
        this.offset = offset;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        System.out.println("[I] IfNotNull");

        Value value = frame.operandStack.pop();
        assert (value instanceof ReferenceInterface);
        if (((ReferenceInterface) value).isNull()) {
            frame.pc += 3;
        } else {
            frame.pc += offset;
        }
    }
}

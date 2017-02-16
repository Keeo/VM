package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.ReferenceInterface;
import cz.cvut.fit.run.vm.runtime.operant.Value;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public class IfNull extends Instruction {
    int offset;

    public IfNull(short offset) {
        this.offset = offset;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        System.out.println("[I] IfNull");

        Value value = frame.operandStack.pop();
        assert (value instanceof ReferenceInterface);
        if (((ReferenceInterface) value).isNull()) {
            frame.pc += offset;
        } else {
            frame.pc += 3;
        }
    }
}

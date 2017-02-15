package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.ValueObjectReference;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public class AConstNull extends Instruction {
    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        System.out.println("[I] AConstNull");

        frame.operandStack.push(new ValueObjectReference(null));
        frame.pc += 1;
    }
}

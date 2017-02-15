package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.ValueArrayReference;
import cz.cvut.fit.run.vm.runtime.operant.ValueObjectReference;

import java.util.Stack;

/**
 * Created by Keo on 13.2.2017.
 */
public class ALoadN extends Instruction {
    int n;

    public ALoadN(int n) {
        this.n = n;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        System.out.println("[I] ALoadN n:" + n);

        ValueArrayReference valueArrayReference = (ValueArrayReference)frame.locals[n];
        frame.operandStack.push(valueArrayReference);
        frame.pc += 1;
    }
}

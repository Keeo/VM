package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.Value;
import cz.cvut.fit.run.vm.runtime.operant.ValueArrayReference;

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
        this.echo("n: " + n);

        Value valueReference = frame.locals[n];
        assert(valueReference.isReference());
        frame.operandStack.push(valueReference);
        frame.pc += 1;
    }
}

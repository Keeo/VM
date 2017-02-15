package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.ReferenceInterface;
import cz.cvut.fit.run.vm.runtime.operant.Value;

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
        assert(valueReference instanceof ReferenceInterface);
        frame.operandStack.push(valueReference);
        frame.pc += 1;
    }
}

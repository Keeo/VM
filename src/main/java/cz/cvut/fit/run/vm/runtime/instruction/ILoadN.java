package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.Value;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;

import java.util.Stack;

/**
 * Created by Keo on 13.2.2017.
 */
public class ILoadN extends Instruction {
    int n;

    public ILoadN(int n) {
        this.n = n;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        this.echo(" n: " + n);

        Value value = frame.locals[n];
        assert(value instanceof ValueInteger);
        frame.operandStack.push(value);
        frame.pc += 1;
    }
}

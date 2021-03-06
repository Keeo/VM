package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.Value;

import java.util.Stack;

/**
 * Created by Keo on 13.2.2017.
 */
public class AStoreN extends Instruction {
    int n;

    public AStoreN(int n) {
        this.n = n;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        this.echo("n: " + n);

        Value value = frame.operandStack.pop();
        //assert(value.isReference());
        frame.locals[n] = value;
        frame.pc += 1;
    }
}

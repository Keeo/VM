package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.ReferenceInterface;
import cz.cvut.fit.run.vm.runtime.operant.Value;
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

        Value valueReference = frame.locals[n];
        assert(valueReference instanceof ReferenceInterface);
        if (valueReference instanceof ValueArrayReference) {
            this.echo("n: " + n + " ref: " + ((ValueArrayReference) valueReference).heap);
        }
        if (valueReference instanceof ValueObjectReference) {
            this.echo("n: " + n + " ref: " + ((ValueObjectReference) valueReference).heap);
        }

        frame.operandStack.push(valueReference);
        frame.pc += 1;
    }
}

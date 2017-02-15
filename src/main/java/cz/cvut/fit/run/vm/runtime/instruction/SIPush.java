package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public class SIPush extends Instruction {
    int value;

    public SIPush(short value) {
        this.value = value;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        this.echo();

        frame.operandStack.push(new ValueInteger(value));

        frame.pc += 3;
    }
}

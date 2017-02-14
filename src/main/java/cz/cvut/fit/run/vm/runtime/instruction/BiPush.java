package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;

import java.util.Stack;

/**
 * Created by Keo on 13.2.2017.
 */
public class BiPush extends Instruction {

    short value;

    public BiPush(short value) {
        this.value = value;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        System.out.println("[I] BiPush with value: " + value);

        ValueInteger valueInteger = new ValueInteger(value);
        frame.operandStack.push(valueInteger);
        frame.pc += 2;
    }
}

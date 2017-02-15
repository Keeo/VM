package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public class IInc extends Instruction {
    int index;
    int constant;

    public IInc(byte index, byte constant) {
        this.index = index;
        this.constant = constant;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        ((ValueInteger) frame.locals[index]).integer += constant;
        frame.pc += 3;
    }
}

package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public class GoTo extends Instruction {
    int offset;

    public GoTo(byte indexbyte1, byte indexbyte2) {
        this.offset = (indexbyte1 << 8) | indexbyte2;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        frame.pc += offset;
    }
}

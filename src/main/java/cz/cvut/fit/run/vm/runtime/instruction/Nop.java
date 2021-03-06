package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;

import java.util.Stack;

/**
 * Created by Keo on 14.2.2017.
 */
public class Nop extends Instruction {
    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        System.out.println("[I] Nop");

        frame.pc += 1;
    }
}

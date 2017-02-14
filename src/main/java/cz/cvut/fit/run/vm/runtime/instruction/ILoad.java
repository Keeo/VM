package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;

import java.util.Stack;

/**
 * Created by Keo on 14.2.2017.
 */
public class ILoad extends ILoadN {
    public ILoad(int n) {
        super(n);
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        super.execute(frame, stack);
        frame.pc += 1;
    }
}

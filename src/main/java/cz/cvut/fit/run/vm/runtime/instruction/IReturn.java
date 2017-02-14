package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;

import java.util.Stack;

/**
 * https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html#jvms-6.5.ireturn
 * Created by Keo on 14.2.2017.
 */
public class IReturn extends Instruction {
    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        System.out.println("[I] IReturn");

        ValueInteger integer = (ValueInteger) frame.operandStack.pop();
        frame.pc = 0;
        stack.pop();
        stack.peek().operandStack.push(integer);

        //frame.pc += 1;
    }
}

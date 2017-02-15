package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public class IShL extends Instruction {

    /**
     * Both value1 and value2 must be of type int. The values are popped from the operand stack. An int result is
     * calculated by shifting value1 left by s bit positions, where s is the value of the low 5 bits of value2.
     * The result is pushed onto the operand stack.
     *
     * @param frame
     * @param stack
     */
    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        this.echo();

        ValueInteger value2 = (ValueInteger) frame.operandStack.pop();
        ValueInteger value1 = (ValueInteger) frame.operandStack.pop();
        int value = value1.integer << (value2.integer & 31);
        //System.out.println("[D] Shifting Shifting Shifting left by " + (value2.integer & 31) + " orig:" + value2.integer);
        frame.operandStack.push(new ValueInteger(value));

        frame.pc += 1;
    }
}

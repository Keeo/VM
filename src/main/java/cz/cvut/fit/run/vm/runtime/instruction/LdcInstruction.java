package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.classfile.constant.Constant;
import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.Value;

import java.util.Stack;

/**
 * Created by Keo on 22.12.2015.
 */
public class LdcInstruction extends Instruction {

    byte index;

    public LdcInstruction(byte index) {
        this.index = index;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        Constant[] constants = frame.fMethod.fClass.getConstants();
        Value value = constants[index].getOperand(constants);
        System.out.println(value);
        // todo: current code breaks here #1
        // System.exit(0);
    }

    @Override
    public int size() {
        return 2;
    }
}

package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.VirtualMachine;
import cz.cvut.fit.run.vm.classfile.constant.Constant;
import cz.cvut.fit.run.vm.classfile.constant.ConstantClass;
import cz.cvut.fit.run.vm.classfile.constant.ConstantUtf8;
import cz.cvut.fit.run.vm.classfile.facade.FClass;
import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.Heap;
import cz.cvut.fit.run.vm.runtime.operant.ValueObjectReference;

import java.util.Stack;

/**
 * Created by Keo on 14.2.2017.
 */
public class New extends Instruction {
    int index;

    public New(byte indexbyte1, byte indexbyte2) {
        this.index = (indexbyte1 << 8) | indexbyte2;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        Constant[] constants = frame.fMethod.fClass.getConstants();
        ConstantClass classConstant = (ConstantClass) constants[index];
        String className = ((ConstantUtf8)constants[classConstant.index]).string;
        FClass fClass = VirtualMachine.classProvider.getClass(className);

        ValueObjectReference valueObjectReference = Heap.getInstance().createObject(fClass);
        frame.operandStack.push(valueObjectReference);

        frame.pc += 3;
    }
}

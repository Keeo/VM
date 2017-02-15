package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.VirtualMachine;
import cz.cvut.fit.run.vm.classfile.constant.Constant;
import cz.cvut.fit.run.vm.classfile.constant.ConstantClass;
import cz.cvut.fit.run.vm.classfile.constant.ConstantMethodref;
import cz.cvut.fit.run.vm.classfile.constant.ConstantUtf8;
import cz.cvut.fit.run.vm.classfile.facade.FClass;
import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.Heap;
import cz.cvut.fit.run.vm.runtime.operant.ValueArrayReference;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public class ANewArray extends Instruction {
    int index;

    public ANewArray(short index) {
        this.index = index;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        System.out.println("[I] ANewArray");

        Constant[] constants = frame.fMethod.fClass.getConstants();
        ConstantClass constantClass = (ConstantClass) constants[index];
        String className = ((ConstantUtf8)constants[constantClass.index]).string;
        FClass fClass = VirtualMachine.classProvider.getClass(className);

        ValueInteger size = (ValueInteger) frame.operandStack.pop();

        ValueArrayReference valueArrayReference = Heap.getInstance().createObjectArray(fClass, size.integer);
        frame.operandStack.push(valueArrayReference);

        frame.pc += 3;
    }
}

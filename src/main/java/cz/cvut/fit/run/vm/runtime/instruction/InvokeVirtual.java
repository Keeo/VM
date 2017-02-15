package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.VirtualMachine;
import cz.cvut.fit.run.vm.classfile.constant.*;
import cz.cvut.fit.run.vm.classfile.facade.FClass;
import cz.cvut.fit.run.vm.classfile.facade.FMethod;
import cz.cvut.fit.run.vm.runtime.Frame;

import java.util.Stack;

/**
 * Created by Keo on 14.2.2017.
 */
public class InvokeVirtual extends Instruction {
    int index;

    public InvokeVirtual(byte indexbyte1, byte indexbyte2) {
        this.index = (indexbyte1 << 8) | indexbyte2;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        System.out.println("[I] InvokeVirtual");

        Constant[] constants = frame.fMethod.fClass.getConstants();
        ConstantMethodref constantMethodref = (ConstantMethodref) constants[index];

        ConstantClass constantClass = (ConstantClass) constants[constantMethodref.classIndex];
        String className = ((ConstantUtf8)constants[constantClass.index]).string;
        FClass fClass = VirtualMachine.classProvider.getClass(className);
        assert(fClass != null);

        ConstantNameAndType constantNameAndType = (ConstantNameAndType) constants[constantMethodref.nameAndTypeIndex];
        String methodName = ((ConstantUtf8)constants[constantNameAndType.nameIndex]).string;
        FMethod fMethod = fClass.getMethod(methodName);
        assert(fMethod != null);


        Frame newFrame = new Frame(fMethod);
        int parameterCount = fMethod.getParameterCount();
        for (int i = 0; i < parameterCount; ++i) {
            newFrame.locals[parameterCount - i] = frame.operandStack.pop();
        }
        newFrame.locals[0] = frame.operandStack.pop();

        stack.push(newFrame);

        frame.pc += 3;
    }
}

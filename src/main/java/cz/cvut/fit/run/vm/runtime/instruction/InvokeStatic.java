package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.VirtualMachine;
import cz.cvut.fit.run.vm.classfile.constant.Constant;
import cz.cvut.fit.run.vm.classfile.constant.ConstantMethodref;
import cz.cvut.fit.run.vm.classfile.constant.ConstantNameAndType;
import cz.cvut.fit.run.vm.classfile.facade.FMethod;
import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.NativeMethods;

import java.util.Stack;

/**
 * Created by Keo on 13.2.2017.
 */
public class InvokeStatic extends Instruction {

    int index;

    public InvokeStatic(byte indexbyte1, byte indexbyte2) {
        this.index = (indexbyte1 << 8) | indexbyte2;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        System.out.println("[I] InvokeStatic");

        Constant[] constants = frame.fMethod.fClass.getConstants();
        ConstantMethodref method = (ConstantMethodref) constants[index];
        ConstantNameAndType nameAndType = (ConstantNameAndType) constants[method.nameAndTypeIndex];

        String className = frame.fMethod.fClass.convertConstantPointerToString(method.classIndex);
        String methodName = frame.fMethod.fClass.convertConstantPointerToString(nameAndType.nameIndex);

        FMethod fMethod = VirtualMachine.classProvider.getMethod(className, methodName);

        if (!fMethod.method.isStatic()) {
            throw new RuntimeException("Method must be static.");
        }

        if (fMethod.method.isNative()) {
            NativeMethods.invokeStatic(className, methodName, frame, stack);
            frame.pc += 3;
            return;
        }

        Frame newFrame = new Frame(fMethod);
        int parameterCount = fMethod.getParameterCount();
        for (int i = 0; i < parameterCount; ++i) {
            newFrame.locals[parameterCount - i - 1] = frame.operandStack.pop();
        }


        fMethod.fClass.initialize();


        stack.push(newFrame);

        //System.exit(0);

        frame.pc += 3;
    }
}

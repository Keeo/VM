package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.VirtualMachine;
import cz.cvut.fit.run.vm.classfile.Method;
import cz.cvut.fit.run.vm.classfile.constant.Constant;
import cz.cvut.fit.run.vm.classfile.constant.ConstantMethodref;
import cz.cvut.fit.run.vm.classfile.constant.ConstantNameAndType;
import cz.cvut.fit.run.vm.classfile.facade.FMethod;
import cz.cvut.fit.run.vm.runtime.Frame;

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
        Constant[] constants = frame.fMethod.fClass.getConstants();
        ConstantMethodref method = (ConstantMethodref) constants[index];
        ConstantNameAndType nameAndType = (ConstantNameAndType) constants[method.nameAndTypeIndex];

        String className = frame.fMethod.fClass.convertConstantPointerToString(method.classIndex);
        String methodName = frame.fMethod.fClass.convertConstantPointerToString(nameAndType.nameIndex);

        FMethod fMethod = VirtualMachine.classProvider.getMethod(className, methodName);
        System.out.print(fMethod);
        System.out.println(fMethod.method.isNative());
        System.out.println(fMethod.method.isPrivate());
        System.out.println(fMethod.method.isPublic());
        System.out.println(fMethod.method.isStatic());



        System.exit(0);
        System.out.println("[I] InvokeStatic");

        frame.pc += 3;
    }
}

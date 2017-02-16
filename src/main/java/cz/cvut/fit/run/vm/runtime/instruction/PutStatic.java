package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.VirtualMachine;
import cz.cvut.fit.run.vm.classfile.constant.*;
import cz.cvut.fit.run.vm.classfile.facade.FClass;
import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.Value;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public class PutStatic extends Instruction {
    int index;

    public PutStatic(byte indexbyte1, byte indexbyte2) {
        this.index = (indexbyte1 << 8) | indexbyte2;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        System.out.println("[I] PutStatic - implemented by accident");

        Value value = frame.operandStack.pop();

        Constant[] constants = frame.fMethod.fClass.getConstants();
        ConstantFieldref constantFieldref = (ConstantFieldref) constants[index];
        ConstantNameAndType constantNameAndType = (ConstantNameAndType) constants[constantFieldref.nameAndTypeIndex];
        String fieldName = ((ConstantUtf8) constants[constantNameAndType.nameIndex]).string;

        ConstantClass constantClass = (ConstantClass) constants[constantFieldref.classIndex];
        String className = ((ConstantUtf8) constants[constantClass.index]).string;
        FClass fClass = VirtualMachine.classProvider.getClass(className);
        int fieldPosition = fClass.getFieldIndex(fieldName);

        System.out.println(fieldPosition);
        System.out.println(fieldName);
        System.exit(0);
    }
}

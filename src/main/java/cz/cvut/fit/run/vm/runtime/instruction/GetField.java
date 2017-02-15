package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.VirtualMachine;
import cz.cvut.fit.run.vm.classfile.constant.*;
import cz.cvut.fit.run.vm.classfile.facade.FClass;
import cz.cvut.fit.run.vm.classfile.facade.FField;
import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.Heap;
import cz.cvut.fit.run.vm.runtime.operant.Value;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;
import cz.cvut.fit.run.vm.runtime.operant.ValueObjectReference;

import java.util.Stack;

/**
 * https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html#jvms-6.5.getfield
 * Created by Keo on 14.2.2017.
 */
public class GetField extends Instruction {
    int index;

    public GetField(byte indexbyte1, byte indexbyte2) {
        this.index = (indexbyte1 << 8) | indexbyte2;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        System.out.println("[I] GetField");
        ValueObjectReference valueObjectReference = (ValueObjectReference) frame.operandStack.pop();

        Constant[] constants = frame.fMethod.fClass.getConstants();
        ConstantFieldref constantFieldref = (ConstantFieldref) constants[index];
        ConstantNameAndType constantNameAndType = (ConstantNameAndType) constants[constantFieldref.nameAndTypeIndex];
        String fieldName = ((ConstantUtf8) constants[constantNameAndType.nameIndex]).string;

        ConstantClass constantClass = (ConstantClass) constants[constantFieldref.classIndex];
        String className = ((ConstantUtf8) constants[constantClass.index]).string;
        FClass fClass = VirtualMachine.classProvider.getClass(className);
        assert(fClass != null);

        int position = 0;
        for (FField fField : fClass.getFields()) {
            if (fField.getName().equals(fieldName)) {
                break;
            }
            position++;
        }

        Heap heap = Heap.getInstance();
        System.out.println("PP: " + position);
        System.out.println("Heap: " + valueObjectReference.heap);
        Value value = heap.heap[valueObjectReference.heap + position];
        //assert(value instanceof ValueInteger);
        frame.operandStack.push(value);

        frame.pc += 3;
    }
}

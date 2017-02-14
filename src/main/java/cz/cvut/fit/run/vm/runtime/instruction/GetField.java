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

    /**
     * The objectref, which must be of type reference, is popped from the operand stack. The unsigned indexbyte1 and
     * indexbyte2 are used to construct an index into the run-time constant pool of the current class (§2.6), where
     * the value of the index is (indexbyte1 << 8) | indexbyte2. The run-time constant pool item at that index must
     * be a symbolic reference to a field (§5.1), which gives the name and descriptor of the field as well as a symbolic
     * reference to the class in which the field is to be found. The referenced field is resolved (§5.4.3.2). The value
     * of the referenced field in objectref is fetched and pushed onto the operand stack.
     */
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

        Value value = heap.heap[valueObjectReference.heap + position];
        assert(value instanceof ValueInteger);
        frame.operandStack.push(value);

        frame.pc += 3;
    }
}

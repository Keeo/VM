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
public class PutField extends Instruction {
    int index;

    public PutField(byte indexbyte1, byte indexbyte2) {
        this.index = (indexbyte1 << 8) | indexbyte2;
    }

    /**
     * The unsigned indexbyte1 and indexbyte2 are used to construct an index into the run-time constant pool of the current
     * class (§2.6), where the value of the index is (indexbyte1 << 8) | indexbyte2. The run-time constant pool item at that
     * index must be a symbolic reference to a field (§5.1), which gives the name and descriptor of the field as well as a
     * symbolic reference to the class in which the field is to be found. The class of objectref must not be an array. If
     * the field is protected (§4.6), and it is a member of a superclass of the current class, and the field is not declared
     * in the same run-time package (§5.3) as the current class, then the class of objectref must be either the current class
     * or a subclass of the current class.

     The referenced field is resolved (§5.4.3.2). The type of a value stored by a putfield instruction must be compatible
     with the descriptor of the referenced field (§4.3.2). If the field descriptor type is boolean, byte, char, short, or
     int, then the value must be an int. If the field descriptor type is float, long, or double, then the value must be
     a float, long, or double, respectively. If the field descriptor type is a reference type, then the value must be of
     a type that is assignment compatible (JLS §5.2) with the field descriptor type. If the field is final, it must be
     declared in the current class, and the instruction must occur in an instance initialization method (<init>) of the current class (§2.9).

     The value and objectref are popped from the operand stack. The objectref must be of type reference. The value undergoes
     value set conversion (§2.8.3), resulting in value', and the referenced field in objectref is set to value'.
     * @param frame
     * @param stack
     */
    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        System.out.println("[I] PutField");

        Value value = frame.operandStack.pop();
        ValueObjectReference valueObjectReference = (ValueObjectReference) frame.operandStack.pop();

        Constant[] constants = frame.fMethod.fClass.getConstants();
        ConstantFieldref constantFieldref = (ConstantFieldref) constants[index];
        ConstantNameAndType constantNameAndType = (ConstantNameAndType) constants[constantFieldref.nameAndTypeIndex];
        String fieldName = ((ConstantUtf8) constants[constantNameAndType.nameIndex]).string;

        ConstantClass constantClass = (ConstantClass) constants[constantFieldref.classIndex];
        String className = ((ConstantUtf8) constants[constantClass.index]).string;
        FClass fClass = VirtualMachine.classProvider.getClass(className);
        int fieldPosition = fClass.getFieldIndex(fieldName);

        Heap heap = Heap.getInstance();

        heap.heap[valueObjectReference.heap + fieldPosition] = value;

        frame.pc += 3;
    }
}

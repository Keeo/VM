package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.classfile.constant.Constant;
import cz.cvut.fit.run.vm.classfile.constant.ConstantFieldref;
import cz.cvut.fit.run.vm.classfile.constant.ConstantNameAndType;
import cz.cvut.fit.run.vm.runtime.Frame;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Stack;

/**
 * https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html#jvms-6.5.getstatic
 * Created by Keo on 14.2.2017.
 */
public class GetStatic extends Instruction {

    int index;

    public GetStatic(byte indexbyte1, byte indexbyte2) {
        this.index = (indexbyte1 << 8) | indexbyte2;
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        Constant[] constants = frame.fMethod.fClass.getConstants();

        ConstantFieldref fieldref = (ConstantFieldref) constants[index];
        ConstantNameAndType nameAndType = (ConstantNameAndType) constants[fieldref.nameAndTypeIndex];

        String className = frame.fMethod.fClass.convertConstantPointerToString(fieldref.classIndex);
        String fieldName = frame.fMethod.fClass.convertConstantPointerToString(nameAndType.nameIndex);
        System.out.println(className);
        System.out.println(fieldName);
        throw new NotImplementedException();
        //System.exit(0);
    }
}

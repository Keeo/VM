package cz.cvut.fit.run.vm.classfile.facade;

import cz.cvut.fit.run.vm.classfile.Method;
import cz.cvut.fit.run.vm.classfile.attribute.Attribute;
import cz.cvut.fit.run.vm.classfile.attribute.Code;
import cz.cvut.fit.run.vm.classfile.constant.Constant;
import cz.cvut.fit.run.vm.classfile.constant.ConstantUtf8;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.LinkedList;

/**
 * Created by Keo on 9.12.2015.
 */
public class FMethod {
    public Method method;
    public FClass fClass;
    private Constant[] constants;

    public FMethod(FClass fClass, Method method, Constant[] constants) {
        this.method = method;
        this.fClass = fClass;
        this.constants = constants;
    }

    protected Code getCodeAttribute() {
        LinkedList<Code> codes = new LinkedList<>();
        for (Attribute attribute : method.attributes) {
            ConstantUtf8 constantUtf8 = (ConstantUtf8) constants[attribute.nameIndex];
            if (constantUtf8.string.equals("Code")) {
                codes.push((Code) attribute);
            }
        }
        switch (codes.size()) {
            case 0:
                return null;
            case 1:
                return codes.getFirst();
            default:
                throw new RuntimeException("Found more then one code attribute?!");
        }
    }

    public int getMaxStack() {
        return getCodeAttribute().maxStack;
    }

    public int getMaxLocals() {
        return getCodeAttribute().maxLocals;
    }

    public byte[] getCode() {
        return getCodeAttribute().code;
    }

    public void printCode() {
        for (byte b : getCode()) {
            System.out.println(Integer.toHexString(b));
        }
    }

    /**
     * (IDLjava/lang/Thread;)Ljava/lang/Object;
     * https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-4.html#jvms-4.3.3
     */
    public int getParameterCount() {
        String description = this.getDescription();
        String parameters = description.substring(1, description.indexOf(')'));
        String classFix = parameters.replaceAll("L[a-zA-Z/]+;", "L");
        int length = classFix.length();

        if (length > 4) {
            System.out.println("Param count is: " + length + " for: " + description);
            throw new NotImplementedException();
        }

        return length;
    }

    public String getName() {
        ConstantUtf8 constantUtf8 = (ConstantUtf8) constants[method.nameIndex];
        return constantUtf8.string;
    }

    public String getDescription() {
        ConstantUtf8 constantUtf8 = (ConstantUtf8) constants[method.descriptionIndex];
        return constantUtf8.string;
    }
}

package cz.cvut.fit.run.vm.classfile.facade;

import cz.cvut.fit.run.vm.classfile.Method;
import cz.cvut.fit.run.vm.classfile.attribute.Attribute;
import cz.cvut.fit.run.vm.classfile.attribute.Code;
import cz.cvut.fit.run.vm.classfile.constant.Constant;
import cz.cvut.fit.run.vm.classfile.constant.ConstantUtf8;

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

    public String getName() {
        ConstantUtf8 constantUtf8 = (ConstantUtf8) constants[method.nameIndex];
        return constantUtf8.string;
    }
}

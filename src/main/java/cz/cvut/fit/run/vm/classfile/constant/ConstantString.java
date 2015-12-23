package cz.cvut.fit.run.vm.classfile.constant;

import cz.cvut.fit.run.vm.runtime.operant.Value;
import cz.cvut.fit.run.vm.runtime.operant.ValueBuilder;

/**
 * Created by Keo on 9.12.2015.
 */
public class ConstantString extends Constant {
    short index;

    public ConstantString(int type, short index) {
        super(type);
        this.index = index;
    }

    @Override
    public Value getOperand(Constant[] constants) {
        ConstantUtf8 constantUtf8 = (ConstantUtf8) constants[index];
        return ValueBuilder.getInstance().buildObjectReference(constantUtf8.string);
    }
}

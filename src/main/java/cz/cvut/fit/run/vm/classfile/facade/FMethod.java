package cz.cvut.fit.run.vm.classfile.facade;

import cz.cvut.fit.run.vm.classfile.Method;
import cz.cvut.fit.run.vm.classfile.constant.Constant;
import cz.cvut.fit.run.vm.classfile.constant.ConstantUTF8;

/**
 * Created by Keo on 9.12.2015.
 */
public class FMethod {
    Method method;
    private Constant[] constants;

    public FMethod(Method method, Constant[] constants) {
        this.method = method;
        this.constants = constants;
    }

    public String getName() {
        ConstantUTF8 constantUTF8 = (ConstantUTF8) constants[method.nameIndex];
        return constantUTF8.string;
    }
}

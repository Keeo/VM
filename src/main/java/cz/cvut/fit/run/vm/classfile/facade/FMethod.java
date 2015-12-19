package cz.cvut.fit.run.vm.classfile.facade;

import cz.cvut.fit.run.vm.classfile.Method;
import cz.cvut.fit.run.vm.classfile.constant.Constant;
import cz.cvut.fit.run.vm.classfile.constant.ConstantUtf8;

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
        ConstantUtf8 constantUtf8 = (ConstantUtf8) constants[method.nameIndex];
        return constantUtf8.string;
    }
}

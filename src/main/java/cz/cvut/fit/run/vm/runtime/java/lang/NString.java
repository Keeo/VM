package cz.cvut.fit.run.vm.runtime.java.lang;

import cz.cvut.fit.run.vm.classfile.constant.Constant;
import cz.cvut.fit.run.vm.classfile.facade.FClass;
import cz.cvut.fit.run.vm.classfile.facade.FField;
import cz.cvut.fit.run.vm.classfile.facade.FMethod;

/**
 * Created by Keo on 13.2.2017.
 */
public class NString extends Object {

    @Override
    public String getFullClassName() {
        return "java/lang/String";
    }

    @Override
    public FField[] getFields() {
        FField ffield = new FField() {
            @Override
            public String getDescription() {
                return "[C";
            }
        };

        return new FField[]{ffield};
    }
}

package cz.cvut.fit.run.vm.runtime.java.lang;

import cz.cvut.fit.run.vm.classfile.attribute.Code;
import cz.cvut.fit.run.vm.classfile.constant.Constant;
import cz.cvut.fit.run.vm.classfile.facade.FClass;
import cz.cvut.fit.run.vm.classfile.facade.FField;
import cz.cvut.fit.run.vm.classfile.facade.FMethod;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Keo on 13.2.2017.
 */
public class Object extends FClass {
    public Object() {
        super(null);
    }

    @Override
    public String getFullClassName() {
        return "java/lang/Object";
    }

    @Override
    public FMethod[] getMethods() {
        FMethod fMethod = new FMethod(this, null, this.getConstants()) {
            @Override
            protected Code getCodeAttribute() {
                throw new NotImplementedException();
            }

            @Override
            public int getMaxStack() {
                return 0;
            }

            @Override
            public int getMaxLocals() {
                return 1;
            }

            @Override
            public byte[] getCode() {
                return new byte[]{(byte) 0xb1};
            }

            @Override
            public int getParameterCount() {
                return 0;
            }

            @Override
            public String getName() {
                return "<init>";
            }

            @Override
            public String getDescription() {
                throw new NotImplementedException();
            }
        };

        return new FMethod[]{fMethod};
    }

    @Override
    public Constant[] getConstants() {
        return new Constant[]{};
    }

    @Override
    public FField[] getFields() {
        return new FField[]{};
    }
}

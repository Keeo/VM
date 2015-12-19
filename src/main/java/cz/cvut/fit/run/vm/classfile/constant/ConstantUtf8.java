package cz.cvut.fit.run.vm.classfile.constant;

/**
 * Created by Keo on 20.12.2015.
 */
public class ConstantUtf8 extends Constant {
    public String string;

    public ConstantUtf8(int type, String string) {
        super(type);
        this.string = string;
    }

    @Override
    public String toString() {
        return "ConstantUtf8{" +
                "type='" + type + '\'' +
                ", string='" + string + '\'' +
                '}';
    }
}

package cz.cvut.fit.run.vm.classfile.constant;

/**
 * Created by Keo on 8.12.2015.
 */
public class ConstantUTF8 extends Constant {
    public String string;

    public ConstantUTF8(int type, String string) {
        super(type);
        this.string = string;
    }

    @Override
    public String toString() {
        return "ConstantUTF8{" +
                "type='" + type + '\'' +
                ", string='" + string + '\'' +
                '}';
    }
}

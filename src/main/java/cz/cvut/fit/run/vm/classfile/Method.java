package cz.cvut.fit.run.vm.classfile;

/**
 * Created by Keo on 8.12.2015.
 */
public class Method extends Item {
    public boolean isNative() {
        return (this.accessFlags & 0x0100) == 0x0100;
    }

    public boolean isStatic() {
        return (this.accessFlags & 0x0008) == 0x0008;
    }

    public boolean isPrivate() {
        return (this.accessFlags & 0x0002) == 0x0002;
    }

    public boolean isPublic() {
        return (this.accessFlags & 0x0001) == 0x0001;
    }
}

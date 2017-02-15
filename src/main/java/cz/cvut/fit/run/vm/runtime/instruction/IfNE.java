package cz.cvut.fit.run.vm.runtime.instruction;

/**
 * Created by Keo on 15.2.2017.
 */
public class IfNE extends If {
    public IfNE(byte indexbyte1, byte indexbyte2) {
        super(indexbyte1, indexbyte2);
    }

    protected boolean compare(int value) {
        return value != 0;
    }
}

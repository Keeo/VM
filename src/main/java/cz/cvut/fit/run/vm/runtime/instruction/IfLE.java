package cz.cvut.fit.run.vm.runtime.instruction;

/**
 * Created by Keo on 15.2.2017.
 */
public class IfLE extends If {
    public IfLE(byte indexbyte1, byte indexbyte2) {
        super(indexbyte1, indexbyte2);
    }

    @Override
    protected boolean compare(int value) {
        return value <= 0;
    }
}

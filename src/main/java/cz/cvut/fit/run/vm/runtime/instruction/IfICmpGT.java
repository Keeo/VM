package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.operant.Value;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;

/**
 * Created by Keo on 15.2.2017.
 */
public class IfICmpGT extends IfCmp {
    public IfICmpGT(byte indexbyte1, byte indexbyte2) {
        super(indexbyte1, indexbyte2);
    }

    @Override
    boolean compare(Value a, Value b) {
        ValueInteger ia = (ValueInteger) a;
        ValueInteger ib = (ValueInteger) b;
        return ia.integer > ib.integer;
    }
}
package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.Value;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;

import java.util.Stack;

/**
 * Created by Keo on 15.2.2017.
 */
public class IfICmpGE extends IfCmp {

    public IfICmpGE(short offset) {
        super(offset);
    }

    @Override
    boolean compare(Value a, Value b) {
        ValueInteger ia = (ValueInteger) a;
        ValueInteger ib = (ValueInteger) b;
        return ia.integer >= ib.integer;
    }
}

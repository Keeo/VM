package cz.cvut.fit.run.vm.runtime.operant;

/**
 * Created by Keo on 9.12.2015.
 */
public class ValueInteger extends Value {
    public int integer;

    public ValueInteger(int integer) {
        this.integer = integer;
    }

    public Value copy() {
        return new ValueInteger(this.integer);
    };

    @Override
    public String toString() {
        return Integer.toString(integer);
    }
}

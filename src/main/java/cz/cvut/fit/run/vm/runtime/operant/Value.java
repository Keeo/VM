package cz.cvut.fit.run.vm.runtime.operant;

/**
 * Created by Keo on 9.12.2015.
 */
public abstract class Value {
    public boolean isReference() {
        return false;
    }

    public abstract Value copy();
}


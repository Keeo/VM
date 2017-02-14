package cz.cvut.fit.run.vm.runtime.operant;

import cz.cvut.fit.run.vm.classfile.facade.FClass;

/**
 * Created by Keo on 22.12.2015.
 */
public class ValueObjectReference extends Value {
    public int heap;
    public FClass reference;

    public ValueObjectReference(FClass reference) {
        this.reference = reference;
    }

    public Value copy() {
        return new ValueObjectReference(this.reference, this.heap);
    }

    public ValueObjectReference(FClass reference, int heap) {
        this.reference = reference;
        this.heap = heap;
    }

    public boolean isReference() {
        return true;
    }
}

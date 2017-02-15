package cz.cvut.fit.run.vm.runtime.operant;

import cz.cvut.fit.run.vm.classfile.facade.FClass;

/**
 * Created by Keo on 22.12.2015.
 */
public class ValueObjectReference extends Value implements ReferenceInterface {
    public int heap = -1;
    public FClass reference;

    public ValueObjectReference(FClass reference) {
        this.reference = reference;
        System.out.println("[D] Creating object reference without heap place.");
    }

    public ValueObjectReference(FClass reference, int heap) {
        this.reference = reference;
        this.heap = heap;
    }

    public Value copy() {
        return new ValueObjectReference(this.reference, this.heap);
    }

    public boolean isNull() {
        return heap == -1;
    }

    public boolean isReference() {
        return true;
    }
}

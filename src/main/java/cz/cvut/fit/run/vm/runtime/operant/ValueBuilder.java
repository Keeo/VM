package cz.cvut.fit.run.vm.runtime.operant;

import cz.cvut.fit.run.vm.runtime.Heap;

/**
 * Created by Keo on 22.12.2015.
 */
public class ValueBuilder {

    private static ValueBuilder valueBuilder;

    private static Heap heap;

    private ValueBuilder() {
        heap = Heap.getInstance();
    }

    public static ValueBuilder getInstance() {
        if (valueBuilder == null) {
            valueBuilder = new ValueBuilder();
        }
        return valueBuilder;
    }

    public ValueObjectReference buildObjectReference(String string) {
        ValueObjectReference valueObjectReference = new ValueObjectReference();
        // todo: build value, store into heap and return pointer
        // heap.push(valueObjectReference);
        return null;
    }
}

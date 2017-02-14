package cz.cvut.fit.run.vm.runtime.operant;

import cz.cvut.fit.run.vm.VirtualMachine;
import cz.cvut.fit.run.vm.classfile.facade.FClass;
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
        FClass fClass = VirtualMachine.classProvider.getClass("java/lang/String");
        ValueObjectReference valueObjectReference = heap.createObject(fClass);

        // todo: build value, store into heap and return pointer
        // heap.push(valueObjectReference);
        return null;
    }
}

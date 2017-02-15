package cz.cvut.fit.run.vm.runtime.operant;

/**
 * Created by Keo on 15.2.2017.
 */
public class ValueArrayReference extends Value {
    public int size;
    public int heap;

    public ValueArrayReference(int heap, int size) {
        this.size = size;
        this.heap = heap;
    }

    @Override
    public Value copy() {
        return new ValueArrayReference(heap, size);
    }

    @Override
    public boolean isReference() {
        return true;
    }
}

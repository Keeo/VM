package cz.cvut.fit.run.vm.runtime.operant;

/**
 * Created by Keo on 15.2.2017.
 */
public class ValueArrayReference extends Value implements ReferenceInterface {
    public int heap = -1;
    public int size;

    public ValueArrayReference(int heap, int size) {
        this.size = size;
        this.heap = heap;
    }

    @Override
    public Value copy() {
        return new ValueArrayReference(heap, size);
    }

    public boolean isNull() {
        return heap == -1;
    }

    @Override
    public boolean isReference() {
        return true;
    }
}

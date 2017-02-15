package cz.cvut.fit.run.vm.runtime;

import com.sun.beans.decoder.ValueObject;
import cz.cvut.fit.run.vm.classfile.facade.FClass;
import cz.cvut.fit.run.vm.classfile.facade.FField;
import cz.cvut.fit.run.vm.runtime.java.lang.NString;
import cz.cvut.fit.run.vm.runtime.operant.Value;
import cz.cvut.fit.run.vm.runtime.operant.ValueArrayReference;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;
import cz.cvut.fit.run.vm.runtime.operant.ValueObjectReference;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

/**
 * Created by Keo on 9.12.2015.
 */
public class Heap {

    public Value[] heap;

    private int position;

    private static Heap instance;

    private Heap() {
        heap = new Value[999];
        position = 0;
    }

    public static Heap getInstance() {
        if (instance == null) {
            instance = new Heap();
        }
        return instance;
    }

    public ValueObjectReference createObject(FClass fClass) {
        ValueObjectReference valueObjectReference = new ValueObjectReference(fClass, position);
        FField[] fFields = fClass.getFields();
        for (int i = 0; i < fFields.length; ++i) {
            FField fField = fFields[i];
            switch (fField.getDescription()) {
                case "I":
                    heap[position] = new ValueInteger(0);
                    position++;
                    break;
                default:
                    System.out.println(fField.getDescription());
                    throw new NotImplementedException();
            }
        }

        return valueObjectReference;
    }

    public ValueArrayReference createArray(int type, int size) {
        ValueArrayReference valueArrayReference = new ValueArrayReference(position, size);
        for(int i = position; i < size + position; ++i) {
            switch (type) {
                case 5:
                case 10:
                    heap[i] = new ValueInteger(0);
                    break;
                default:
                    System.out.println("Creating array for type: " + type);
                    throw new NotImplementedException();
            }

        }
        position += size;

        return valueArrayReference;
    }

    public ValueArrayReference createObjectArray(FClass fClass, int size) {
        ValueArrayReference valueArrayReference = new ValueArrayReference(position, size);

        for(int i = position; i < size + position; ++i) {
            heap[i] = new ValueObjectReference(fClass, i);
        }
        position += size;

        return valueArrayReference;
    }

    public void reset() {
        instance = new Heap();
    }
}

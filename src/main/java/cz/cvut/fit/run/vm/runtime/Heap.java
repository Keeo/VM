package cz.cvut.fit.run.vm.runtime;

import com.sun.beans.decoder.ValueObject;
import cz.cvut.fit.run.vm.classfile.facade.FClass;
import cz.cvut.fit.run.vm.classfile.facade.FField;
import cz.cvut.fit.run.vm.runtime.java.lang.NString;
import cz.cvut.fit.run.vm.runtime.operant.Value;
import cz.cvut.fit.run.vm.runtime.operant.ValueObjectReference;

import java.util.ArrayList;

/**
 * Created by Keo on 9.12.2015.
 */
public class Heap {

    public ArrayList<Value> heap;

    private int position;

    private static Heap instance;

    private Heap() {
        heap = new ArrayList<>();
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
                case "[":
                    System.out.print("yey string");
                    break;
            }
        }

        return null;
    }
}

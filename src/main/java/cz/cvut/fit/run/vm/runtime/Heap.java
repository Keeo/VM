package cz.cvut.fit.run.vm.runtime;

import cz.cvut.fit.run.vm.runtime.operant.Value;

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
}

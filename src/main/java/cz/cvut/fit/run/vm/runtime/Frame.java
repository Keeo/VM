package cz.cvut.fit.run.vm.runtime;

import cz.cvut.fit.run.vm.classfile.facade.FMethod;
import cz.cvut.fit.run.vm.runtime.operant.Value;

import java.util.Stack;

/**
 * Created by Keo on 9.12.2015.
 */
public class Frame {
    int pc = 0;
    Stack<Value> stack = new Stack<>();
    Value[] locals;
    FMethod fMethod;

    public Frame(FMethod fMethod, Stack<Value> stack) {
        this.fMethod = fMethod;
        this.stack = stack;
        // todo: initialize locals array, fMethod should provide max local variables
    }
}

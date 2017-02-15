package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;

import java.util.Stack;

/**
 * Created by Keo on 22.12.2015.
 */
public abstract class Instruction {
    public abstract void execute(Frame frame, Stack<Frame> stack);

    public void echo(String suffix) {
        System.out.println("[I] " + this.getClassName() + " " + suffix);
    }

    public void echo() {
        this.echo("");
    }

    public int size() {
        return 1;
    }

    protected String getClassName() {
        String className = this.getClass().getName();
        return className.substring(className.lastIndexOf('.') + 1);
    }
}

package cz.cvut.fit.run.vm.runtime;

import cz.cvut.fit.run.vm.classfile.facade.FMethod;
import cz.cvut.fit.run.vm.runtime.instruction.Instruction;
import cz.cvut.fit.run.vm.runtime.instruction.InstructionBuilder;
import cz.cvut.fit.run.vm.runtime.operant.Value;

import java.util.Stack;

/**
 * Created by Keo on 9.12.2015.
 */
public class Frame {
    int pc = 0;
    public Stack<Value> stack;
    Value[] locals;
    public FMethod fMethod;

    public Frame(FMethod fMethod) {
        this.fMethod = fMethod;
        //this.stack = new Stack<>();
        this.locals = new Value[fMethod.getMaxLocals()];
    }

    public Instruction popInstruction() {
        InstructionBuilder instructionBuilder = new InstructionBuilder();
        return instructionBuilder.build(fMethod.getCode(), pc);
    }
}

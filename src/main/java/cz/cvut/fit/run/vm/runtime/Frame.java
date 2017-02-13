package cz.cvut.fit.run.vm.runtime;

import cz.cvut.fit.run.vm.classfile.facade.FMethod;
import cz.cvut.fit.run.vm.runtime.instruction.Instruction;
import cz.cvut.fit.run.vm.runtime.instruction.InstructionBuilder;
import cz.cvut.fit.run.vm.runtime.operant.Value;

import java.util.Stack;

/**
 * https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-2.html#jvms-2.6
 * Created by Keo on 9.12.2015.
 */
public class Frame {
    int pc = 0;
    public Stack<Value> operandStack;
    Value[] locals;
    public FMethod fMethod;

    public Frame(FMethod fMethod) {
        this.fMethod = fMethod;
        this.locals = new Value[fMethod.getMaxLocals()];
    }

    public Instruction popInstruction() {
        InstructionBuilder instructionBuilder = new InstructionBuilder();
        return instructionBuilder.build(fMethod.getCode(), pc++);
    }

    public void execute(Stack<Frame> frames) {
        while (pc < this.fMethod.getCode().length) {
            Instruction instruction = this.popInstruction();
            instruction.execute(this, frames);
            System.out.print("Executed exit");
            // todo: current code breaks here #2
            break;
        }
    }
}

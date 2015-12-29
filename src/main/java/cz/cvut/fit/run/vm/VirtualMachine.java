package cz.cvut.fit.run.vm;

import cz.cvut.fit.run.vm.classfile.ClassFileLoader;
import cz.cvut.fit.run.vm.classfile.ClassProvider;
import cz.cvut.fit.run.vm.classfile.facade.FMethod;
import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.instruction.Instruction;

import java.io.IOException;
import java.util.Stack;

/**
 * Created by Keo on 8.12.2015.
 */
public class VirtualMachine {
    ClassProvider classProvider = new ClassProvider(new ClassFileLoader());
    Stack<Frame> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        VirtualMachine virtualMachine = new VirtualMachine(args);
        virtualMachine.run();
    }

    public VirtualMachine(String[] classFiles) throws IOException {
        for (String classFile : classFiles) {
            classProvider.addClassFileFromPath(classFile);
        }

        FMethod fMethod = classProvider.getMainMethod();
        stack.push(new Frame(fMethod));
    }

    void run() {
        while (!stack.isEmpty()) {
            Frame frame = stack.peek();
            Instruction instruction = frame.popInstruction();
            instruction.execute(frame, stack);
            // todo: current code breaks here #2
            break;
        }
    }
}

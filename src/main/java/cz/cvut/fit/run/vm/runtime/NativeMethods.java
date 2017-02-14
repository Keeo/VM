package cz.cvut.fit.run.vm.runtime;

import cz.cvut.fit.run.vm.runtime.operant.Value;

import java.util.Stack;

/**
 * Created by Keo on 14.2.2017.
 */
public class NativeMethods {
    public static void invokeStatic(String className, String methodName, Frame frame, Stack<Frame> stack) {
        String fullName = className + "::" + methodName;

        switch (methodName) {
            case "print":
                print(frame, stack);
                break;
            default:
                throw new RuntimeException("Unknown native method: " + fullName);

        }
    }

    static void print(Frame frame, Stack<Frame>  stack) {
        Value v = frame.operandStack.pop();
        if (!v.isReference()) {
            System.out.println("[N] Print: \"" + v.toString() + "\"");
        } else {
            System.out.println("Asked to print reference but that is not implemented.");
        }
    }
}

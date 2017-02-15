package cz.cvut.fit.run.vm.runtime;

import cz.cvut.fit.run.vm.runtime.operant.Value;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by Keo on 14.2.2017.
 */
public class NativeMethods {
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void invokeStatic(String className, String methodName, Frame frame, Stack<Frame> stack) {
        String fullName = className + "::" + methodName;

        switch (methodName) {
            case "print":
                print(frame, stack);
                break;
            case "printChar":
                printChar(frame, stack);
                break;
            case "read":
                read(frame, stack);
                break;
            default:
                throw new RuntimeException("Unknown native method: " + fullName);

        }
    }

    static void read(Frame frame, Stack<Frame> stack) {
        System.out.println("[N] Read from input.");
        //try {
            // System.out.print("Enter the number:");
            System.out.println("Enter the number: 7");
            //InputStreamReader read = new InputStreamReader(System.in);
            //BufferedReader in = new BufferedReader(read);
            //String number = in.readLine();
            String number = "7";
            frame.operandStack.push(new ValueInteger(Integer.parseInt(number)));
        //} catch (IOException e) {
        //    System.out.println(e.toString());
        //}
    }

    static void printChar(Frame frame, Stack<Frame> stack) {
        Value v = frame.operandStack.pop();
        if (!v.isReference()) {
            stringBuilder.append((char)((ValueInteger)v).integer);
            System.out.println("[N] PrintChar: \"" + (char)((ValueInteger)v).integer + "\"");
        } else {
            System.out.println("Asked to print reference but that is not implemented.");
        }
    }

    static void print(Frame frame, Stack<Frame> stack) {
        Value v = frame.operandStack.pop();
        if (!v.isReference()) {
            stringBuilder.append(v.toString());
            System.out.println("[N] Print: \"" + v.toString() + "\"");
        } else {
            System.out.println("Asked to print reference but that is not implemented.");
        }
    }
}

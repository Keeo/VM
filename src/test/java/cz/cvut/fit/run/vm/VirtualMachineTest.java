package cz.cvut.fit.run.vm;

import static org.junit.Assert.assertEquals;

import cz.cvut.fit.run.vm.runtime.NativeMethods;
import org.junit.Test;

/**
 * Created by Keo on 9.12.2015.
 */
public class VirtualMachineTest {

    String satSolver;
    String expression;
    String expressionLink;
    String stack;

    @org.junit.Before
    public void setUp() throws Exception {
        satSolver = "src/test/fixtures/sat/SatSolver.class";
        expression = "src/test/fixtures/sat/Expression.class";
        expressionLink= "src/test/fixtures/sat/ExpressionLink.class";
        stack = "src/test/fixtures/sat/Stack.class";
    }

    @Test
    public void testMain() throws Exception {
        VirtualMachine virtualMachine = new VirtualMachine(new String[]{satSolver, expression, expressionLink, stack});
        virtualMachine.run();
        assertEquals("abcd\n1100", NativeMethods.stringBuilder.toString());
    }

    @Test
    public void simple() throws Exception {
        VirtualMachine virtualMachine = new VirtualMachine(new String[]{"src/test/fixtures/demo/Simple.class"});
        virtualMachine.run();
        assertEquals("6", NativeMethods.stringBuilder.toString());
    }

    @Test
    public void math() throws Exception {
        VirtualMachine virtualMachine = new VirtualMachine(new String[]{"src/test/fixtures/demo/Math.class"});
        virtualMachine.run();
        assertEquals("49", NativeMethods.stringBuilder.toString());
    }

    @Test
    public void function() throws Exception {
        VirtualMachine virtualMachine = new VirtualMachine(new String[]{"src/test/fixtures/demo/Function.class"});
        virtualMachine.run();
        assertEquals("0919", NativeMethods.stringBuilder.toString());
    }

    @Test
    public void simpleIO() throws Exception {
        VirtualMachine virtualMachine = new VirtualMachine(new String[]{"src/test/fixtures/demo/SimpleIO.class"});
        virtualMachine.run();
        assertEquals("8", NativeMethods.stringBuilder.toString());
    }

    @Test
    public void newClassSimple() throws Exception {
        VirtualMachine virtualMachine = new VirtualMachine(new String[]{"src/test/fixtures/demo/NewClassSimple.class"});
        virtualMachine.run();
        assertEquals("5", NativeMethods.stringBuilder.toString());
    }

    @Test
    public void newClass() throws Exception {
        VirtualMachine virtualMachine = new VirtualMachine(new String[]{"src/test/fixtures/demo/NewClass.class"});
        virtualMachine.run();
        assertEquals("7777", NativeMethods.stringBuilder.toString());
    }

    @Test
    public void setClassProperty() throws Exception {
        VirtualMachine virtualMachine = new VirtualMachine(new String[]{"src/test/fixtures/demo/SetClassProperty.class"});
        virtualMachine.run();
        assertEquals("6", NativeMethods.stringBuilder.toString());
    }

    @Test
    public void complexNumber() throws Exception {
        VirtualMachine virtualMachine = new VirtualMachine(new String[]{"src/test/fixtures/demo/ComplexNumber.class"});
        virtualMachine.run();
        assertEquals("46", NativeMethods.stringBuilder.toString());
    }

    @Test
    public void loops() throws Exception {
        VirtualMachine virtualMachine = new VirtualMachine(new String[]{"src/test/fixtures/demo/Loops.class"});
        virtualMachine.run();
        assertEquals("4515", NativeMethods.stringBuilder.toString());
    }

    @Test
    public void array() throws Exception {
        VirtualMachine virtualMachine = new VirtualMachine(new String[]{"src/test/fixtures/demo/Array.class"});
        virtualMachine.run();
        assertEquals("012", NativeMethods.stringBuilder.toString());
    }

    @Test
    public void arrayComplex() throws Exception {
        VirtualMachine virtualMachine = new VirtualMachine(new String[]{"src/test/fixtures/demo/ArrayComplex.class"});
        virtualMachine.run();
        assertEquals("32106", NativeMethods.stringBuilder.toString());
    }

    @Test
    public void chars() throws Exception {
        VirtualMachine virtualMachine = new VirtualMachine(new String[]{"src/test/fixtures/demo/Chars.class"});
        virtualMachine.run();
        assertEquals("aabc", NativeMethods.stringBuilder.toString());
    }

    @Test
    public void arrayClasses() throws Exception {
        VirtualMachine virtualMachine = new VirtualMachine(new String[]{"src/test/fixtures/demo/ArrayClasses.class"});
        virtualMachine.run();
        assertEquals("9", NativeMethods.stringBuilder.toString());
    }

    @Test
    public void nullPointer() throws Exception {
        VirtualMachine virtualMachine = new VirtualMachine(new String[]{"src/test/fixtures/demo/NullPointer.class"});
        virtualMachine.run();
        assertEquals("1", NativeMethods.stringBuilder.toString());
    }

    @Test
    public void switches() throws Exception {
        VirtualMachine virtualMachine = new VirtualMachine(new String[]{"src/test/fixtures/demo/Switches.class"});
        virtualMachine.run();
        assertEquals("KDQD", NativeMethods.stringBuilder.toString());
    }

    @Test
    public void conditions() throws Exception {
        VirtualMachine virtualMachine = new VirtualMachine(new String[]{"src/test/fixtures/demo/Conditions.class"});
        virtualMachine.run();
        assertEquals("BBBAA", NativeMethods.stringBuilder.toString());
    }

    @Test
    public void shifts() throws Exception {
        VirtualMachine virtualMachine = new VirtualMachine(new String[]{"src/test/fixtures/demo/Shifts.class"});
        virtualMachine.run();
        assertEquals("182\n364\n728\n1456\n2912\n5824\n11648\n23296\n46592\n93184\n",
                NativeMethods.stringBuilder.toString());
    }
}

package cz.cvut.fit.run.vm;

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
    }

    @Test
    public void simple() throws Exception {
        VirtualMachine virtualMachine = new VirtualMachine(new String[]{"src/test/fixtures/demo/Simple.class"});
        virtualMachine.run();
    }

    @Test
    public void math() throws Exception {
        VirtualMachine virtualMachine = new VirtualMachine(new String[]{"src/test/fixtures/demo/Math.class"});
        virtualMachine.run();
    }

    @Test
    public void function() throws Exception {
        VirtualMachine virtualMachine = new VirtualMachine(new String[]{"src/test/fixtures/demo/Function.class"});
        virtualMachine.run();
    }
}

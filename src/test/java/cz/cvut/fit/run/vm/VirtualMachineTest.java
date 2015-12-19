package cz.cvut.fit.run.vm;

import org.junit.Test;

/**
 * Created by Keo on 9.12.2015.
 */
public class VirtualMachineTest {

    String satSolver;
    String expression;

    @org.junit.Before
    public void setUp() throws Exception {
        satSolver = "src/test/fixtures/sat/SatSolver.class";
        expression = "src/test/fixtures/sat/Expression.class";
    }

    @Test
    public void testMain() throws Exception {
        VirtualMachine.main(new String[]{satSolver, expression});
    }
}

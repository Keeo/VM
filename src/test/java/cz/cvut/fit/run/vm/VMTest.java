package cz.cvut.fit.run.vm;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Keo on 9.12.2015.
 */
public class VMTest {

    String satSolver;
    String expression;

    @org.junit.Before
    public void setUp() throws Exception {
        satSolver = "src/test/fixtures/sat/SatSolver.class";
        expression = "src/test/fixtures/sat/Expression.class";
    }

    @Test
    public void testMain() throws Exception {
        VM.main(new String[]{satSolver, expression});
    }
}
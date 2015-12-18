package cz.cvut.fit.run.sat;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Keo on 18.12.2015.
 */
public class SatSolverTest {

    @Test
    public void testSolve() throws Exception {
        Expression expression = buildDummyExpression();
        boolean[] result = SatSolver.solve(expression, 3);

        assertEquals(3, result.length);
        assertTrue(Arrays.equals(new boolean[]{true, true, false}, result));
    }

    @Test
    public void testVariableCount() throws Exception {
        int count = SatSolver.variableCount("ab&c&d");
        assertEquals(4, count);
    }

    @Test
    public void testBuildTree() throws Exception {
        String tree = SatSolver.buildTree("ab&!c|").toString();
        assertEquals("(!(a & b) | c)", tree);
    }

    protected Expression buildDummyExpression() {
        Expression root = new Expression();
        root.operator = SatSolver.AND;
        root.left = new Expression();
        root.left.name = 'a';

        Expression right = new Expression();
        right.right = new Expression();
        right.right.name = 'b';
        right.left = new Expression();
        right.left.name = 'c';
        right.operator = SatSolver.OR;

        root.right = right;

        return root;
    }
}
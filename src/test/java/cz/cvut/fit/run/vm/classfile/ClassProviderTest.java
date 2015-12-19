package cz.cvut.fit.run.vm.classfile;

import cz.cvut.fit.run.vm.classfile.facade.FClass;
import cz.cvut.fit.run.vm.classfile.facade.FMethod;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Keo on 9.12.2015.
 */
public class ClassProviderTest {

    String satSolver;
    String expression;

    @org.junit.Before
    public void setUp() throws Exception {
        satSolver = "src/test/fixtures/sat/SatSolver.class";
        expression = "src/test/fixtures/sat/Expression.class";
    }

    @Test
    public void testGetMainMethod() throws Exception {
        ClassProvider classProvider = loadClassLoader();
        FMethod fMethod = classProvider.getMainMethod();
        assertNotNull(fMethod);
    }

    @Test
    public void testAddClassFileFromPath() throws Exception {
        ClassProvider classProvider = loadClassLoader();
        FClass fClassSatSolver = classProvider.classes.get("cz/cvut/fit/run/sat/SatSolver");
        assertNotNull(fClassSatSolver);
        FClass fClassExpression = classProvider.classes.get("cz/cvut/fit/run/sat/Expression");
        assertNotNull(fClassExpression);
    }

    ClassProvider loadClassLoader() throws Exception {
        ClassProvider classProvider = new ClassProvider(new ClassFileLoader());
        classProvider.addClassFileFromPath(satSolver);
        classProvider.addClassFileFromPath(expression);
        return classProvider;
    }
}

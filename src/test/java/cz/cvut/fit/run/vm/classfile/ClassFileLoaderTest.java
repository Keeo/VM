package cz.cvut.fit.run.vm.classfile;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by Keo on 8.12.2015.
 */
public class ClassFileLoaderTest {

    InputStream satSolverClass;
    InputStream expressionClass;

    @org.junit.Before
    public void setUp() throws Exception {
        satSolverClass = new FileInputStream("src/test/fixtures/sat/SatSolver.class");
        expressionClass = new FileInputStream("src/test/fixtures/sat/Expression.class");
    }

    @org.junit.Test
    public void testLoadSatSolverClassFile() throws Exception {
        ClassFileLoader cfl = new ClassFileLoader();
        ClassFile cf = cfl.loadClassFile(satSolverClass);
        assertEquals(51, cf.majorVersion);
        assertEquals(0, cf.minorVersion);
    }

    @org.junit.Test
    public void testLoadExpressionClassFile() throws Exception {
        ClassFileLoader cfl = new ClassFileLoader();
        ClassFile cf = cfl.loadClassFile(expressionClass);
        assertEquals(51, cf.majorVersion);
        assertEquals(0, cf.minorVersion);
    }

    @org.junit.Test
    public void isJavaClassFile() throws Exception {
        ClassFileLoader cfl = new ClassFileLoader();
        byte[] cafebabe = new byte[]{(byte) 0xCA, (byte) 0xFE, (byte) 0xBA, (byte) 0xBE};
        assertTrue(cfl.isJavaClassFile(new DataInputStream(new ByteArrayInputStream(cafebabe))));
        assertFalse(cfl.isJavaClassFile(new DataInputStream(IOUtils.toInputStream("nopenope"))));
    }

    @org.junit.Test
    public void loadVersion() throws Exception {
        ClassFileLoader cfl = new ClassFileLoader();
        ClassFile classFile = new ClassFile();
        cfl.loadVersion(classFile, new DataInputStream(new ByteArrayInputStream(new byte[]{(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x33})));
        assertEquals(51, classFile.majorVersion);
        assertEquals(0, classFile.minorVersion);
    }
}

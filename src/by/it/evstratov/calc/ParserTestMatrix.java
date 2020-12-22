package by.it.evstratov.calc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTestMatrix {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
    }

    @Test
    public void addTest() throws CalcException {
        Matrix matrix = (Matrix)parser.calc("{{1,2,3},{4,5,6}}+2");
        double[][] actual = matrix.getValue();
        double[][] expected = {{3,4,5},{6,7,8}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);
        }
        matrix = (Matrix)parser.calc("{{1,2,3},{4,5,6}}+{{1,2,3},{4,5,6}}");
        actual = matrix.getValue();
        expected = new double[][]{{2, 4, 6},{8, 10, 12}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);
        }
    }

    @Test
    public void subTest() throws CalcException {
        Matrix matrix = (Matrix)parser.calc("{{1,2,3},{4,5,6}}-3");
        double[][] actual = matrix.getValue();
        double[][] expected = {{-2,-1,0},{1,2,3}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);
        }
        matrix = (Matrix)parser.calc("{{8,6,5},{2,6,1}}-{{2,2,2},{1,1,1}}");
        actual = matrix.getValue();
        expected = new double[][]{{6, 4, 3},{1, 5, 0}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);
        }
    }

    @Test
    public void mulTest() throws CalcException {
        Scalar scalar = (Scalar)parser.calc("{2,6}*{0,2}");
        double actual = scalar.getValue();
        assertEquals (12, actual, 1e-5);
        Vector vector = (Vector)parser.calc("{2,6}*5");
        double[] expected = {10,30};
        double[] actual2 = vector.getValue();
        assertArrayEquals (expected, actual2, 1e-5);
    }

    @Test
    public void expression() throws CalcException {
        Matrix matrix = (Matrix)parser.calc("M={{1,2,3},{4,5,6}}*2");
        double[][] actual = matrix.getValue();
        double[][] expected = {{2,4,6},{8,10,12}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);
        }
        matrix = (Matrix)parser.calc("M={{1,2,3},{4,5,6}}*2+4");
        actual = matrix.getValue();
        expected = new double[][]{{6, 8, 10}, {12, 14, 16}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);
        }
        matrix = (Matrix)parser.calc("M={{1,2,3},{4,5,6}}+4*2");
        actual = matrix.getValue();
        expected = new double[][]{{9,10,11},{12,13,14}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);
        }
        matrix = (Matrix)parser.calc("M={{1,2,3},{4,5,6}}+4*2+{{0,2,0},{2,1,3}}");
        actual = matrix.getValue();
        expected = new double[][]{{9,12,11},{14,14,17}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);
        }
    }

    @After
    public void tearDown() throws Exception {
    }
}
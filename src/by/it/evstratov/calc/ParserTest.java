package by.it.evstratov.calc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
    }

    @Test
    public void addTestScalar() throws CalcException {
        Var actualScalar = parser.calc("2+2+7+8");
        double actual = Double.parseDouble(actualScalar.toString());
        double expected = 19.0;
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void expressionScalars() throws CalcException {
        double actual = Double.parseDouble(parser.calc("A=2+5.3").toString());
        assertEquals(7.3, actual, 1e-5);
        actual = Double.parseDouble(parser.calc("B=A*3.5").toString());
        assertEquals(25.55, actual, 1e-5);
        actual = Double.parseDouble(parser.calc("B1=B+0.11*-5").toString());
        assertEquals(25, actual, 1e-5);
        actual = Double.parseDouble(parser.calc("B2=A/2-1").toString());
        assertEquals(2.65, actual, 1e-5);
        actual = Double.parseDouble(parser.calc("C=B+(A*2)").toString());
        assertEquals(40.15, actual, 1e-5);
        actual = Double.parseDouble(parser.calc("D=((C-0.15)-20)/(7-5)").toString());
        assertEquals(10, actual, 1e-5);
    }

    @Test
    public void expressionVectors() throws CalcException {
        Vector vector = (Vector)parser.calc("V={1,2,3}*2+{4,5,6}");
        double[] actual = vector.getValue();
        double[] expected = {6,9,12};
        assertArrayEquals(expected, actual, 1e-5);
        vector = (Vector)parser.calc("E={2,3}*(D/2)");
        expected = new double[]{10,15};
        actual = vector.getValue();
        assertArrayEquals(expected, actual, 1e-5);
    }

    @Test
    public void expressionMatrix() throws CalcException {
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
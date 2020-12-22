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
    public void addTest() throws CalcException {
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
        //actual = Double.parseDouble(parser.calc("C=B+(A*2)").toString());
        //assertEquals(40.15, actual, 1e-5);
    }

    @Test
    public void expressionVectors() throws CalcException {
        Vector vector = (Vector)parser.calc("V={1,2,3}*2+{4,5,6}");
        double[] actual = vector.getValue();
        double[] expected = {6,9,12};
        assertArrayEquals(expected, actual, 1e-5);
    }

    @After
    public void tearDown() throws Exception {

    }
}
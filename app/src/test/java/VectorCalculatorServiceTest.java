import com.amv.VectorCalculatorService;

import org.junit.Test;

import static junit.framework.Assert.fail;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

// Haisin Yip - 260480026
// Eric Liou -

public class VectorCalculatorServiceTest {

    private double delta = 0.00000001;

    /* vector product tests */

    // 1
    @Test(expected=IllegalArgumentException.class)
    public void testNumArgsLessThan4_crossProduct (){
        VectorCalculatorService.crossProduct("1", null, null, null);
    }

    // 5
    @Test(expected=NumberFormatException.class)
    public void testArgsNotInt_crossProduct(){
        VectorCalculatorService.crossProduct("A", "B", "C", "D");
    }

    // 8
    @Test
    public void testCartesianGeneralInput_crossProduct() {
        VectorCalculatorService.polar = false;
        double[] actual = VectorCalculatorService.crossProduct("1", "2", "3", "4");
        double[] expected = {0,0,-2.0};
        assertArrayEquals(actual, expected, delta);
    }

    // 9
    @Test
    public void testPolarGeneralInput_crossProduct() {
        VectorCalculatorService.polar = true;
        double[] actual = VectorCalculatorService.crossProduct("1", "45", "3", "90");
        double[] expected = {0,0,1.5*Math.sqrt(2.0)};
        assertArrayEquals(actual, expected, delta);
    }

    /* scalar product tests */

    // 2
    @Test(expected=IllegalArgumentException.class)
    public void testNumArgsLessThan4_scalarProduct (){
        VectorCalculatorService.scalarProduct("1", null, null, null);
    }

    // 6
    @Test(expected=NumberFormatException.class)
    public void testArgsNotInt_scalarProduct(){
        VectorCalculatorService.scalarProduct("A","B","C","D");
    }

    // 10
    @Test
    public void testCartesianGeneralInput_scalarProduct() {
        VectorCalculatorService.polar = false;
        double actual = VectorCalculatorService.scalarProduct("1", "2", "3", "4");
        double expected = 11.0;
        assertEquals(actual, expected, delta);
    }

    // 11
    @Test
    public void testPolarGeneralInput_scalarProduct() {
        VectorCalculatorService.polar = true;
        double actual = VectorCalculatorService.scalarProduct("1","45","3","90");
        double expected = 1.5*Math.sqrt(2.0);
        assertEquals(expected, actual, delta);
    }

    /* vector addition tests */

    // 3
    @Test(expected=IllegalArgumentException.class)
    public void testNumArgsLessThan4_for_first_4_inputs_vectorAddition (){
        VectorCalculatorService.vectorAddition("1", null, null, null, null, null);
    }

    // 4
    @Test(expected=IllegalArgumentException.class)
    public void test3rdVectorIncompleteWithOther2Complete_vectorAddition (){
        VectorCalculatorService.vectorAddition("1", "1", "1", "1", "1", null);
    }

    // 7
    @Test(expected=NumberFormatException.class)
    public void testArgsNotInt_vectorAddition(){
        VectorCalculatorService.vectorAddition("A", "B", "C", "D", "E", "F");
    }

    // 12
    @Test
    public void testCartesianGeneralInputWith2Vectors_vectorAddition() {
        VectorCalculatorService.polar = false;
        double[] actual = VectorCalculatorService.vectorAddition("1", "2", "3", "4", null, null);
        double[] expected = {4,6};
        assertArrayEquals(actual, expected, delta);
    }

    // 13
    @Test
    public void testCartesianGeneralInputWith3Vectors_vectorAddition() {
        VectorCalculatorService.polar = false;
        double[] actual = VectorCalculatorService.vectorAddition("1", "2", "3", "4", "5", "6");
        double[] expected = {9,12};
        assertArrayEquals(expected, actual, delta);
    }

    // 14
    @Test
    public void testPolarGeneralInput_vectorAddition() {
        VectorCalculatorService.polar = true;
        double[] actual = VectorCalculatorService.vectorAddition("1", "45", "3", "90", null, null);
        double[] expected = {0.5*Math.sqrt(2.0),3+0.5*Math.sqrt(2.0)};
        assertArrayEquals(expected, actual, delta);
    }
}

package recursion;

import org.junit.Test;
import static org.junit.Assert.*;

public class RecursiveSumOfDigitsTest {

    @Test
    public void testZero() {
        assertEquals(0, RecursiveSumOfDigits.sumOfDigits(0));
    }

    @Test
    public void testSingleDigit() {
        assertEquals(5, RecursiveSumOfDigits.sumOfDigits(5));
    }

    @Test
    public void testPositiveNumber() {
        assertEquals(15, RecursiveSumOfDigits.sumOfDigits(12345));
    }

    @Test
    public void testLargeNumber() {
        assertEquals(39, RecursiveSumOfDigits.sumOfDigits(987654));
    }

    @Test
    public void testNegativeNumber() {
        assertEquals(15, RecursiveSumOfDigits.sumOfDigits(-12345));
    }
}

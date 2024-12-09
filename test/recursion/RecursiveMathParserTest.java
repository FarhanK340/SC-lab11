package recursion;
import org.junit.Test;
import static org.junit.Assert.*;

public class RecursiveMathParserTest {

    @Test
    public void testSimpleExpression() {
        assertEquals(13.0, RecursiveMathParser.evaluateExpression("3 + 5 * 2"), 0.0001);
    }

    @Test
    public void testExpressionWithParentheses() {
        assertEquals(13.0, RecursiveMathParser.evaluateExpression("3 + (5 * 2)"), 0.0001);
    }

    @Test
    public void testExpressionWithDivision() {
        assertEquals(8.0, RecursiveMathParser.evaluateExpression("10 / 2 + 3"), 0.0001);
    }

    @Test
    public void testExpressionWithFloatingPoint() {
        assertEquals(5.5, RecursiveMathParser.evaluateExpression("3 + 5 / 2.0"), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidExpressionEmpty() {
        RecursiveMathParser.evaluateExpression("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidExpressionUnmatchedParentheses() {
        RecursiveMathParser.evaluateExpression("3 + (5 * 2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidExpressionInvalidNumber() {
        RecursiveMathParser.evaluateExpression("3 + 5 * abc");
    }
}


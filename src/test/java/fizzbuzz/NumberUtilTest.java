package fizzbuzz;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Test;
import fizzbuzz.util.NumberUtil;

public class NumberUtilTest {

    @Test
    public void testPositive15() throws BadNumberException {
        test15(true);
    }

    @Test
    public void testNegative15() throws BadNumberException {
        test15(false);
    }

    private void test15(boolean positive) throws BadNumberException {
        FizzBuzzResult result = NumberUtil.categorizeFizzBuzz(positive ? 15 : -15);
        FizzBuzzResult expected = getExpected15();
        assertEquals(expected, result);
    }

    public static FizzBuzzResult getExpected15() {
        FizzBuzzResult expected = new FizzBuzzResult();
        Collections.addAll(expected.getFizz(), 3, 6, 9, 12);
        Collections.addAll(expected.getBuzz(), 5, 10);
        Collections.addAll(expected.getFizzBuzz(), 15);
        return expected;
    }

    @Test
    public void hasNoCategorizes() throws BadNumberException {
        FizzBuzzResult result = NumberUtil.categorizeFizzBuzz(0);
        FizzBuzzResult expected = new FizzBuzzResult();
        assertEquals(expected, result);
    }

    @Test(expected = BadNumberException.class)
    public void expectedBadNull() throws BadNumberException {
        NumberUtil.categorizeFizzBuzz(null);
    }

    @Test(expected = BadNumberException.class)
    public void expectedBadNaN() throws BadNumberException {
        NumberUtil.categorizeFizzBuzz("hello world");
    }

}

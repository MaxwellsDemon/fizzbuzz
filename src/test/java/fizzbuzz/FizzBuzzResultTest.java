package fizzbuzz;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FizzBuzzResultTest {

    /**
     * The result map should be sorted
     */
    @Test
    public void testSerializationOrder() {
        FizzBuzzResult expected15 = NumberUtilTest.getExpected15();
        String text = expected15.toString();
        assertEquals("{\"Fizz\":[3,6,9,12],\"Buzz\":[5,10],\"FizzBuzz\":[15]}", text);
    }

}

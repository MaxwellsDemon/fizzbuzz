package fizzbuzz.util;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import fizzbuzz.BadNumberException;
import fizzbuzz.Category;
import fizzbuzz.FizzBuzzResult;

/**
 * Utility for categorizing FizzBuzz numbers
 * 
 * @author Curtis Fleming
 */
public class NumberUtil {

    private NumberUtil() {
        // static utility
    }

    /**
     * <p>
     * Identifies multiples of "3 but not 5" as "Fizz", "5 but not 3" as "Buzz", and
     * "both 3 and 5" as "FizzBuzz".
     * 
     * @param value
     *            An integer
     * @return A non-null result categorization
     * @throws BadNumberException
     */
    public static FizzBuzzResult categorizeFizzBuzz(String value) throws BadNumberException {
        if (value == null || value.isEmpty()) {
            throw new BadNumberException("FizzBuzz requires an integer");
        }
        int parsedValue;
        try {
            parsedValue = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new BadNumberException("FizzBuzz requires an integer", e);
        }
        return categorizeFizzBuzz(parsedValue);
    }

    /**
     * See {@link #categorizeFizzBuzz(String)}
     * 
     * @param value
     * @return A non-null result categorization
     * @throws BadNumberException
     */
    public static FizzBuzzResult categorizeFizzBuzz(int value) throws BadNumberException {
        return new FizzBuzzResult(

                IntStream.rangeClosed(1, Math.abs(value))

                        .filter(i -> categorizer(i) != null) // Drop uncategorized values (avoids NPE during grouping)

                        .boxed()

                        .collect(Collectors.groupingBy(NumberUtil::categorizer))

        );
    }

    /**
     * Identifies multiples of "3 but not 5" as {@link Category#FIZZ}, "5 but not 3"
     * as {@link Category#BUZZ}, and "both 3 and 5" as {@link Category#FIZZBUZZ}
     * 
     * @param i
     *            value
     * @return The appropriate category or <code>null</code>
     */
    public static Category categorizer(int i) {
        final boolean three = i % 3 == 0;
        final boolean five = i % 5 == 0;
        if (three && !five) {
            return Category.FIZZ;
        } else if (!three && five) {
            return Category.BUZZ;
        } else if (three && five) {
            return Category.FIZZBUZZ;
        }
        return null;
    }

}

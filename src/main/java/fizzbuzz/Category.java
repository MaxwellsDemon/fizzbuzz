package fizzbuzz;

import com.fasterxml.jackson.annotation.JsonValue;

import fizzbuzz.util.NumberUtil;

/**
 * The FizzBuzz allowed categories. Association of categories is captured in
 * {@link NumberUtil#categorizer(int)}.
 * 
 * @author Curtis Fleming
 */
public enum Category {

    FIZZ("Fizz"),

    BUZZ("Buzz"),

    FIZZBUZZ("FizzBuzz");

    private final String jsonName;

    private Category(String jsonName) {
        this.jsonName = jsonName;
    }

    @JsonValue
    @Override
    public String toString() {
        return jsonName;
    }

}

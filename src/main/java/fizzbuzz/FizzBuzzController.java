package fizzbuzz;

import org.springframework.web.bind.annotation.RestController;

import fizzbuzz.util.NumberUtil;

import java.util.List;
import java.util.SortedMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 * <code>GET /fizzbuzz/{value}</code>
 * 
 * <p>
 * Identifies multiples of "3 but not 5" as "Fizz", "5 but not 3" as "Buzz", and
 * "both 3 and 5" as "FizzBuzz".
 * 
 * @author Curtis Fleming
 * @see NumberUtil
 */
@RestController
public class FizzBuzzController {

    // Requirement: GET-only verb, others are not allowed
    @GetMapping("/fizzbuzz/{value}")
    public SortedMap<Category, List<Integer>> fizzBuzz(@PathVariable String value) throws BadNumberException {

        return NumberUtil.categorizeFizzBuzz(value).getResult();
    }

}
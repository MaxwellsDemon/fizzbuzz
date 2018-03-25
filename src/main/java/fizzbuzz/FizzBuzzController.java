package fizzbuzz;

import org.springframework.web.bind.annotation.RestController;

import fizzbuzz.util.NumberUtil;

import java.util.List;
import java.util.SortedMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * GET /fizzbuzz/{value}
 * 
 * @author Curtis Fleming
 */
@RestController
public class FizzBuzzController {

    // Requirement: GET-only
    @GetMapping("/fizzbuzz/{value}")
    public SortedMap<Category, List<Integer>> fizzBuzz(@PathVariable String value) throws BadNumberException {

        return NumberUtil.categorizeFizzBuzz(value).getResult();
    }

}
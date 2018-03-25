package fizzbuzz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FizzBuzzResult {

    private SortedMap<Category, List<Integer>> result;

    public FizzBuzzResult() {
        this(new HashMap<>());
    }

    public FizzBuzzResult(Map<Category, List<Integer>> categorization) {
        this.result = new TreeMap<>();
        for (Category cat : Category.values()) {
            if (categorization.containsKey(cat)) {
                result.put(cat, categorization.get(cat));
            } else {
                result.put(cat, new ArrayList<>());
            }
        }
    }

    /**
     * A living map, update as desired to change the backing object
     * 
     * @return
     */
    public SortedMap<Category, List<Integer>> getResult() {
        return result;
    }

    /**
     * A living collection, update as desired to change the backing object
     * 
     * @return Non-null Set
     */
    public List<Integer> getFizz() {
        return result.get(Category.FIZZ);
    }

    /**
     * A living collection, update as desired to change the backing object
     * 
     * @return Non-null Set
     */
    public List<Integer> getBuzz() {
        return result.get(Category.BUZZ);
    }

    /**
     * A living collection, update as desired to change the backing object
     * 
     * @return Non-null Set
     */
    public List<Integer> getFizzBuzz() {
        return result.get(Category.FIZZBUZZ);
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(getResult());
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Could not write JSON for " + getClass().getSimpleName(), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof FizzBuzzResult)) {
            return false;
        }
        FizzBuzzResult other = (FizzBuzzResult) obj;
        if (result == null) {
            if (other.result != null) {
                return false;
            }
        } else if (!result.equals(other.result)) {
            return false;
        }
        return true;
    }

}

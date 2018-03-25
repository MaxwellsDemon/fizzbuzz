package fizzbuzz;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * FizzBuzz end-point number parameter is not valid
 * 
 * @author Curtis Fleming
 */
@ResponseStatus
public class BadNumberException extends Exception {

    private static final long serialVersionUID = 1L;

    public BadNumberException(String message) {
        super(message);
    }

    public BadNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}

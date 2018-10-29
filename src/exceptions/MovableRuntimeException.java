package exceptions;

/**
 * Created by sgrecu on 10/22/2018.
 */
public class MovableRuntimeException extends RuntimeException {
    public MovableRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}

package exceptions;

/**
 * Created by sgrecu on 10/22/2018.
 */

public class InvalidMoveException extends MovableException {
    public InvalidMoveException(String message) {
        super(message);
    }
}

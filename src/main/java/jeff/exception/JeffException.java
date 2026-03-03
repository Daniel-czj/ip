package jeff.exception;

/**
 * Represents exceptions specific to the Jeff application.
 * Thrown when user input is invalid or an expected condition is not met.
 */
public class JeffException extends Exception {

    /**
     * Constructs a JeffException with the given error message.
     *
     * @param message The error message to display to the user.
     */
    public JeffException(String message) {
        super(message);
    }
}

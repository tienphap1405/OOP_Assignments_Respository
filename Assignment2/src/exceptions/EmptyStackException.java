package exceptions;

/**
 * Exception that is thrown when stack is empty
 * @author Tien Phap (Evan Nguyen), Simon Luna Patiarroy
 */
public class EmptyStackException extends Exception {
    
    public EmptyStackException() {
        super("Empty Stack!");
    }
}

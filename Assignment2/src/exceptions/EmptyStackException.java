package exceptions;

/**
 *
 * @author Tien Phap (Evan Nguyen), Simon Luna Patiarroy
 */
public class EmptyStackException extends Exception {
    
    public EmptyStackException() {
        super("Empty Stack!");
    }
}

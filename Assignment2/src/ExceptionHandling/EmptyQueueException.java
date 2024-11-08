package ExceptionHandling;

/**
 *
 * @author Tien Phap (Evan Nguyen), Simon Luna Patiarroy
 */
public class EmptyQueueException extends Exception{
    
    public EmptyQueueException(){
        super("Empty Queue!!");
    }

}

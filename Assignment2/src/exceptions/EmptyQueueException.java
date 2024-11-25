package exceptions;

/**
 * Exception that is thrown when a queue is empty
 * @author Tien Phap (Evan Nguyen), Simon Luna Patiarroy
 */
public class EmptyQueueException extends Exception{
    
    public EmptyQueueException(){
        super("Empty Queue!!");
    }

}

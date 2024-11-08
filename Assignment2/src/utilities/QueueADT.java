package utilities;

import ExceptionHandling.EmptyQueueException;

/**
 * This ADT defines the definition of the Queue Data Structure
 * All the methods and functionalities in this interface must be implemented
 * when creating a Queue Data Structure
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 * @param <E> the generic type of elements
 */
public interface QueueADT<E> {
    
    /**
    * Adds an element to the end of the queue.
    * 
    * Pre-condition: The element must not be null.
    * Post-condition: The element is added to the end of the queue, 
    *                 and the queue size increases by one.
    * 
    * @param element The element to add to the queue
    * @throws NullPointerException if the specified element is null
    */
    public void enqueue(E element) throws NullPointerException;
    
    
    /**
     * Removes and returns the first element from the queue.
     * 
     * Pre-condition: The queue must contain at least one element.
     * Post condition: The first element is removed from the queue and
     *                 the queue size decreases by one.
     * 
     * @return The element that was removed from the queue
     * @throws EmptyQueueException if the queue is empty
     */
    public E dequeue() throws EmptyQueueException;
    
    /**
     * Returns the first element in the queue without removing it.
     * 
     * Pre-condition: The queue must contain at least one element.
     * Post condition: No changes are made to the queue.
     * 
     * @return The first element in the queue
     * @throws EmptyQueueException if the queue is empty
     */
    public E peek() throws EmptyQueueException;
    
    
    /**
     * Determines if the queue is empty.
     * 
     * Pre-condition: None.
     * Post condition: No changes are made to the queue.
     * 
     * @return true if the queue is empty and false if it is not empty
     */
    public boolean isEmpty();
    
    /**
     * Determines the number of elements in the queue.
     * 
     * Pre-condition: None.
     * Post condition: No changes are made to the queue.
     * 
     * @return The number of elements in the queue
     */
    public int size();
    
    
    /**
     * Remove all elements from the queue.
     * 
     * Pre-condition: None.
     * Post condition: the queue is now empty.
     */
    public void clear();
    
}

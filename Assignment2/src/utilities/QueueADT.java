/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
     * This method Add the first element to the end of the queue
     * 
     * Pre-condition: the element must not be null
     * Post condition: The queue size will be increase by one and the element is added in the end of the queue
     * @param element Contain the generic item or element to add to the queue
     * @throws NullPointerException will be thrown if the parameter element is null
     */
    public void enqueue(E element) throws NullPointerException;
    
    
    /**
     * This method will remove the first element in the queue and return that element
     * 
     * Pre-condition: the queue must contains at least one element and not be empty
     * Post condition: the first element in the queue will be removed and the size
     * and the size of the queue will be decreased by one
     * @return the first previous item in the Queue
     * @throws EmptyQueueException if the queue is empty
     */
    public E dequeue() throws EmptyQueueException;
    
    
    /**
     * This method read and return the first element in the queue
     * 
     * Pre-condition: the queue must contains at least one element and not be empty
     * Post condition: returns the first element in the queue with no changes to the queue
     * @return the first element in the queue
     * @throws EmptyQueueException if the queue is empty
     */
    public E peek() throws EmptyQueueException;
    
    
    /**
     * This method check if the queue is empty or not. True if empty and false if not empty
     * 
     * Pre-condition: None.
     * Post condition: return true if empty and false if not empty, no changes are made to the queue
     * @return return true if empty and false if not empty
     */
    public boolean isEmpty();
    
    
    /**
     * This method return the size or length of the queue (numbers of elements in the queue)
     * 
     * Pre-condition: None
     * Post condition: returns the size of the queue
     * @return return the size or length of the queue (numbers of elements in the queue)
     */
    public int size();
    
    
    /**
     * This method clear all elements in the queue
     * 
     * Pre-condition: None
     * Post condition: the queue will be cleared and empty
     */
    public void clear();
    
}

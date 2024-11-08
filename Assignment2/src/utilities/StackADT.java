package utilities;

import ExceptionHandling.EmptyStackException;

/**
 * This ADT defines the definition of the Stack Data Structure
 * All the methods and functionalities in this interface must be implemented
 * when creating a Stack Data Structure
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 * @param <E> the generic type of elements
 */
public interface StackADT<E> {
    
    /**
    * Adds an element to the top of the stack.
    * 
    * Pre-condition: The element must not be null.
    * Post-condition: The element is added to the top of the stack, 
    *                 and the stack size increases by one.
    * 
    * @param element The element to add to the stack
    * @throws NullPointerException if the specified element is null
    */
    public void push(E element) throws NullPointerException;
    
    
    /**
     * Removes and returns the first element from the stack.
     * 
     * Pre-condition: The stack must contain at least one element.
     * Post condition: The top element is removed from the stack and
     *                 the stack size decreases by one.
     * 
     * @return The element that was removed from the stack
     * @throws EmptyStackException if the stack is empty
     */
    public E pop() throws EmptyStackException;
    
    
    /**
     * Returns the element at the top of the stack without removing it.
     * 
     * Pre-condition: The stack must contain at least one element.
     * Post condition: No changes are made to the stack.
     * 
     * @return The top element in the stack
     * @throws EmptyStackException if the stack is empty
     */
    public E top() throws EmptyStackException;
    
    
    /**
     * Determines if the stack is empty.
     * 
     * Pre-condition: None.
     * Post condition: No changes are made to the stack.
     * 
     * @return true if the stack is empty and false if it is not empty
     */
    public boolean isEmpty();
    
    /**
     * Determines the number of elements in the stack.
     * 
     * Pre-condition: None.
     * Post condition: No changes are made to the stack.
     * 
     * @return The number of elements in the stack
     */
    public int size();
    
    
    /**
     * Remove all elements from the stack.
     * 
     * Pre-condition: None.
     * Post condition: the stack is now empty.
     */
    public void clear();
    
    
}

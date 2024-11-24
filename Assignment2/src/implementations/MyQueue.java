
package implementations;

import com.sun.source.tree.BreakTree;
import exceptions.EmptyQueueException;
import utilities.Iterator;
import utilities.ListADT;
import utilities.QueueADT;

/**
 * represents a queue data structure implemented using a doubly linked list
 * @author Simon Luna Patiarroy, Tien Phap (Evan) Nguyen
 * @param <E> the type of elements store in this queue
 */
public class MyQueue<E> implements QueueADT<E> {
    
    /**
     * Constructs an empty queue with no capacity restrictions.
     */
    public MyDLL<E> dLinkedList = new MyDLL<>();

    /**
     *
     */
    public int capacity = 0;
    
    /**
     * Constructs an empty queue with no capacity restrictions.
     */
    public MyQueue() { }
    
    /**
     * Constructs an empty queue with a specified maximum capacity.
     * @param maxSize the maximum capacity of the double linked list
     */
    public MyQueue(int maxSize) {
        this.capacity = maxSize;
    }

    /**
     * Adds the specified element to the back of this queue.
     * @param toAdd the element to add
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public void enqueue(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException();
        }
        
        if (isFull()) {
            System.err.println("Queue at max capacity");
        }
        
        dLinkedList.add(toAdd);
    }

    /**
     * Removes and returns the element at the front of this queue.
     * @return the element at the front of this queue
     * @throws EmptyQueueException if this queue is empty
     */
    @Override
    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        
        return dLinkedList.remove(0);
        
    }

    /**
     * Retrieves, but does not remove, the element at the front of this queue.
     * @return the element at the front of this queue
     * @throws EmptyQueueException if this queue is empty
     */
    @Override
    public E peek() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return dLinkedList.get(0);
    }
    
    /**
     * Removes all of the elements from this queue.
     */
    @Override
    public void dequeueAll() {
        dLinkedList.clear();
    }

    /**
     * Checks if this queue is empty.
     * @return true if this queue contains no elements
     */
    @Override
    public boolean isEmpty() {
        return dLinkedList.isEmpty();
    }

    /**
     * Determines whether this queue contains the specified element.
     * @param toFind the element to be checked for presence in this queue
     * @return true if this queue contains the specified element
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException();
        }
        return dLinkedList.contains(toFind);
    }

    /**
     * Returns the 1-based position of the element if it exists within this queue, otherwise returns -1.
     * @param toFind the element to search for
     * @return the 1-based position of the element in this queue, or -1 if not found
     */
    @Override
    public int search(E toFind) {
        // Element not found
        if (!dLinkedList.contains(toFind)) {
            return -1;
        }
        
        Iterator<E> iterator = iterator();
        int distance = 0;
        
        // The first element in the queue is considered to be in position "1" 
        while(iterator.hasNext()) {
            E element = iterator.next();
            distance++;
            
            if (element == toFind) {
                break;
            }
            
        }
        // returns how far the element is from the first position
        return distance;
    }

    /**
     * Returns an iterator over the elements in this queue in proper sequence.
     * @return an iterator over the elements in this queue
     */
    @Override
    public Iterator<E> iterator() {
        return dLinkedList.iterator();
    }

    /**
     * Compares the specified queue with this queue for equality.
     * @param that the queue to be compared for equality with this queue
     * @return true if the specified queue is equal to this queue
     */
    @Override
    public boolean equals(QueueADT<E> that) {
        if (size() != that.size()) {
            return false;
        }
        
        Iterator<E> it1 = iterator();
        Iterator<E> it2 = that.iterator();
        
        while (it1.hasNext()) {
            if (!(it1.next().equals(it2.next()))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns an array containing all of the elements in this queue.
     * @return an array containing all of the elements in this queue
     */
    @Override
    public Object[] toArray() {
        return dLinkedList.toArray();
    }

    /**
     * Returns an array containing all of the elements in this queue.
     * @param holder the array into which the elements of the queue are to be stored, if it is big enough.
     * @return an array containing the elements of the queue
     * @throws NullPointerException if the specified array is null
     */
    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return dLinkedList.toArray(holder);
    }

    /**
     * Checks if this queue is full.
     * @return true if this queue is full, false otherwise
     */
    @Override
    public boolean isFull() {
        if (capacity == 0) {
            // capacity 0 will be the default, which means
            // there is no capacity limits
            return false;
        }
        return size() == capacity;
    }

    /**
     * Returns the number of elements in this queue.
     * @return the number of elements in this queue
     */
    @Override
    public int size() {
        return dLinkedList.size();
    }
    
}

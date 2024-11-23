
package implementations;

import com.sun.source.tree.BreakTree;
import exceptions.EmptyQueueException;
import utilities.Iterator;
import utilities.ListADT;
import utilities.QueueADT;

/**
 *
 * @author Simon Luna Patiarroy
 * @param <E>
 */
public class MyQueue<E> implements QueueADT<E> {
    
    private MyDLL<E> dLinkedList = new MyDLL<>();
    private int capacity = -1;
    
    public MyQueue() { }
    
    public MyQueue(int maxSize) {
        this.capacity = maxSize;
    }

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

    @Override
    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        
        return dLinkedList.remove(0);
        
    }

    @Override
    public E peek() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        return dLinkedList.get(0);
    }

    @Override
    public void dequeueAll() {
        dLinkedList.clear();
    }

    @Override
    public boolean isEmpty() {
        return dLinkedList.isEmpty();
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException();
        }
        return dLinkedList.contains(toFind);
    }

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

    @Override
    public Iterator<E> iterator() {
        return dLinkedList.iterator();
    }

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

    @Override
    public Object[] toArray() {
        return dLinkedList.toArray();
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return dLinkedList.toArray(holder);
    }

    @Override
    public boolean isFull() {
        if (capacity == -1) {
            // capacity 0 will be the default, which means
            // there is no capacity limits
            return false;
        }
        return size() == capacity;
    }

    @Override
    public int size() {
        return dLinkedList.size();
    }
    
}

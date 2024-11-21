package implementations;

import java.util.NoSuchElementException;
import utilities.Iterator;
import utilities.ListADT;

/**
 *
 * @author Simon Luna Patiarroy
 * @param <E> element
 * 
 */
public class MyDLL<E> implements ListADT<E>  {
    
    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;
    private int size;
    
    public MyDLL() {
        this.size = 0;
        this.head = null;
        this.tail = null;            
    }
    
    public MyDLLNode<E> getHead() {
        return head;
    }
    
    public MyDLLNode<E> getTail() {
        return tail;
    }

    @Override
    public int size() {
        return this.size;    
    }

    @Override
    public void clear() {
        this.size = 0;
        this.head = null;
        this.tail = null;   
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) {
            throw new NullPointerException();
        }
        
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        
        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);
        // 1 - The list is empty
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        // 2 - Adding to the end of the list
        } else if (size == index) {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        // 3 - adding to the beginning of the list when it is not empty    
        } else if (index == 0) {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        // 4 - Adding to the middle of the list
        } else if (index > 0) {
            MyDLLNode<E> before = head;
            // Find the node one index before the required position
            for (int i = 1; i < index; i++){
                before = before.getNext();
            }
            MyDLLNode<E> after = before.getNext();
            newNode.setNext(after);
            newNode.setPrev(before);
            before.setNext(newNode);
            after.setPrev(newNode);
        }
        size++;
        return true;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        // Always adds to the end of the list (tail)
        return add(size, toAdd);  
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }
        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > (size - 1)) {
            throw new IndexOutOfBoundsException();
        }
        
        if (isEmpty()) { 
            return null;
        }
        
        MyDLLNode<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        
        return temp.getElement();
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > (size - 1)) {
            throw new IndexOutOfBoundsException();
        }
        
        // 0 - The list is empty
        if (isEmpty()) { 
            return null;
        }
        
        MyDLLNode<E> temp = null;
        
        // 1 - Only one element in the list
        if (size == 1) {
            temp = head;
            head = null;
            tail = null;
        }
        // 2 - Remove from the tail
        if ((size - 1) == index && size > 1) {
            temp = tail;
            tail = tail.getPrev();
            tail.setNext(null);
        // 3 - Removing from the beginning    
        } else if (index == 0 && size > 1) {
            temp = head;
            head = head.getNext();
            head.setPrev(null);
        // 4 - Removing from the middle of the list
        } else if (index > 0) {
            MyDLLNode<E> before = head;
            // Find the node one index before the required position
            for (int i = 1; i < index; i++){
                before = before.getNext();
            }
            temp = before.getNext();
            MyDLLNode<E> after = temp.getNext();
            before.setNext(after);
            after.setPrev(before);
        }
        
        if (temp == null) return null;
        
        size--;
        return temp.getElement();
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null) {
            throw new NullPointerException();
        }
        
        if (isEmpty()) {
            return null;
        }
        
        Iterator<E> iterator = this.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            E element = iterator.next();
            
            if (element.equals(toRemove)) {
                break;
            }   
            index++;
        }
        
        // this is to comply with tests, not actually needed as it would 
        // throw a IndexOutOfBoundsException() when remove(index) is called
        if (index >= size) {
            return null;
        }
       
        return remove(index);
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null) {
            throw new NullPointerException();
        }
        
        if (index < 0 || index > (size - 1)) {
            throw new IndexOutOfBoundsException();
        }
        
        MyDLLNode<E> temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.getNext();
        }
        
        E previousElement = temp.getElement();
        temp.setElement(toChange);
               
        return previousElement;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;    
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException();
        }
        
        if (isEmpty()) {
            return false;
        }
        
        MyDLLNode<E> temp = head;
        for (int i = 0; i < size; i++){
            if (temp.getElement() == toFind){
                return true;
            }
            temp = temp.getNext();  
        }
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException();
        }
        
        E[] returnArray;
        
        if (toHold.length < this.size) {
            returnArray = (E[])(new Object[size]);
        } else {
            returnArray = toHold;
        }
        
        MyDLLNode<E> temp = head;
        for (int i = 0; i < size; i++) {
            returnArray[i] = temp.getElement();
            temp = temp.getNext(); 
        }
        
        return returnArray; 
    }

    @Override
    public Object[] toArray() {
        Object[] returnArray = new Object[this.size];
        
        MyDLLNode<E> temp = head;
        for (int i = 0; i < size; i++) {
            returnArray[i] = temp.getElement();
            temp = temp.getNext(); 
        }
        
        return returnArray;
    }

    @Override
    public Iterator<E> iterator() {
        return new DLLIterator(this.head);
    }
    
    public class DLLIterator implements Iterator<E> {
        
        private MyDLLNode<E> node;
        
        public DLLIterator(MyDLLNode<E> head) {
            this.node = head;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E element = this.node.getElement();
            node = node.getNext();
            return element;
        }
        
    }
    
    // Additional Testing Method
    public void printList() {
        MyDLLNode<E> temp = head;
        for (int i = 0; i < size; i++) {
            System.out.println(temp.getElement());
            temp = temp.getNext(); 
        }
    }
}

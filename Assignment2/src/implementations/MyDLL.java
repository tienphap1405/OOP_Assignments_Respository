/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;
import java.util.NoSuchElementException;
import utilities.Iterator;
import utilities.ListADT;
/**
 *
 *
 * The implementation of the Double linked list
 * @author Simon Luna Patiarroy, Tien Phap (Evan) Nguyen
 * @param <E> element type
 * 
>>>>>>> Stashed changes
 */
public class MyDLL<E> implements ListADT<E>{
    
    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;
    private int size;
    
    /**
     * Construct empty double linked list
     */
    public MyDLL() {
        this.size = 0;
        this.head = null;
        this.tail = null;            
    }
    
    /**
     * Return the head of the double linked list
     * @return the first node in the double linked list
     */
    public MyDLLNode<E> getHead() {
        return head;
    }
    
    /**
     * return the tail of the double linked list
     * @return the last node in the double linked list
     */
    public MyDLLNode<E> getTail() {
        return tail;
    }

    /**
     * return the size of the list
     * @return the number of elements in this double linked list
     */
    @Override
    public int size() {
        return this.size;    
    }

    /**
     * Remove every elements in the double linked list
     */
    @Override
    public void clear() {
        this.size = 0;
        this.head = null;
        this.tail = null;   
    }

    /**
     * Add an element on specific index in the double linked list
     * @param index index at which the input element is to be inserted
     * @param toAdd the element that need to be inserted
     * @return true if added successfully, false if not added successfully
     * @throws NullPointerException if the input element is null
     * @throws IndexOutOfBoundsException if the index of the specified element larger than the size or less than 0
     */
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

    /**
     * Add an element at the end of the double linked list
     * @param toAdd the element that need to be inserted
     * @return true if the element is added successfully, false if not successfully
     * @throws NullPointerException if the input element is null
     */
    @Override
    public boolean add(E toAdd) throws NullPointerException {
        // Always adds to the end of the list (tail)
        return add(size, toAdd);  
    }

    /**
     * Add all the elements of the specific collection to the end of this list
     * @param toAdd the collection containing elements to be added to this list
     * @return true if the list size increase and is added with new collection of elements at the end of the list
     * @throws NullPointerException if the input collection contain null values or null input
     */
    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
            size++;
        }
        
        return true;
    }

    /**
     * return the element of that specified index at a specific location in the double linked list
     * @param index the position of the element that need to retrieve
     * @return the element which index located in the double linked list
     * @throws IndexOutOfBoundsException if the index is larger than the size of the list or less than 0
     */
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

    /**
     * Remove the element at the specific index in the double linked list 
     * @param index the position of the element that need to be removed
     * @return the element that has been removed
     * @throws IndexOutOfBoundsException if the index is larger than the size of the list or less than 0
     */
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

    /**
     * Remove the element from the double linked list
     * @param toRemove the element that need to be removed
     * @return the element that has been removed
     * @throws NullPointerException if the input element is null
     */
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

    /**
     * Replace the element at the specific index with new element 
     * @param index the index of the current element that need to be change
     * @param toChange the new element that replace the current element
     * @return the element in the current list that need to be replaced
     * @throws NullPointerException if the input element is null
     * @throws IndexOutOfBoundsException if the index is larger than the size of the list or less than 0
     */
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

    /**
     * check if the linked list is empty of not
     * @return true if the double linked list is empty, false if the double linked list contains at least one element
     */
    @Override
    public boolean isEmpty() {
        return size == 0;    
    }

    /**
     * check if the double linked list contains a specified element
     * @param toFind the element that need to find in the double linked list
     * @return true if founded, false if not found
     * @throws NullPointerException if the input element is null
     */
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

    /**
     * convert the array list of the elements to the array
     * @param toHold the array that will be converted into
     * @return the new array that has been converted to
     * @throws NullPointerException if the input array is null
     */
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

    /**
     * Convert the current array list to the new array
     * @return the array that is converted to
     */
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

    /**
     * Iterate through every nodes in the double linked list from start to end 
     * @return the new iterator of the size of the double linked list
     */
    @Override
    public Iterator<E> iterator() {
        return new DLLIterator(this.head);
    }
    
    /**
     * Implementation of the double linked list iterator
     */
    public class DLLIterator implements Iterator<E> {
        
        private MyDLLNode<E> node;
        
        /**
         * constructor to create the iterator
         * @param head
         */
        public DLLIterator(MyDLLNode<E> head) {
            this.node = head;
        }

        /**
         * check if the double linked list has next values
         * @return true if the list has next value, false if the list contains no more value to be iterated
         */
        @Override
        public boolean hasNext() {
            return node != null;
        }

        /**
         * the element that has been iterate through
         * @return the nodes that has been iterate through in the double linked list 
         * @throws NoSuchElementException if there is no nodes left
         */
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

    /**
     * Displays the contents of the linked list
     */
    public void printList() {
        MyDLLNode<E> temp = head;
        for (int i = 0; i < size; i++) {
            System.out.println(temp.getElement());
            temp = temp.getNext(); 
        }
    }
}

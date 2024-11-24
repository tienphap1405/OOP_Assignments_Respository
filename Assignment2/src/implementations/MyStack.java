/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import utilities.Iterator;
import utilities.StackADT;

/**
 * represents a Stack data structure implemented using a array list
 * @author Simon Luna Patiarroy, Tien Phap (Evan) Nguyen
 * @param <E> the type of elements store in this stack
 */
public class MyStack<E> implements StackADT<E>{
    private MyArrayList<E> arrayData;
    private int size;

    /**
     * Construct an empty stack.
     */
    public MyStack() {
        arrayData = new MyArrayList<>();
        this.size = 0;
    }
    
    /**
     * Adds an element to the top of the stack which is the end of the array list.
     * @param toAdd the element to be added to the stack
     * @throws NullPointerException if the element to add is null
     */
    @Override
    public void push(E toAdd) throws NullPointerException {
        if(toAdd == null){
            throw new NullPointerException();
        }
        arrayData.add(toAdd);
        size++;
    }

    /**
     * Removes and returns the top element of the stack.
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public E pop() throws EmptyStackException {
        
        if(size == 0){
            throw new EmptyStackException();
        }
        E currentElement = arrayData.get(size-1);
        arrayData.remove(size - 1);
        size--;
        return currentElement;
    }

    /**
     * Retrieves, but does not remove, the top element of the stack.
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public E peek() throws EmptyStackException {
        if(size == 0){
            throw new EmptyStackException();
        }
        return arrayData.get(size - 1);
    }

    /**
     * Removes all elements from the stack.
     */
    @Override
    public void clear() {
        arrayData.clear();
    }

    /**
     * Returns true if the stack contains no elements.
     * @return true if the stack is empty, otherwise false
     */
    @Override
    public boolean isEmpty() {
        return arrayData.isEmpty();
    }

    /**
     * Returns an array containing all of the elements in this stack in proper sequence (from top to bottom element).
     * @return an array containing all of the elements in this stack
     */
    @Override
    public Object[] toArray() {
        Object[] newArrayObjects = new Object[size];
        for (int i = 0; i < size; i++) {
            newArrayObjects[i] = arrayData.get(size - 1 - i); 
        }
        return newArrayObjects;
    }

    /**
     * Returns an array containing all of the elements in this stack in proper sequence (from top to bottom element)
     * @param holder the array into which the elements of the stack are to be stored, if it is big enough.
     * @return an array containing all of the elements in this stack
     * @throws NullPointerException if the specified array is null
     */
    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        if(holder == null){
            throw new NullPointerException();
        }
        
        if(holder.length < size){
            holder = (E[]) new Object[size];
        }
        for(int i = 0; i < size; i++){
            holder[i] = arrayData.get( size - 1 -i);
        }
        
        return holder;
    }

    /**
     * Determines if this stack contains the specified element.
     * @param toFind the element to search for
     * @return true if this stack contains the specified element
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException();
        }
        
        return arrayData.contains(toFind);
    }

    /**
     * Searches for the element in the stack and returns the 1-based position from the top of the stack.
     * @param toFind the element to search for
     * @return the 1-based position from the top of the stack, or -1 if the element is not in the stack
     */
    @Override
    public int search(E toFind) {
        for(int i = size -1; i >= 0; i--){
            if (arrayData.get(i).equals(toFind)) {
                return size - i;
            }
        }
        return -1;
    }

    /**
     * Returns an iterator over the elements in this stack in proper sequence.
     * @return an iterator over the elements in this stack
     */
    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    /**
     * Compares this stack with another stack to determine if they contain the same elements in the same order.
     * @param that the other stack to be compared with this stack
     * @return true if this stack is equal to the argument stack
     */
    @Override
    public boolean equals(StackADT<E> that) {
        if(this.size() != that.size()){
            return false;
        }
        Iterator<E> thisIterator = this.iterator();
        Iterator<E> thatIterator = that.iterator();
        
        while(thisIterator.hasNext() && thatIterator.hasNext()){
            if(!thisIterator.next().equals(thatIterator.next())){
                return false;
            }
            
        }
        return true;
    }

    /**
     * Returns the number of elements in this stack.
     * @return the number of elements in this stack
     */
    @Override
    public int size() {
        return arrayData.size();
    }

    /**
     * Returns whether this stack has reached its maximum capacity.
     * @return true if the stack is full, otherwise false
     */
    @Override
    public boolean stackOverflow() {
        int maxCapacity = 10;
        return arrayData.size() == maxCapacity;
    }
    
    /**
     * Iterator implementation for the stack
     */
    public class StackIterator implements Iterator<E> {
        private int Index = size - 1;
        
        /**
         * Constructor for an Stack iterator
         */
        public StackIterator() {

        }
        
        /**
         * Checks if the stack has more elements.
         * @return true if there are more elements to iterate over
         */
        @Override
        public boolean hasNext() {
            return Index >= 0;
        }

        /**
         * Returns the next element in the stack.
         * @return the next element in the stack
         * @throws NoSuchElementException if there are no elements left to return
         */
        @Override
        public E next() throws NoSuchElementException {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return arrayData.get(Index--);
        }
        
        
        
        
}
    
}

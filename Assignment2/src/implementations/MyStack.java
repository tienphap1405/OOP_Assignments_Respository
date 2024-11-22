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
 *
 * @author tienp
 */
public class MyStack<E> implements StackADT<E>{
    private MyArrayList<E> arrayData;
    private int size;

    
    public MyStack() {
        arrayData = new MyArrayList<>();
        this.size = 0;
    }
    
    @Override
    public void push(E toAdd) throws NullPointerException {
        if(toAdd == null){
            throw new NullPointerException();
        }
        arrayData.add(toAdd);
        size++;
    }

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

    @Override
    public E peek() throws EmptyStackException {
        if(size == 0){
            throw new EmptyStackException();
        }
        return arrayData.get(size - 1);
    }

    @Override
    public void clear() {
        arrayData.clear();
    }

    @Override
    public boolean isEmpty() {
        return arrayData.isEmpty();
    }

    @Override
    public Object[] toArray() {
        Object[] newArrayObjects = new Object[size];
        for (int i = 0; i < size; i++) {
            newArrayObjects[i] = arrayData.get(size - 1 - i); 
        }
        return newArrayObjects;
    }

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

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException();
        }
        
        return arrayData.contains(toFind);
    }

    @Override
    public int search(E toFind) {
        for(int i = size -1; i >= 0; i--){
            if (arrayData.get(i).equals(toFind)) {
                return size - i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

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

    @Override
    public int size() {
        return arrayData.size();
    }

    @Override
    public boolean stackOverflow() {
        int maxCapacity = 10;
        return arrayData.size() == maxCapacity;
    }
    
    

    public class StackIterator implements Iterator<E> {
        private int Index = size - 1;
        
        public StackIterator() {

        }
        
        
        @Override
        public boolean hasNext() {
            return Index >= 0;
        }

        @Override
        public E next() throws NoSuchElementException {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return arrayData.get(Index--);
        }
        
        
        
        
}
    
}

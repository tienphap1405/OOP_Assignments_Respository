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
 * @author tienp
 */
public class MyArrayList<E> implements ListADT<E> {
    private E[] arrayData;
    private int size;

    public MyArrayList() {
        this.size = 0;
        arrayData = (E[]) new Object[10];
    }
    
    
    public void resize(){
        E[] resizeArray = (E[]) new Object[arrayData.length + 10];
        for (int i = 0; i < size; i++){
            resizeArray[i] = arrayData[i];
        }
        arrayData = resizeArray;
    }
    
    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        
        for (int i = 0; i < size; i++){
            arrayData[i] = null;
        }
        size = 0;
    }
    

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if(toAdd == null){
            throw new NullPointerException();
        }
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(size == arrayData.length){
            resize();
        }
       for(int i = size; i > index; i--){
           arrayData[i] = arrayData[i - 1];
       }
              
       arrayData[index] = toAdd;
       size++;
       return true;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if(toAdd == null){
            throw new NullPointerException();
        }
        if(size == arrayData.length){
            resize();
        }
        arrayData[size] = toAdd;
        size++;
        return true;
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if(toAdd == null){
            throw new NullPointerException();
        }
        Iterator<? extends E> iter = toAdd.iterator();
        
        if(toAdd.size() + size > arrayData.length){
            resize();
        }
        while(iter.hasNext()){
            arrayData[size++] = iter.next();
            
        }
        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        } 
        return arrayData[index];
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        E currentElement = arrayData[index];
        for (int i = index; i < size - 1; i++){
           arrayData[i] = arrayData[i+1];
        }
        arrayData[size - 1] = null;
        size--;
        return currentElement;
        
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        if(toRemove == null){
            throw new NullPointerException();
        }
        for(int i = 0; i < size; i++){
            if(arrayData[i].equals(toRemove)){
                E currentElement = arrayData[i];
                for(int j = i; j < size - 1; j++){
                    arrayData[j] = arrayData[j + 1];
                }
                arrayData[size - 1] = null;
                size--;
                return currentElement;
            }
        }
        return null;
        
        
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if(toChange == null){
            throw new NullPointerException();
        }
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        E currentElement = arrayData[index];
        arrayData[index] = toChange;
        return currentElement;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if(toFind == null){
            throw new NullPointerException();
        }
        for(int i = 0; i < size; i++){
            if (arrayData[i].equals(toFind)){
                return true;
            }
        }
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if(toHold == null){
            throw new NullPointerException();
        }
        
        E[] returnArray;
        if(toHold.length < size){
            returnArray = (E[]) new Object[size]; 
        }
        else{
            returnArray = toHold;
        }
        
        for(int i = 0; i < size; i++){
            toHold[i] = arrayData[i];
        }
        
        return toHold;
        
    }

    @Override
    public Object[] toArray() {
        Object[] arrayObjects = new Object[size];
        for(int i = 0; i < size; i++){
            arrayObjects[i] = arrayData[i];
        }
        return arrayObjects;
    }

    @Override
    public Iterator<E> iterator() {
       return new ArrayListIterator(this, size);
    }
    
    public class ArrayListIterator implements Iterator<E> {
        private MyArrayList<E> data;
        private int size;
        private int index;

        public ArrayListIterator(MyArrayList<E> data, int size) {
            this.data = data;
            this.size = size;
            this.index = -1;
        }
        
        
        @Override
        public boolean hasNext() {
            return index < size - 1;
        }

        @Override
        public E next() throws NoSuchElementException {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return data.get(++index);
        }
        
        
        
        
}
}

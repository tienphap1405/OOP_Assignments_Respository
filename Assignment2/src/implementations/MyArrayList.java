
package implementations;

import java.util.NoSuchElementException;
import utilities.Iterator;
import utilities.ListADT;

/**
 * ArrayList implementation using array as underlying data structure
 * @author Simon Luna Patiarroy, Tien Phap (Evan) Nguyen
 * @param <E>
 */
public class MyArrayList<E> implements ListADT<E> {
    private E[] arrayData;
    private int size;

    /**
     * Constructor for ArrayList
     * Create new array with maximum capacity of 10
     */
    public MyArrayList() {
        this.size = 0;
        arrayData = (E[]) new Object[10];
    }
    
    /**
     * Scale up an array by 10
     */
    public void resize(){
        E[] resizeArray = (E[]) new Object[arrayData.length + 10];
        for (int i = 0; i < size; i++){
            resizeArray[i] = arrayData[i];
        }
        arrayData = resizeArray;
    }
    
    /**
     * Return number of elements of the list
     * @return number of elements in the array list 
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Clear the entire list
     */
    @Override
    public void clear() {
        
        for (int i = 0; i < size; i++){
            arrayData[i] = null;
        }
        size = 0;
    }
    
    /**
     * Add an element on specific index in the array list
     * @param index index of the element that want to add
     * @param toAdd value of the element 
     * @return true if added successfully, false if not successfully
     * @throws NullPointerException if the input element is false
     * @throws IndexOutOfBoundsException if the index less than 0 or larger than the size of the array list
     */
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

    /**
     * add an element to the end of the array list
     * @param toAdd value of the element to add
     * @return true if added successfully, false if not successfully
     * @throws NullPointerException if the element is null
     */
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

    /**
     * Add every elements in the input array list to the end of the current array list
     * @param toAdd contains the array list of elements that need to be added to the current array list
     * @return true if all elements are added successfully, false if not successfully
     * @throws NullPointerException if the input array list is null
     */
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

    /**
     * Get the value of the element in the array list based on the index
     * @param index index of the value that need to get
     * @return value of the element of that index
     * @throws IndexOutOfBoundsException if the index less than 0 or larger than the size of the array list
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        } 
        return arrayData[index];
    }

    /**
     * Remove the element at the specific index position in the array list
     * @param index the index of the element that has been removed 
     * @return the element that has been removed
     * @throws IndexOutOfBoundsException if the index less than 0 or larger than the size of the array list
     */
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

    /**
     * Remove the element at the end of the array list
     * @param toRemove the element that need to be removed
     * @return the element that has been removed
     * @throws NullPointerException if the input element is null
     */
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

    /**
     * Replace the element at the specific index with new element
     * @param index the index of the current element that need to be changed
     * @param toChange the new element that replace the current element 
     * @return the element of the current list that need to be replaced
     * @throws NullPointerException if the input element is null
     * @throws IndexOutOfBoundsException if the index less than 0 or larger than the size of the array list
     */
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

    /**
     * check if the array list is empty or not
     * @return true if the array list is empty, else return false if the list is not empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * check if the array list contain the element or not
     * @param toFind the element that need to find in the array list
     * @return true if the element exist, if not return false if the element not exist
     * @throws NullPointerException if the input element is null
     */
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

    /**
     * convert the array list of the elements to the array
     * @param toHold the array that will be converted into
     * @return the new array that has been converted to
     * @throws NullPointerException if the input array is null
     */
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

    /**
     * Convert the current array list to the new array
     * @return the array that is converted to
     */
    @Override
    public Object[] toArray() {
        Object[] arrayObjects = new Object[size];
        for(int i = 0; i < size; i++){
            arrayObjects[i] = arrayData[i];
        }
        return arrayObjects;
    }

    /**
     * Iterate through every elements in the array list from start to end 
     * @return the new iterator of the size of the array list
     */
    @Override
    public Iterator<E> iterator() {
       return new ArrayListIterator(this, size);
    }

    public void printList() {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        } 
    } 
    
    /**
     * Implementation of the array list iterator
     */
    public class ArrayListIterator implements Iterator<E> {
        private MyArrayList<E> data;
        private int size;
        private int index;

        /**
         * Constructor of the array list iterator
         * @param data the array list
         * @param size size of the list
         */
        public ArrayListIterator(MyArrayList<E> data, int size) {
            this.data = data;
            this.size = size;
            this.index = -1;
        }
        
        /**
         * check if the array list has next values
         * @return true if the list has next value, false if the list contains no more value to be iterated
         */
        @Override
        public boolean hasNext() {
            return index < size - 1;
        }

        /**
         * the element that has been iterate through
         * @return the element that has been iterate through in the array list 
         * @throws NoSuchElementException if there is no element left
         */
        @Override
        public E next() throws NoSuchElementException {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return data.get(++index);
        }
        
        

        
}
}

package utilities;

import shapes.Shape;
import java.util.Comparator;
import shapes.AreaComparator;
import shapes.VolumeComparator;

/**
 *
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 */
public class Sorting {
    
    /**
     *
     * @param s1
     * @param s2
     * @param comparator
     * @return
     */
    public static int compare(Shape s1, Shape s2, Comparator<Shape> comparator){
        if(comparator != null){
            return comparator.compare(s1, s2);
        }
        else{
            return ((Comparable<Shape>) s1).compareTo(s2);
        }
    }
    
    /**
     *
     * @param arrayComparables
     * @param i
     * @param j
     */
    public static void swap(Shape[] arrayComparables, int i, int j){
        Shape temp = arrayComparables[i];
        arrayComparables[i] = arrayComparables[j];
        arrayComparables[j] = temp;

    }
    
    // Example array [10 4 5 9 8 6 1 2 7 3 77] --> l = 0; m = 6; r = 10
    // after divided: leftarray = [10 4 5 9 8 6 1]  |  rightarray = [2 7 3 77] 

    /**
     *
     * @param totalComparables
     * @param l
     * @param m
     * @param r
     * @param comparator
     */
    
    public static void merging (Shape[] totalComparables, int l, int m, int r, Comparator<Shape> comparator){
        // Find the size of the 2 arrays that need to be merged
        int leftSize = m - l + 1; //(size = 7)
        int rightSize = r - m; //(size = 4)
        
        // Create temporary array
        Shape[] array1 = new Shape[leftSize];
        Shape[] array2 = new Shape[rightSize];
        
        //Append the value of the array to 2 sub arrays based on the size
        for(int i = 0; i < leftSize; i++){
            array1[i] = totalComparables[l + i];
        }
        for (int j = 0; j < rightSize; j++){
            array2[j] = totalComparables[m + 1 + j];
        }
        
        int i = 0;
        int j = 0;
        int k = l;
        
        while(i < leftSize && j < rightSize){
            if(compare(array1[i], array2[j], comparator) <= 0){
                totalComparables[k] = array1[i];
                i++;
            }
            else {
                totalComparables[k] = array2[j];
                j++;
            }
            k++;
        }
        
        //Append the remaining values into the array
        while(i < leftSize){
            totalComparables[k] = array1[i];
            i++;
            k++;
        }
        while(j < rightSize){
            totalComparables[k] = array2[j];
            j++;
            k++;
        }
        
    }
    
    /**
     *
     * @param arrayComparables
     * @param comparator
     */
    public static void selectionSort(Shape[] arrayComparables, Comparator<Shape> comparator){
        int size = arrayComparables.length; 
        for (int i = 0; i < size; i++){
            Shape minValue = arrayComparables[i];
            int minIndex = i;
            for (int j = i + 1; j < size; j++){
                int compareReturn = compare(arrayComparables[j], minValue, comparator);
                if (compareReturn < 0) {
                    minValue = arrayComparables[j];
                    minIndex = j;
                }
            }
            swap(arrayComparables, minIndex, i);
        }
        
    }

    
    // Recursion to divide the array to one sorted value array then merging (Dividing and Conquering method)

    /**
     *
     * @param arrayComparables
     * @param l
     * @param r
     * @param comparator
     */
    public static void mergeSort(Shape[] arrayComparables, int l, int r, Comparator<Shape> comparator){
        if(l < r){
            int m = l + (r - l) / 2;
            mergeSort(arrayComparables, l, m, comparator);
            mergeSort(arrayComparables, m + 1, r, comparator);
            
            merging(arrayComparables, l, m, r, comparator);
        }
        
        
    }
    
    // Choose the pivot as the final value in an array
    // The pivot will be compared to append all the values that less than the pivot to the left
    // And larger value to the right
    // The left pointer will move to the right and stop when a value is larger than the pivot
    // as the right pointer move to the left and stop when the value is smaller than the pivot
    // When both pointer stop, the swap method will swap the 2 pointer value
    // When the pointers meet, swap the pivot to the leftpointer position.

    /**
     *
     * @param arrayComparables
     * @param lowIndex
     * @param highIndex
     * @param comparator
     */
    public static void quickSort(Shape[] arrayComparables, int lowIndex, int highIndex, Comparator<Shape> comparator){
        if(lowIndex >= highIndex) {
            return;
        }
        Shape pivot = arrayComparables[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
       
        while(leftPointer < rightPointer){
            while(compare(arrayComparables[leftPointer], pivot, comparator)<= 0 && leftPointer < rightPointer){
                leftPointer++;
            }
            while (compare(arrayComparables[rightPointer], pivot, comparator) >= 0 && leftPointer < rightPointer){
                rightPointer--;
            }
            swap(arrayComparables, leftPointer, rightPointer);
        }
        swap(arrayComparables, leftPointer, highIndex);
        quickSort(arrayComparables, lowIndex, leftPointer - 1, comparator);
        quickSort(arrayComparables, leftPointer + 1, highIndex, comparator);
    }

    /**
     *
     * @param arrayComparables
     * @param comparator
     */
    public static void bubbleSort(Shape[] arrayComparables, Comparator<Shape> comparator){
        int size = arrayComparables.length; 
        for (int i=0; i<size-1; i++) {
            for (int j=1; j<size-i; j++){
                if (compare(arrayComparables[j-1], arrayComparables[j], comparator) >= 0) {
                    swap(arrayComparables, j-1, j);
                }         
           }
        }
        
    } 
    
    /**
     *
     * @param arraytComparables
     * @param comparator
     */
    public static void insertionSort(Shape[] arraytComparables, Comparator<Shape> comparator){
        for (int i = 1; i < arraytComparables.length; i++){
            int index = i;
            for (int j = i - 1; j>=0; j--){
                if(compare(arraytComparables[index], arraytComparables[j], comparator) <= 0){
                    swap(arraytComparables, index, j);
                    index = j;
                }
                else{
                    break;
                }
            }
        }
    }
    
    /**
     *
     * @param arraytComparables
     * @param comparator
     */
    public static void cycleSort(Shape[] arraytComparables, Comparator<Shape> comparator){
        
        int size = arraytComparables.length;

        // Go through the array and place each shape in their correct position
        for (int cycleStart = 0; cycleStart < size - 1; cycleStart++) {
            
            Shape shape = arraytComparables[cycleStart];

            // Find the position where we place the shape
            int currentPosition = cycleStart;
            for (int i = cycleStart + 1; i < size; i++) {
                if (compare(arraytComparables[i], shape, comparator) < 0) {
                    currentPosition++;
                }
            }

            // If the shape is already in the correct position,
            // continue to the next iteration
            if (currentPosition == cycleStart) {
                continue;
            }

            // Skip duplicate values by placing the shape one position further
            while (shape.equals(arraytComparables[currentPosition])) {
                currentPosition++;
            }

            // Put the shape in its right position, store the replaced shape
            // Specialized swap that doesnt swap the positions of 2 objects in an
            // array, it only replaces one and stores the other.
            Shape temp = arraytComparables[currentPosition];
            arraytComparables[currentPosition] = shape;
            shape = temp;

            // Rotate the rest of the cycle
            while (currentPosition != cycleStart) {
                
                // Same as before
                currentPosition = cycleStart;

                // Find the position to put the shape
                for (int i = cycleStart + 1; i < size; i++) {
                    if (compare(arraytComparables[i], shape, comparator) < 0) {
                        currentPosition++;
                    }
                }

                // Skip duplicates shapes
                while (shape.equals(arraytComparables[currentPosition])) {
                    currentPosition++;
                }

                // Swap the item with the one at its correct position
                temp = arraytComparables[currentPosition];
                arraytComparables[currentPosition] = shape;
                shape = temp;
            }
        }
            
    }
}

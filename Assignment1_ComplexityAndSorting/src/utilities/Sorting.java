package utilities;


public class Sorting {
    
    
    public static void Swap(Comparable[] arrayComparables, int i, int j){
        Comparable temp = arrayComparables[i];
        arrayComparables[i] = arrayComparables[j];
        arrayComparables[j] = temp;

    }
    
    // Example array [10 4 5 9 8 6 1 2 7 3 77] --> l = 0; m = 6; r = 10
    // after divided: leftarray = [10 4 5 9 8 6 1]  |  rightarray = [2 7 3 77] 
    
    public static void Merging (Comparable[] totalComparables, int l, int m, int r ){
        // Find the size of the 2 arrays that need to be merged
        int leftSize = m - l + 1; //(size = 7)
        int rightSize = r - m; //(size = 4)
        
        // Create temporary array
        Comparable[] array1 = new Comparable[leftSize];
        Comparable[] array2 = new Comparable[rightSize];
        
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
            if(array1[i].compareTo(array2[j]) <= 0){
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
    
    
    //
    
    public static void SelectionSort(Comparable[] arrayComparables){
        int size = arrayComparables.length; 
        for (int i = 0; i < size; i++){
            Comparable minValue = arrayComparables[i];
            int minIndex = i;
            for (int j = i + 1; j < size; j++){

                if (arrayComparables[j].compareTo(minValue) < 0) {
                    minValue = arrayComparables[j];
                    minIndex = j;
                }
            }
            Swap(arrayComparables, minIndex, i);
        }
        
    }

    
    
    // Recursion to divide the array to one sorted value array then merging (Dividing and Conquering method)
    public static void MergeSort(Comparable[] arrayComparables, int l, int r){
        if(l < r){
            int m = l + (r - l) / 2;
            MergeSort(arrayComparables, l, m);
            MergeSort(arrayComparables, m + 1, r);
            
            Merging(arrayComparables, l, m, r);
        }
        
        
    }
    
    // Choose the pivot as the final value in an array
    // The pivot will be compared to append all the values that less than the pivot to the left
    // And larger value to the right
    // The left pointer will move to the right and stop when a value is larger than the pivot
    // as the right pointer move to the left and stop when the value is smaller than the pivot
    // When both pointer stop, the swap method will swap the 2 pointer value
    // When the pointers meet, Swap the pivot to the leftpointer position.
    public static void QuickSort(Comparable[] arrayComparables, int lowIndex, int highIndex){
        if(lowIndex >= highIndex) {
            return;
        }
        Comparable pivot = arrayComparables[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
       
        while(leftPointer < rightPointer){
            while(arrayComparables[leftPointer].compareTo(pivot) <= 0 && leftPointer < rightPointer){
                leftPointer++;
            }
            while (arrayComparables[rightPointer].compareTo(pivot) >= 0 && leftPointer < rightPointer){
                rightPointer--;
            }
            Swap(arrayComparables, leftPointer, rightPointer);
        }
        Swap(arrayComparables, leftPointer, highIndex);
        QuickSort(arrayComparables, lowIndex, leftPointer - 1);
        QuickSort(arrayComparables, leftPointer + 1, highIndex);
    }

    
    public static void BubbleSort(Comparable[] arrayComparables){

    } 
    public static void InsertionSort(Comparable[] arraytComparables){

    }
}

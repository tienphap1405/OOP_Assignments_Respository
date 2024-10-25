package utilities;


public class Sorting {

    public static void Swap(Comparable[] arrayComparables, int i, int j){
        Comparable temp = arrayComparables[i];
        arrayComparables[i] = arrayComparables[j];
        arrayComparables[j] = temp;

    }
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

    public static void MergeSort(Comparable[] arrayComparables){
        
    }
    public static void QuickSort(Comparable[] arrayComparables){

    }

    
    public static void BubbleSort(Comparable[] arrayComparables){

    } 
    public static void InsertionSort(Comparable[] arraytComparables){

    }
}

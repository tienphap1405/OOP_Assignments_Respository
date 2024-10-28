package appDomain;
import utilities.ReadFile;
import java.io.FileNotFoundException;
import java.util.Comparator;
import shapes.AreaComparator;
import shapes.Cylinder;
import shapes.Shape;
import shapes.VolumeComparator;
import utilities.Sorting;



public class AppDriver
{
	public static void main( String[] args )
	{
            
            // Testing string args
            String[] testing = new String[3];
            
            // -f(filepath)
            testing[0] = "-Fshapes1.txt";
            // -t(Comparitve Property)
            testing[1] = "-Tv";

            // -s(Sorting Method)
            testing[2] = "-Sz";

            
            if (testing.length != 3) {
                System.err.println("Invalid Input - requires 3 arguments");
                return;
            }
            
            
            String filePath = "";
            String comparisonType = "";
            String sortingMethod = "";
            
            for (String testing1 : testing) {
                String category = testing1.substring(0, 2);
                String input = testing1.substring(2);
                // System.err.println(category == "-f");
                
                switch (category.toLowerCase()) {
                    case "-f" -> filePath = input;
                    case "-t" -> comparisonType = input.toLowerCase();
                    case "-s" -> sortingMethod = input.toLowerCase();
                    default -> {
                        System.err.println("Invalid Input: " + category);
                        System.err.println("Enter -f(filepath) -t(comparison property) -s(sorting method)");
                        return;
                    }
                }    
            }
            
            Comparator<Shape> comparator;
            
            switch (comparisonType) {
                case "h" -> comparator = null;
                case "a" -> comparator = new AreaComparator();
                case "v" -> comparator = new VolumeComparator();
                default -> {
                    System.err.println("Invalid comparison property, enter h, a, or v");
                    return;
                }
            }
            
            Shape[] shapesArray;
                   
            try {
                shapesArray = ReadFile.loadShapes(filePath);
                System.out.println("File Found\n");
            }
            catch (FileNotFoundException ex) {
                System.err.println("File Not Found!!");
                return;
            }
            

            // Creating a copy of the array before sorting
            System.out.println("Pre-Sorting");
            printArray(shapesArray, comparisonType);
            
            // Determine comparison property
            long start = System.currentTimeMillis();
            
            switch (sortingMethod) {
                case "i" -> Sorting.insertionSort(shapesArray, comparator);
                case "s" -> Sorting.selectionSort(shapesArray, comparator);
                case "b" -> Sorting.bubbleSort(shapesArray, comparator);
                case "q" -> Sorting.quickSort(shapesArray, 0, shapesArray.length - 1, comparator);
                case "m" -> Sorting.mergeSort(shapesArray, 0, shapesArray.length - 1, comparator);
                case "z" -> Sorting.cycleSort(shapesArray, comparator);
                default -> {
                    System.err.println("Invalid sorting method, enter: i, s, b, q, m or z");
                    return;
                }
            }
            
            // Testing 
            System.out.println("\n\n\nPost-Sorting");
            printArray(shapesArray, comparisonType);
            
            long stop = System.currentTimeMillis();
            System.out.println("Time: " + (stop - start) + " Milliseconds");
            
            
            
	}
        
        private static void printArray(Shape[] array, String property) {
            switch (property) {
                case "h" -> {
                    for (Shape shape: array) {
                        System.out.println(shape.getHeight());
                    }
                }
                case "a" -> {
                    for (Shape shape: array) {
                        System.out.println(shape.calcBaseArea());
                    }
                }
                case "v" -> {
                    for (Shape shape: array) {
                        System.out.println(shape.calcVolume());
                    }
                }
                default -> {
                    System.out.println("Unable to display");
                    return;
                }
            }
        }

}

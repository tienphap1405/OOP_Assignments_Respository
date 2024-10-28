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
            
            testing[0] = "-Fshapes1.txt";
            testing[1] = "-Th";
            testing[2] = "-Sm";
            
            if (testing.length != 3) {
                System.err.println("Invalid Input - requires 3 arguments");
                return;
            }
            
            
            String filePath = "";
            String comparisonProperty = "";
            String sortingMethod = "";
            
            for (String testing1 : testing) {
                String category = testing1.substring(0, 2);
                String input = testing1.substring(2);
                // System.err.println(category == "-f");
                
                switch (category.toLowerCase()) {
                    case "-f" -> filePath = input;
                    case "-t" -> comparisonProperty = input.toLowerCase();
                    case "-s" -> sortingMethod = input.toLowerCase();
                    default -> {
                        System.err.println("Invalid Input: " + category);
                        System.err.println("Enter -f(filepath) -t(comparison property) -s(sorting method)");
                        return;
                    }
                }    
            }
            
            if (!(comparisonProperty.equals("v") || 
                    comparisonProperty.equals("h") || 
                    comparisonProperty.equals("a"))) {
                System.err.println("Invalid comparison property, enter h, a, or v");
                return;
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
            
            // Testing 
            System.out.println("Pre-Sorting");
            printArray(shapesArray, comparisonProperty);

            // Determine comparison property

            switch (sortingMethod) {
                case "i" -> Sorting.InsertionSort(shapesArray);
                case "s" -> Sorting.SelectionSort(shapesArray);
                case "b" -> Sorting.BubbleSort(shapesArray);
                case "q" -> Sorting.QuickSort(shapesArray, 0, shapesArray.length - 1);
                case "m" -> Sorting.MergeSort(shapesArray, 0, shapesArray.length - 1);
                case "z" -> System.out.println("Missing sorting method");
                default -> {
                    System.err.println("Invalid sorting method, enter: i, s, b, q, m or z");

                    return;
                }
            }             
            
            // Testing 
            System.out.println("\n\n\nPost-Sorting");

            printArray(shapesArray, comparisonProperty);
           

            // refer to demo01 Test.java for an example on how to parse command
            // line arguments and benchmarking tests


            // refer to demo02 KittySort.java on how to use a custom sorting
            // algorithm on a list of comparables to sort using either the
            // natural order (comparable) or other orders (comparators)

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

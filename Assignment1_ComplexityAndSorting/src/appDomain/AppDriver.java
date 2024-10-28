package appDomain;
import utilities.ReadFile;
import java.io.FileNotFoundException;
import shapes.Shape;
import utilities.Sorting;


public class AppDriver
{
	public static void main( String[] args )
	{
            
            // Testing string args
            String[] testing = new String[3];
            
            testing[0] = "-Fshapes1.txt";
            testing[1] = "-Tv";
            testing[2] = "-Sm";
            
            if (testing.length != 3) {
                System.err.println("Invalid Input - requires 3 arguments");
                return;
            }
            
            
            String filePath = null;
            String comparisonProperty = null;
            String sortingMethod = null;
            
            for (int i=0; i < testing.length; i++) {
                
                String category = testing[i].substring(0, 2);
                
                String input = testing[i].substring(2);
                
                switch (category.toLowerCase()) {
                    case "-f":
                        // Determine the file path
                        filePath = input;
                        break;
                    case "-t":
                        // Determine the compared property
                        comparisonProperty = input.toLowerCase();
                        break;
                    case "-s":
                        sortingMethod = input.toLowerCase();
                        break;
                    default:
                        System.err.println("Invalid Input: " + category);
                        System.err.println("Enter -f(filepath) -t(compared property) -s(sorting method)");
                        return;
                }    
            }
            
            
            Shape[] shapesArray;
                   
            try {
                shapesArray = ReadFile.loadShapes(filePath);
                System.out.println("File Found");
            }
            catch (FileNotFoundException ex) {
                System.err.println("File Not Found!!");
                return;
            }
            
            // Testing 
            System.out.println("Pre-Sorting");
            for (Shape shape: shapesArray) {
                System.out.println(shape.getHeight());
            }
            
            // Determine comparison property
            switch (comparisonProperty) {
                case "a":
                    break;
                case "v":
                    Sorting.SelectionSort(shapesArray, comparisonProperty);
                    break;
                case "h":
                    break;
                default:
                    return;
            }
            
                       
            
            // Testing 
            System.out.println("\n\n\nPost-Sorting");
            for (Shape shape: shapesArray) {
                System.out.println(shape.getHeight());
            }
           
                
		// TODO Auto-generated method stub

		// refer to demo001 BasicFileIO.java for a simple example on how to
		// read data from a text file

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

		// refer to demo03 OfficeManager.java on how to create specific
		// objects using reflection from a String
	}

}

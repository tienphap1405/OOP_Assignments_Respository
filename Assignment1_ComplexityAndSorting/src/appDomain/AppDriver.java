package appDomain;

public class AppDriver
{

	public static void main( String[] args )
	{
<<<<<<< Updated upstream
		// TODO Auto-generated method stub

		// refer to demo001 BasicFileIO.java for a simple example on how to
		// read data from a text file

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests
=======
            
            // Testing string args
            String[] testing = new String[3];
            
            testing[0] = "-Fshapes1.txt";
            testing[1] = "-Th";
            testing[2] = "-Sq";
            
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
            
            Comparator<Shape> comparator;
            
            switch (comparisonProperty) {
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
            System.out.println("Pre-Sorting");
            printArray(shapesArray, comparisonProperty);

            // Creating a copy of the array            
            // Determine comparison property

            switch (sortingMethod) {
                case "i" -> Sorting.InsertionSort(shapesArray, comparator);
                case "s" -> Sorting.SelectionSort(shapesArray, comparator);
                case "b" -> Sorting.BubbleSort(shapesArray, comparator);
                case "q" -> Sorting.QuickSort(shapesArray, 0, shapesArray.length - 1, comparator);
                case "m" -> Sorting.MergeSort(shapesArray, 0, shapesArray.length - 1, comparator);
                case "z" -> System.out.println("Missing sorting method");
                default -> {
                    System.err.println("Invalid sorting method, enter: i, s, b, q, m or z");
                    return;
                }
            }             
            
            // Testing 
            System.out.println("\n\n\nPost-Sorting");
            printArray(shapesArray, comparisonProperty);
           
>>>>>>> Stashed changes

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

		// refer to demo03 OfficeManager.java on how to create specific
		// objects using reflection from a String
	}

}

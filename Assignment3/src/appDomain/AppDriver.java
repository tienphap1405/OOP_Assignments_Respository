package appDomain;

import implementations.WordTracker;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * The AppDriver class is the Main class for the WordTracker application utilization.
 * It handles user input, validates arguments, and invokes the WordTracker functionality
 * for processing text files and generating reports.
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 */
public class AppDriver {


    /**
     * The main method is the entry point of the application.
     * It validates user arguments, invokes the WordTracker class, and handles file output.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        // Constants
        final String TXTSUFFIX = ".txt";
        final String HELPARGUMENT = "-h";
        final String PFFARGUMENT = "-pf";
        final String PLARGUMENT = "-pl";
        final String POARGUMENT = "-po";
        final String OUTPUTARGUMENT = "-f";
        
        // Optional help message
        if (args.length == 1) {
            if (args[0].equals(HELPARGUMENT)) {
                formatMessage();
                return;
            }
        }
        
        // Check for the correct number of inputs 2 without export and 4 with export
        if (args.length != 2 && args.length != 4) {
            System.err.println("Invalid number of inputs!");
            helpMessage();
            return;
        }
        
        // Check the first argument, and validate that is a readable .txt file
        String fileName = args[0];
        if (fileName.endsWith(TXTSUFFIX)) {
            File fileToValidate = new File("src/res/"+ fileName);
            
            if (!fileToValidate.exists()) {
                System.err.println("Please enter a .txt file that is in the res directory of the project.");
                helpMessage();
                return;
            }
            
        } else {
            System.err.println("Please enter a .txt file.");
            helpMessage();
            return;
        }
        
        // Determine if the file will be exported or not
        String outputFileName = null;
        if (args.length == 4) {
            if (args[2].equals(OUTPUTARGUMENT)) {
                if(args[3].endsWith(TXTSUFFIX)) {
                    outputFileName = args[3];
                } else {
                    System.err.println("Please enter a valid .txt file to export to.");
                    helpMessage();
                    return;
                }
            } else {
                System.err.println("Please enter -f and another text file to export to");
                helpMessage();
                return;
            }
        }
        
        // validate the exported file if it exists
        boolean exporting = false;
        PrintStream ps = null;
        if (outputFileName != null) {
            ps = validateOutput(outputFileName);
            exporting = true;
            if (ps == null) {
                System.err.println("Couldn't find the file to export to.");
                helpMessage();
                return;
            }    
        }
        
        // Determine the display option and run the program
        String displayOption = args[1];
        switch (displayOption.toLowerCase()) {
            case PFFARGUMENT, PLARGUMENT, POARGUMENT -> runWordTracker(displayOption, fileName, ps);
            default -> {
                System.err.println("Invalid Input: " + displayOption);
                System.err.println("Please enter one of these display options: -pf/-pl/-po");
                helpMessage();
                return;
            }
        }
        
        // Export confirmation message
        if (exporting == true){
            System.out.print("\n\nExporting file to: src/res/" + outputFileName);
        } else {
            System.out.println("\n\nNot exporting file");
        }
        System.out.println();
    
    }
    /**
     * Runs the WordTracker with the given input file and display option.
     * @param displayOption The display format: -pf, -pl, or -po.
     * @param fileName The input text file to process.
     * @param ps Optional PrintStream for exporting results to a file (null if not exporting).
     */   
    public static void runWordTracker(String displayOption, String fileName, PrintStream ps) {
        
        try {
            WordTracker wordTracker = new WordTracker(fileName, ps);

            wordTracker.readingTextFile(displayOption);
            wordTracker.treeSerialization();
        } catch (FileNotFoundException e) {
            System.err.println("Test file not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } 
    }
    

    /**
     * Validates and creates a PrintStream for the given output file.
     * @param outputFileName The name of the output file.
     * @return A PrintStream for the output file, or null if the file is invalid.
     */    
    public static PrintStream validateOutput(String outputFileName) {
        try {
            PrintStream ps = new PrintStream(new File("src/res/" + outputFileName));
            return ps;
        } catch (FileNotFoundException e) {
            System.err.println("Test file not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
        return null;
    }
    
    /**
     * Prints the guideline on how to use the program.
     */   
    public static final void formatMessage() {
        System.out.println("Format guide: java -jar ./dist/WordTracker.jar <input.txt> -pf/-pl/-po [-f <output.txt>]");
    }
    
    /**
     * Print help message
     */
    public static final void helpMessage() {
        System.out.println("Enter java -jar ./dist/WordTracker.jar -h for help.");
    }
}

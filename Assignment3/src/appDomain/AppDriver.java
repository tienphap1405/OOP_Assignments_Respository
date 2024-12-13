package appDomain;

import implementations.WordTracker;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class AppDriver {

    public static void main(String[] args) {
        // Constants
        final String TXTSUFFIX = ".txt";
        final String HELPARGUMENT = "-h";
        final String PFFARGUMENT = "-pf";
        final String PLARGUMENT = "-pl";
        final String POARGUMENT = "-po";
        final String OUTPUTARGUMENT = "-f";
          
        if (args.length == 1) {
            if (args[0].equals(HELPARGUMENT)) {
                formatMessage();
                return;
            }
        }
        
        if (args.length != 2 && args.length != 4) {
            System.err.println("Invalid number of inputs!");
            helpMessage();
            return;
        }
        
        String fileName = args[0];
        if (!fileName.endsWith(TXTSUFFIX)) {
            System.err.println("Please enter a valid .txt file.");
            helpMessage();
        }
        
        
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
        boolean exporting = false;
        PrintStream ps = null;
        if (outputFileName != null) {
            ps = validateFile(outputFileName);
            exporting = true;
            if (ps == null) {
                System.err.println("Couldn't find the file to export to.");
                helpMessage();
                return;
            }    
        }
        
        String displayOption = args[1];
        switch (displayOption.toLowerCase()) {
            case PFFARGUMENT, PLARGUMENT, POARGUMENT -> runWordTracker(displayOption, fileName, ps);
            default -> {
                System.err.println("Invalid Input: " + displayOption);
                System.err.println("Please enter one of these display options: -pf/-pl/-po");
                helpMessage();
            }
        }
        if (exporting == true){
            System.out.print("\n\nExporting file to: src/res/" + outputFileName);
        } else {
            System.out.println("\n\nNot exporting file");
        }
        System.out.println();
    
    }
    
    public static void runWordTracker(String displayOption, String fileName, PrintStream ps) {
        
        try {
            WordTracker wordTracker = new WordTracker(fileName, ps);

            System.out.println("Reading and processing the file...");
            wordTracker.readingTextFile(displayOption);
            wordTracker.treeSerialization();
        } catch (FileNotFoundException e) {
            System.err.println("Test file not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } 
    }
    
    public static PrintStream validateFile(String outputFileName) {
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
    
    public static final void formatMessage() {
        System.out.println("Format guide: java -jar WordTracker.jar <input.txt> -pf/-pl/-po [-f <output.txt>]");
    }
    
    public static final void helpMessage() {
        System.out.println("Enter java -jar WordTracker.jar -h for help.");
    }
}

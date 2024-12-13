package appDomain;

import implementations.*;
import java.io.FileNotFoundException;

/**
 * Main class that receives input from the user and uses it to create a Parser
 * object that does all of the parsing functionality
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 */
public class AppDriver {
    public static void main(String args[]) {
//        String TXTSUFFIX = ".txt";
//        if (args.length != 1 || !args[0].endsWith(TXTSUFFIX)) {
//            System.err.println("Program requires only one argument, please enter an .xml file");
//            return; 
//        }
        String displayOption = "insert here";
        
        
        WordTracker wordTracker = new WordTracker("simpleTest.txt");
        try {
            wordTracker.readingTextFile();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        
    }
}

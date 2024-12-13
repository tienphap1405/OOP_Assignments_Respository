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
//        String XMLSUFFIX = ".xml";
//        if (args.length != 1 || !args[0].endsWith(XMLSUFFIX)) {
//            System.err.println("Program requires only one argument, please enter an .xml file");
//            return; 
//        }

        // Use the provided XML file path
        // String parserPath = args[0];
        
        // Display
        //System.out.println("================ERROR LOG===============");
        

        WordTracker wordTracker = new WordTracker("simpleTest.txt");
        try {
            wordTracker.readingTextFile();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}

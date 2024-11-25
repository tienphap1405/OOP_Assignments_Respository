package appDomain;

import exceptions.EmptyQueueException;
import implementations.*;
import java.io.FileNotFoundException;

/**
 * Main class
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 */
public class AppDriver {
    public static void main(String args[]) throws EmptyQueueException {
//        String XMLSUFFIX = ".xml";
//        if (args.length != 1 || !args[0].endsWith(XMLSUFFIX)) {
//            System.err.println("Program requires only one argument, please enter an .xml file");
//            return; 
//        }

        // Use the provided XML file path
        String parserPath = "sample2.xml";
        
        // Display
        System.out.println("================ERROR LOG===============");
        

        Parser parser = new Parser(parserPath);
        try {
            parser.parsingXML();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    public static void print(Object message) {
        System.out.println(message);
    }       
}

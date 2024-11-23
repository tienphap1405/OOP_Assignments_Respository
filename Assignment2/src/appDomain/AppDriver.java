
package appDomain;

import implementations.*;
import java.io.FileNotFoundException;


/**
 *
 * @author tienp
 */
public class AppDriver {
    public static void main(String args[]){
        
        String XMLSUFFIX = ".xml";
   
//        if (!args[0].endsWith(XMLSUFFIX) && args[1] != null) {
//            System.err.println("Program requires only one argument,please enter an .xml file");
//            return; 
//        }

//      String parserPath = args[0];
        
        // Attempting Parser stuff...
        Parser parser = new Parser("sample2.xml"); // parserPath
        try {
            parser.parsingXML();
        }
        catch (FileNotFoundException e) {
            System.err.print(e.getMessage());
        }

    }
    
    public static void print(Object message){
        System.out.println(message);
    }       
}

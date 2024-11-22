
package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author tienp
 */
public class AppDriver {
    public static void main(String args[]){

    // Attempting Parser stuff...
    File file = new File("src\\res\\sample1.xml"); 
    try {
        ReadFile(file);
    }
    catch (FileNotFoundException e) {
        System.err.print(e.getMessage());
    }
    
    




    }
    
    public static void print(Object message){
        System.out.println(message);
    }
    
    public static void ReadFile(File filePath) throws FileNotFoundException {
        Scanner sc = new Scanner(filePath);
        // This is for the first line that isn't a self-closing tag and 
        // is an exception
        
        sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            String[] lines = line.split("<>");
            for (String eachline: lines) {
                print(eachline);
            }
            
        }
    }
    
}

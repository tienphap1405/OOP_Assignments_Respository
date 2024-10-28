package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import shapes.*;

/**
 *
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 */
public class ReadFile { 
    
    /**
     *
     * @param filePath
     * @return
     * @throws FileNotFoundException
     */
    public static Shape[] loadShapes(String filePath) throws FileNotFoundException {
       
        // Only works on userInputs -fshapes1.txt, -fshapes2.txt and -fshapes3.txt
        // Create a File and Scanner
        File file = new File("src\\res\\" + filePath); 
        Scanner sc = new Scanner(file);
        
        int size = Integer.parseInt(sc.nextLine());

        Shape[] shapes = new Shape[size];
        
        int counter = 0;
        
        // Read each line in the file
        while (sc.hasNextLine()) {
            String[] parts = sc.nextLine().split(" ");
            
            String type = parts[0];
            double height = Double.parseDouble(parts[1]);
            // side length or radius
            double length = Double.parseDouble(parts[2]);
            
            switch (type) {
                case "Cylinder":
                    Cylinder cylinder = new Cylinder(height, length);
                    shapes[counter] = cylinder;
                    break;
                case "Cone":
                    Cone cone = new Cone(height, length);
                    shapes[counter] = cone;
                    break;
                case "Pyramid":
                    Pyramid pyramid = new Pyramid(height, length);
                    shapes[counter] = pyramid;
                    break;
                case "TriangularPrism":
                    TriangularPrism tPrism = new TriangularPrism(height, length);
                    shapes[counter] = tPrism;
                    break;
                case "SquarePrism":
                    SquarePrism sPrism = new SquarePrism(height, length);
                    shapes[counter] = sPrism;
                    break;
                case "PentagonalPrism":
                    PentagonalPrism pPrism = new PentagonalPrism(height, length);
                    shapes[counter] = pPrism;
                    break;
                case "OctagonalPrism":
                    OctagonalPrism oPrism = new OctagonalPrism(height, length);
                    shapes[counter] = oPrism;
                    break;
                default:
                    System.err.println(parts[0] + " was not found.");
                    break;
            }
            
            counter++;
        }

        // Close the Scanner
        sc.close();   
        return shapes;
    }    
    
}

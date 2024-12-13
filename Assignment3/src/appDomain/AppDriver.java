package appDomain;

import implementations.WordTracker;
import implementations.Word;
import java.io.FileNotFoundException;

import java.io.IOException;

public class AppDriver {

    public static void main(String[] args) {
        String testFileName = "simpleTest.txt";

        try {
            WordTracker wordTracker = new WordTracker(testFileName);

            System.out.println("Reading and processing the file...");
            wordTracker.readingTextFile();

            System.out.println("Serializing the tree...");
            wordTracker.treeSerialization();

            System.out.println("Testing deserialization...");
            WordTracker deserializedTracker = new WordTracker(testFileName);

            System.out.println("Contents of the BST after deserialization:");
            deserializedTracker.readingTextFile();

        } catch (FileNotFoundException e) {
            System.err.println("Test file not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
        
    }
}

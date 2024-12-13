package implementations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author roman
 */
public class WordTracker {
    
    private BSTree<Word> bst = new BSTree<>();
    private String fileName;
    private File file;

    public WordTracker(String fileName) {
        this.fileName = fileName;
        file = new File("src\\res\\" + fileName); 
    }
    
    public void readingTextFile() throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        
        int lineNumber = 1;
        while (sc.hasNextLine()) {
            processLine(sc.nextLine(), lineNumber, fileName);
            lineNumber++;
        }
        
        System.out.print("\n");   
    }
    
    public void processLine(String line, int lineNumber, String fileName) {
        StringBuilder sb = new StringBuilder();
        // ArrayList<Word> wordsFound = new ArrayList<>();
        
        boolean foundStartOfWord = false;

        // Check through each character in a line
        for (int i = 0; i < line.length(); i++) {
            char character = line.charAt(i);

            if (character != ' ') {
                if (!foundStartOfWord) {
                    foundStartOfWord = true;
                }
            }

            if (character == ' ') {
                if (foundStartOfWord){
                    // Build word
                    Word newWord = new Word(sb.toString(), lineNumber, fileName);
                    // Tree logic happens here
                    System.out.println(newWord);
                    
                    // Reset the StringBuilder to make new word
                    sb.setLength(0);
                    foundStartOfWord = false;
                } 
                continue;
            }
            
            if (foundStartOfWord) {
                sb.append(character);
            }

        }
    }
    
    /**
     * Simplifies displaying error messages syntax
     * @param message that which will be displayed
     */
    public void printError(Object message){
        System.err.println(message);
    }   
}

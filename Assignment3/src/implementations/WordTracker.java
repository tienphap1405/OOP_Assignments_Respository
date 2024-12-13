package implementations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import utilities.Iterator;

/**
 *
 * @author roman
 */
public class WordTracker {
    
    private BSTree<Word> bst = new BSTree<>();
    private String fileName;
    private File file;
    // restructure previous tree - file path here

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
        
        Iterator<Word> it = bst.inorderIterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        
        
        System.out.print("\n");   
    }
    
    public void processLine(String line, int lineNumber, String fileName) {
        StringBuilder sb = new StringBuilder();
        
        boolean foundStartOfWord = false;

        // Check through each character in a line
        for (int i = 0; i < line.length(); i++) {
            char character = line.charAt(i);

            if (Character.isLetter(character) || character == '\'') {
                if (!foundStartOfWord) {
                    foundStartOfWord = true;
                }
            }

            if (!Character.isLetter(character) && character != '\''){
                if (foundStartOfWord){
                    // Build word
                    Word newWord = new Word(sb.toString(), lineNumber, fileName);
                    
                    bst.add(newWord);
                    
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

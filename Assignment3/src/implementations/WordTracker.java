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
            Word currentWord = it.next();
            System.out.println(currentWord);
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
                    
                    buildWord(sb.toString(), lineNumber, fileName);
                    
                    // Reset the StringBuilder to make new word
                    sb.setLength(0);
                    foundStartOfWord = false;
                } 
                continue;
            }
            
            if (foundStartOfWord) {
                sb.append(character);
            }
            
            // if there is a word at the end of a line with no punctuation afterwards
            if (!sb.isEmpty() && i == line.length() - 1) {
                buildWord(sb.toString(), lineNumber, fileName);
                sb.setLength(0);
                foundStartOfWord = false;
            }

        }
    }
    
    public void buildWord(String contents, int lineNumber, String fileName) {
        Word newWord = new Word(contents, lineNumber, fileName);
                   
        // bst.add only returns false if it failed to add due to duplication
        boolean isDuplicated = !bst.add(newWord);

        if (isDuplicated) {
            Word previousInstance = bst.search(newWord).getElement();
            previousInstance.updateForDuplicates(lineNumber, fileName);
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

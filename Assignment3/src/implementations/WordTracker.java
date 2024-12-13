package implementations;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Scanner;
import utilities.Iterator;

/**
 *
 * @author roman
 */
public class WordTracker implements Serializable{
    private final String REPOSITORY_FILE = "repository.ser";
    private BSTree<Word> bsTree;
    private String fileName;
    private File file;
    private PrintStream ps = null;
    
    public WordTracker(String fileName, PrintStream ps) {
        this.fileName = fileName;
        this.file = new File("src/res/" + fileName);
        this.ps = ps;

        try {
            this.bsTree = treeDeserialization();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading repository: " + e.getMessage());
            this.bsTree = new BSTree<>(); // Initialize a new tree on failure
        }
    }
    
    public void readingTextFile(String displayOption) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        
        int lineNumber = 1;
        while (sc.hasNextLine()) {
            processLine(sc.nextLine(), lineNumber, fileName);
            lineNumber++;
        }
        
        displayResults(displayOption);
        
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
                    boolean specialCase = false;
                    String word = sb.toString();
                    
                    
                    if (word.equals("\'em")) {
                        specialCase = true;
                    }
                    
                    if (!specialCase) {
                        if (word.endsWith("\'")) {
                            word = word.substring(0,word.length() - 1);
                        }

                        if (word.startsWith("\'")) {
                            word = word.substring(1);
                        }
                    }
                    
                    if (!word.isBlank()) {
                        buildWord(word, lineNumber, fileName);
                    }
                       
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
        boolean isDuplicated = !bsTree.add(newWord);

        if (isDuplicated) {
            Word previousInstance = bsTree.search(newWord).getElement();
            previousInstance.updateForDuplicates(lineNumber, fileName);
        }   
    }
    
    
    public void treeSerialization() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(REPOSITORY_FILE))) {
            oos.writeObject(bsTree);
            System.out.println("BSTree serialized successfully. Size: " + bsTree.size());
        } catch (IOException e) {
            System.err.println("Serialization failed: " + e.getMessage());
        }
    }

    
    
    private BSTree<Word> treeDeserialization() throws IOException, ClassNotFoundException {
        File repoFile = new File(REPOSITORY_FILE);

        if (!repoFile.exists()) {
            System.out.println("No repository found. Starting with a new BSTree.");
            return new BSTree<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(repoFile))) {
            BSTree<Word> loadedTree = (BSTree<Word>) ois.readObject();
            System.out.println("Repository loaded successfully. Tree size: " + loadedTree.size());
            return loadedTree;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Deserialization failed: " + e.getMessage());
            return new BSTree<>();
        }
    }
    
    public void displayResults(String displayOption) {
        Iterator<Word> it = bsTree.inorderIterator();
        
        printToBoth("Writing " + displayOption.substring(1) + " format");
        while (it.hasNext()){
            Word currentWord = it.next();
            
            switch (displayOption) {
                case "-pl" -> {
                    printToBoth(currentWord.displayPL());
                }
                case "-pf" -> {
                    printToBoth(currentWord.displayPF());
                }
                case "-po" -> {
                    printToBoth(currentWord.displayPO());
                }
                default -> System.err.println("error!!"); 
            }
            
        }
        if (ps != null) {
            ps.close();   
        } 
    }
    
    public void printToBoth(String content) {
        System.out.println(content);
        if (ps != null){
            PrintStream original = System.out;
            
            System.setOut(ps);
            ps.println(content);
            
            System.setOut(original);
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

package implementations;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Word class represent the implementation of storing the information of word as objects 
 * along with its number of appearances accross files with line numbers.
 * Display the formatted output as -pf, -l, -po format types.
 * The implementation of Comparable and Serializable for the Word object to be serialized and comparable
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 */
public class Word implements Comparable<Word>, Serializable {
    
    private String word;
    private int numberOfApperances;
    private HashMap<String, ArrayList<Integer>> fileDictionary = new HashMap<>(); 
    

    /**
     * Constructs a Word object, constructing it with the given word, its line number,
     * and the file name where it was found. 
     * @param word The word to track.
     * @param lineNumber The line number where the word was found.
     * @param filename  The name of the file where the word was found.
     */
    public Word(String word, int lineNumber, String filename) { 
        
        ArrayList<Integer> lineNumbersList = new ArrayList<>();
        lineNumbersList.add(lineNumber);
        
        // Hashmap Implementation
        fileDictionary.put(filename, lineNumbersList);
        this.numberOfApperances = 1;
        this.word = word;
    }
    
    /**
     * Removes leading and trailing punctuation such as begining " and last " to form a word.
     * Handles special cases like "'em" where the punctuation is preserved.
     * @param word The word to process.
     * @return The word without leading or trailing punctuation.
     */
    public String stripPunctuation(String word) {
        if (word.equals("\'em")) {
            return word;
        }
        
        if (word.endsWith("\'")) {
            word = word.substring(0,word.length() - 1);
        }
        
        if (word.startsWith("\'")) {
            word = word.substring(1);
        }
        
        return word;
    }

    /**
     * Retrieve and return the word being tracked
     * @return the word.
     */
    public String getWord() {
        return word;
    }
    
    /**
     * Retrieve the total of appearances of the word that being tracked
     * @return the number of appearancces
     */
    public int getNumberOfApperances() {
        return numberOfApperances;
    }
    /**
     * Retrieves the file line-to-line numbers mapping for the word using HashMap library
     * @return a HashMap includes with the file names as the keys and lists of line numbers as values 
     */ 
    public HashMap<String, ArrayList<Integer>> getDictionary() {
        return fileDictionary;
    }
    

    /**
     * Updates the word's number of appearances when it is found again.
     * If the file is already tracked or the tracking on one file is duplicated, adds the new line number to the list of line numbers.
     * If the file is not tracked, creates a new entry for it.
     * @param newLineNumber The new line number where the word was found.
     * @param fileName The file name where the word was found.
     */
    public void updateForDuplicates(Integer newLineNumber, String fileName) {
        
        if (fileDictionary.containsKey(fileName)) {
            ArrayList<Integer> oldNumbers = fileDictionary.get(fileName);
            oldNumbers.add(newLineNumber);
            fileDictionary.put(fileName, oldNumbers);
        } else {
            ArrayList<Integer> newNumbers = new ArrayList<>();
            newNumbers.add(newLineNumber);
            fileDictionary.put(fileName, newNumbers);
        }
        
        this.numberOfApperances = numberOfApperances + 1;
    }
    
    /**
     * Display word information 
     */
    @Override
    public String toString() {
        return "Key : ===" + this.word + "=== ";
    }
    
    /**
     * Display the number of appearances of the word.
     * @return a formatted display of the total number of appearances.
     */
    public String displayNumberOfEntries() {
        return "number of entries: " + this.numberOfApperances + " ";
    }
    
    /**
     * Display the formatted output of all the files where the word appears.
     * @return a formatted string listing the file names
     */
    public String displayFiles() {
        String completeString = "";
        for (String key : fileDictionary.keySet()) {
            String foundFileString = "found in file(s): " + key + ", ";
            completeString += foundFileString;
        }

        return completeString;
    }
    
    /**
     * Displays all files as well with the line numbers where the word appears.
     * @return A formatted string listing file names and line numbers.
     */
    public String displayFilesAndLines() {
        String completeString = "";
        for (String key : fileDictionary.keySet()) {
            String foundFileString = "found in file: " + key + " on line(s): ";
            completeString += foundFileString;
            
            ArrayList<Integer> linesFound = fileDictionary.get(key);
            for (Integer line : linesFound) {
                completeString += line + ", ";
            }            
        }
        
        return completeString;
    }
    
    /**
     * Option -pf for displaying the formatted word only showing files.
     * @return the formatted string for the -pf option when users input and running the program 
     */
    public String displayPF() {
        return toString() + displayFiles();
    }
    
    /**
     * Option -pl for displaying the formatted word only showing files and line numbers.
     * @return the formatted string for the -pl option when users input and running the program. 
     */
    public String displayPL() {
        return toString() + displayFilesAndLines();
    }
    
    /**
     * Option -po for displaying the formatted word showing all the options, files, line numbers and the number of appearances.
     * @return the formatted string for the -po option when users input and running the program. 
     */
    public String displayPO() {
        return toString() + displayNumberOfEntries() + displayFilesAndLines();
    }
    
    /**
     * Compares this word with another word alphabetically, ignoring case.
     * @param other The other word to compare to.
     * @return zero if both the words are equal
     *         negative if this word is less than other word
     *         positive if this word is larger than the other word
     */
    @Override
    public int compareTo(Word other) {
        if (this.word.toLowerCase().compareTo(other.word.toLowerCase()) == 0) {
            return 0;
        } else if (this.word.toLowerCase().compareTo(other.word.toLowerCase()) < 0) {
            return -1;
        } else {
            return 1;
        }
    }
    
}

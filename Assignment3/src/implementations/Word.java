package implementations;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author roman
 */
public class Word implements Comparable<Word>, Serializable {
    
    private String word;
    private int numberOfApperances;
    private HashMap<String, ArrayList<Integer>> fileDictionary = new HashMap<>(); 
    
    public Word(String word, int lineNumber, String filename) { 
        
        ArrayList<Integer> lineNumbersList = new ArrayList<>();
        lineNumbersList.add(lineNumber);
        
        // Hashmap Implementation
        fileDictionary.put(filename, lineNumbersList);
        this.numberOfApperances = 1;
        this.word = word;
    }
    
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

    public String getWord() {
        return word;
    }
    
    public int getNumberOfApperances() {
        return numberOfApperances;
    }
     
    public HashMap<String, ArrayList<Integer>> getDictionary() {
        return fileDictionary;
    }
    
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
    
    // Bellow are all methods to make sense of the formatting needed to be displayed
    //
    //
    @Override
    public String toString() {
        return "Key : ===" + this.word + "=== ";
    }
    
    public String displayNumberOfEntries() {
        return "number of entries: " + this.numberOfApperances + " ";
    }
    
    public String displayFiles() {
        String completeString = "";
        for (String key : fileDictionary.keySet()) {
            String foundFileString = "found in file(s): " + key + ", ";
            completeString += foundFileString;
        }

        return completeString;
    }
    
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
    
    // -pf format
    public String displayPF() {
        return toString() + displayFiles();
    }
    
    // -pl format
    public String displayPL() {
        return toString() + displayFilesAndLines();
    }
    
    // -po format
    public String displayPO() {
        return toString() + displayNumberOfEntries() + displayFilesAndLines();
    }
    
    // comparison ignores capitalization as per the assignment output
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

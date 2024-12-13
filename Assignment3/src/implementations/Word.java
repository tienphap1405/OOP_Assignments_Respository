package implementations;
import java.util.ArrayList;

/**
 *
 * @author roman
 */
public class Word implements Comparable<Word> {
    
    private String word;
    private ArrayList<Integer> lineNumbers= new ArrayList<>();
    private ArrayList<String> fileNames = new ArrayList<>();
    private int numberOfApperances;
    
    public Word(String word, int lineNumber, String filename) { 
        lineNumbers.add(lineNumber);
        fileNames.add(filename);
        this.numberOfApperances = 1;
        
        if (word.equals("\'em")) {
            this.word = word;
            return;
        }
        
        if (word.endsWith("\'")) {
            word = word.substring(0,word.length() - 1);
        }
        
        if (word.startsWith("\'")) {
            word = word.substring(1);
        }
       
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public ArrayList<Integer> getLine() {
        return lineNumbers;
    }

    public ArrayList<String> getFilename() {
        return fileNames;
    }
    
    public int getNumberOfApperances() {
        return numberOfApperances;
    }
    
    public void updateAppearances(ArrayList<Integer> lineNumbers, ArrayList<String> fileNames) {
        this.numberOfApperances = numberOfApperances + 1;
        
        Integer newLineNumber = lineNumbers.get(0);     
        if (!this.lineNumbers.contains(newLineNumber)) {
            this.lineNumbers.add(newLineNumber);
        }
        
        String newFileName = fileNames.get(0);
        if (!this.fileNames.contains(newFileName)) {
            this.fileNames.add(newFileName);
        }
    }

    @Override
    public String toString() {
        return "Word{" + "word=" + word + ", lineNumber=" + lineNumbers + ", filename=" + fileNames + ", numberOfApperances=" + numberOfApperances + '}';
    }

    @Override
    public int compareTo(Word other) {
        if (this.word.compareTo(other.word) == 0) {
            // "This" is the word object that is being added but is a duplicate.
            // "Other" is the word object that already exists, as being updated by the information in "This" word
            other.updateAppearances(this.lineNumbers, this.fileNames);
            return 0;
        } else if (this.word.compareTo(other.word) < 0) {
            return -1;
        } else {
            return 1;
        }
    }
    
}

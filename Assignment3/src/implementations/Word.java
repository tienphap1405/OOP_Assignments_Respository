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
           
        this.word = stripPunctuation(word);
    }
    
    public final String stripPunctuation(String word) {
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

    public ArrayList<Integer> getLine() {
        return lineNumbers;
    }

    public ArrayList<String> getFilename() {
        return fileNames;
    }
    
    public int getNumberOfApperances() {
        return numberOfApperances;
    }
    
    public void updateForDuplicates(Integer newLineNumber, String newFileName) {
        
        if (!this.lineNumbers.contains(newLineNumber)) {
            this.lineNumbers.add(newLineNumber);
        }
        
        if (!this.fileNames.contains(newFileName)) {
            this.fileNames.add(newFileName);
        }
        
        this.numberOfApperances = numberOfApperances + 1;
    }

    @Override
    public String toString() {
        return "Word{" + "word=" + word + ", lineNumbers=" + lineNumbers + ", filenames=" + fileNames + ", numberOfApperances=" + numberOfApperances + '}';
    }

    @Override
    public int compareTo(Word other) {
        if (this.word.compareTo(other.word) == 0) {
            return 0;
        } else if (this.word.compareTo(other.word) < 0) {
            return -1;
        } else {
            return 1;
        }
    }
    
}

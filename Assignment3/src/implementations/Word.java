package implementations;

/**
 *
 * @author roman
 */
public class Word implements Comparable<Word> {
    
    private String word;
    private int lineNumber;
    private String filename;
    
    public Word(String word, int line, String filename) { 
        this.word = word;
        this.lineNumber = line;
        this.filename = filename;
    }

    public String getWord() {
        return word;
    }

    public int getLine() {
        return lineNumber;
    }

    public String getFilename() {
        return filename;
    }
    
    @Override
    public String toString() {
        return "Word{" + "word=" + word + ", line=" + lineNumber + ", filename=" + filename + '}';
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

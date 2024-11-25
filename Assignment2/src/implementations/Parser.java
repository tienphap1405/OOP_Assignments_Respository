
package implementations;

import exceptions.EmptyQueueException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import utilities.Iterator;

/**
 * The class that manages the parsing process of the .xml file
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 */
public class Parser {
    
    private MyQueue<Tag> errorQueue = new MyQueue<>();
    private MyQueue<Tag> extrasQueue = new MyQueue<>();
    private MyStack<Tag> tagStack = new MyStack<>();
    private File file;
    
    /**
     * Constructor for a Parser
     * Stores a File object using the filename entered to then parse later
     * @param fileName is the name of the .xml file in the res folder
     */
    public Parser(String fileName) {
        file = new File("src\\res\\" + fileName); 
    }
    
    /**
     * The main parsing methodc
     * It uses a scanner object to read the file stored in the parser
     * it stores tags created by the processLine() method and then passes each 
     * one to the tagValidation() method to determine errors which are finally
     * displayed by the errorLog method if any are found
     * @throws java.io.FileNotFoundException if the file fails to open or is not found
     * @throws exceptions.EmptyQueueException if the queues are empty
     */
    public void parsingXML() throws FileNotFoundException, EmptyQueueException {
        Scanner sc = new Scanner(file);
        MyArrayList<Tag> tags = new MyArrayList<>();
        
        int lineNumber = -1; // to account for <?xml ...> tag 
        while (sc.hasNextLine()) {
            tags.addAll(processLine(sc.nextLine(), lineNumber));
            
            lineNumber++;
        }
        
        Iterator<Tag> tagsIterator = tags.iterator();
        while (tagsIterator.hasNext()) {
            Tag currentTag = tagsIterator.next();
            tagValidation(currentTag);
        }
        
        if (errorQueue.isEmpty() && extrasQueue.isEmpty()) {    
            System.out.println("No errors found");
            return;
        }
        
        System.out.print("\n"); 
        
        errorLog();   
    }
    
    /**
     * Reads through a line in the xml file an returns all found tags within the line
     * @param line the line being parsed through
     * @param lineNumber the current line number for error displays
     * @return an array of tags to later validate
     */
    public MyArrayList<Tag> processLine(String line, int lineNumber) {
        StringBuilder sb = new StringBuilder();
        MyArrayList<Tag> tagsFound = new MyArrayList<>();
        
        boolean foundBeginning = false;

        // Check through each character in a line
        for (int i = 0; i < line.length(); i++) {
            char character = line.charAt(i);

            if (character == '<') {
                if (!foundBeginning){
                    foundBeginning = true;
                } else {
                 printError("Invalid opening tag at line " + lineNumber + ":");
                 printError(line);
                }
                continue;
            }

            if (character == '>') {
                if (foundBeginning){
                    Tag tag = new Tag(sb.toString(), lineNumber);
                    tagsFound.add(tag);
                    
                    // Reset the StringBuilder to make new tags
                    sb.setLength(0);
                    foundBeginning = false;
                } else {
                 printError("Invalid close tag at line " + lineNumber + ":");
                 printError(line);
                }
                continue;
            }
            
            if (foundBeginning) {
                sb.append(character);
            }

        }

        return tagsFound;
    }
    
    /**
     * This method checks if the tags are opening, closing or ignorable.
     * If they are opening tags the are pushed on to the stack, then the last pushed
     * opening tag is compared to the closing tag and if they are the same there are no
     * errors, otherwise the tags are checked through to see where the errors are made
     * and stored in the queues
     * @param tag the tag that is currently being validated
     * @throws exceptions.EmptyQueueException if the queue is empty
     */
    public void tagValidation(Tag tag) throws EmptyQueueException {
        if (tag.canIgnore()) {
            return;
        }
        
        if (tag.isOpening()) {
           this.tagStack.push(tag);
        } else {
            
            Tag topOfStack = tagStack.size() > 0 ? tagStack.peek() : null;
            Tag topOfErrorQueue = errorQueue.size() > 0 ? errorQueue.peek() : null;
            
            if (tag.equals(topOfStack)) {
                tagStack.pop();   
            } else if (tagStack.isEmpty()) {
                errorQueue.enqueue(tag);
            } else {
                if (tagStack.contains(tag)) {
                    while (!tag.equals(topOfStack) && tagStack.size() > 0) { 
                        errorQueue.enqueue(tagStack.pop());
                        topOfStack = tagStack.size() > 0 ? tagStack.peek() : null;
                    }
                    tagStack.pop();
                } else {
                    extrasQueue.enqueue(tag);
                }
            }
        }
        
    }
    
    /**
     * This method checks for any errors after the validation process,
     * it pops and dequeues remaining tags from the stack and queues and displays an
     * error message for each by calling reportErrors().
     * This method's algorithm also prevents duplicate errors from being displayed
     * @throws exceptions.EmptyQueueException if the queue is empty
     */
    public void errorLog() throws EmptyQueueException{
        while(!tagStack.isEmpty()){
            errorQueue.enqueue(tagStack.pop());
        }
        while(!errorQueue.isEmpty() || !extrasQueue.isEmpty()){
            if(errorQueue.isEmpty() || extrasQueue.isEmpty()){
                reportErrors();
                break;
            }
            else{
                Tag errorTag = errorQueue.peek();
                Tag extraTag = extrasQueue.peek();
                if(!errorTag.equals(extraTag)){
                    Tag error = errorQueue.dequeue();
                    printError("Error at line " + error.getLineNumber() + ": \n\t"+ error.getCompleteTag());
                }
                else{
                    errorQueue.dequeue();
                    extrasQueue.dequeue();
                }
            }
            
        }
    }

    /**
     * This method displays the errors for any remaining tags in either queue
     * @throws exceptions.EmptyQueueException if the queue is empty
     */
    public void reportErrors() throws EmptyQueueException{
        while(!errorQueue.isEmpty()){
            Tag error = errorQueue.dequeue();
            printError("Error at line " + error.getLineNumber() + ": \n\t"+ error.getCompleteTag());
            
        }
        while(!extrasQueue.isEmpty()){
            Tag extra = extrasQueue.dequeue();
            printError("Error at line " + extra.getLineNumber() + ": \n\t"+ extra.getCompleteTag());
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

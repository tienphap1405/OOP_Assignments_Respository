
package implementations;

import exceptions.EmptyQueueException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.Iterator;

/**
 *
 * @author Simon Luna Patiarroy
 */
public class Parser {
    
    private MyQueue<String> errorQueue = new MyQueue<>();
    private MyQueue<String> extrasQueue = new MyQueue<>();
    private MyStack<String> tagStack = new MyStack<>();
    private File file;
    
    public Parser(String fileName) {
        file = new File("src\\res\\" + fileName); 
    }
    
    public void parsingXML() throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        MyArrayList<Tag> tags = new MyArrayList<>();
        
        int lineNumber = -1; // to account for <?xml ...> tag 
        while (sc.hasNextLine()) {
            tags.addAll(processLine(sc.nextLine(), lineNumber));
            
            lineNumber++;
        }  
        // prints all tags in a line
        tags.printList();
        System.out.print("\n\n");
        
        Iterator<Tag> tagsIterator = tags.iterator();
        while (tagsIterator.hasNext()) {
            Tag currentTag = tagsIterator.next();
            try {
                tagValidation(currentTag);
            } catch (EmptyQueueException | EmptyStackException ex) {
                Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (errorQueue.isEmpty() && extrasQueue.isEmpty()) {
            System.out.println("No errors found");
        }
        
    }
    
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
                 printError("Invalid opening tag at line " + lineNumber);
                 printError(line);
                }
                continue;
            }

            if (character == '>') {
                if (foundBeginning){
                    Tag tag = new Tag(sb.toString());
                    tagsFound.add(tag);
                    
                    // Reset the StringBuilder to make new tags
                    
                    sb.setLength(0);
                    foundBeginning = false;
                } else {
                 printError("Invalid close tag at line " + lineNumber);
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
    
    public void tagValidation(Tag tag) throws EmptyQueueException {
        if (tag.canIgnore()) {
            return;
        }
        
        String tagName = tag.getName();
        
        if (tag.isOpening()) {
           this.tagStack.push(tagName);
        } else {
            
            String topOfStack = tagStack.size() > 0 ? tagStack.peek() : null;
            String topOfErrorQueue = errorQueue.size() > 0 ? errorQueue.peek() : null;
            
            // TODO add size check or peek will blow up (multiple times)
            if (tagName.equals(topOfStack)) {
                tagStack.pop();
            } else if (tagName.equals(topOfErrorQueue)) {
                errorQueue.dequeue();   
            } else if (tagStack.isEmpty()) {
                errorQueue.enqueue(tagName);
            } else {
                if (tagStack.contains(tagName)) {
                    while (!tagName.equals(topOfStack) && tagStack.size() > 0) { 
                        errorQueue.enqueue(tagStack.pop());
                        topOfStack = tagStack.size() > 0 ? tagStack.peek() : null;
                    }
                    tagStack.pop();
                } else {
                    extrasQueue.enqueue(tagName);
                }
            }
        }
        
    }
        
    public void printError(Object message){
        System.err.println(message);
    }      
    
}

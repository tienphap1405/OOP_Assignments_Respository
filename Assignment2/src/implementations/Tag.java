/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

/**
 *
 * @author Simon Luna Patiarroy, Tien Phap (Evan) Nguyen
 */
public class Tag {
    private String name;
    private boolean isOpening;
    private boolean canIgnore = false;
    
    /**
     * Constructor for a Tag
     * Determines if it is opening based on whether or not the tag starts with '/'
     * Determines if it is ignorable based on if its a self closing tag or a processing tag
     * Determines the name of the tag with the first word inside the tag structure
     * @param content the text inside a tag 
     */
    public Tag(String content) {
        
        isOpening = !content.startsWith("/");
        canIgnore = content.endsWith("/") || content.startsWith("?");
        
        // Determine the tag name
        String[] parts = content.split(" ");
        this.name = parts[0];
        if (!isOpening) {
            name = name.substring(1);
        } 
    }
    
    /**
     * Return the tag name without any extraneous attributes
     * @return the tag name
     */
    public String getName() {
        return name;
    }

    /**
     * Return whether or not the tag is an opening tag or closing tag
     * @return true if the tag is an opening tag and false if its a closing tag
     */
    public boolean isOpening() {
        return isOpening;
    }

    /**
     * Return whether the tag can be ignored for the purposes of the parser
     * i.e. a self closing tag
     * @return the true if the tag can be ignored and false if it must be processed
     */
    public boolean canIgnore() {
        return canIgnore;
    }
    
    /**
     * Returns all the details of the tag to be easily displayed in the console
     * @return a formatted string that displays the tags attributes
     */
    @Override 
    public String toString() {
        String openOrClosed = isOpening ? "Open" : "Close";
        
        if (canIgnore) {
            return "Ignored";
        }
        
        String formatString = "Name:" + this.name  
                + " | Opening/Closing: " + openOrClosed;
        return formatString;
    }
    
}

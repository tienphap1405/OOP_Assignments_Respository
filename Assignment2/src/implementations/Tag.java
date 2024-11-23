/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

/**
 *
 * @author roman
 */
public class Tag {
    private String name;
    private boolean isOpening;
    private boolean canIgnore = false;
    
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

    public String getName() {
        return name;
    }

    public boolean isOpening() {
        return isOpening;
    }

    public boolean canIgnore() {
        return canIgnore;
    }
    
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

package implementations;

/**
 * Tab objects contain all the necessary details of a tag such as its name
 * the line number the tag was found and if its an opening tag or closing tag
 * @author Simon Luna Patiarroy, Tien Phap (Evan) Nguyen
 */
public class Tag {
    private String name;
    private String completeTag;
    private int lineNumber;
    private boolean isOpening;
    private boolean canIgnore = false;
    
    /**
     * Constructor for a Tag
     * Determines if it is opening based on whether or not the tag starts with '/'
     * Determines if it is ignorable based on if its a self closing tag or a processing tag
     * Determines the name of the tag with the first word inside the tag structure
     * @param content the text inside a tag 
     * @param lineNumber the line number in which the tag was found
     */
    public Tag(String content, int lineNumber) {
        this.completeTag = "<" + content + ">";
        this.lineNumber = lineNumber;
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
     * Return the line number at which the tag was found
     * @return the line number at which the tag was found
     */
    public int getLineNumber() {
        return lineNumber;
    }
    
    /**
     * Return the tag without any changes
     * @return the full tag without changes to display to the user
     */
    public String getCompleteTag() {
        return completeTag;
    }

    /**
     * Determines if the Tags are equal based on their names only
     * @param object to compare to this tag
     * @return true if the Tag names are the same or false otherwise
     */
    @Override
    public boolean equals(Object object) {
        // Check if its a reference
        if (this == object) {
            return true;
        }
        
        // Checking its the same class to then cast.
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Tag other = (Tag)object;
        return name.equals(other.name);
    }
    
}

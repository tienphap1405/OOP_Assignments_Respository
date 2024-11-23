package unitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import implementations.Tag;

/**
 *
 * @author Simon Luna Patiarroy
 */
public class TagTest {
    
    private Tag opening;
    private Tag closing;
    private Tag selfClosing;
    private Tag processing;
    private Tag customTag;
    

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {

        opening = new Tag("XTML");
        closing = new Tag("/XTML");
        selfClosing = new Tag("XTML/");
        processing = new Tag("?xml ...");
        customTag = null;
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
        opening = null;
        closing = null;
        selfClosing = null;
        processing = null;
        customTag = null;
    } 
    
    @Test
    public void testName() throws Exception {
        String expected = "XTML";
        String actualOpening = opening.getName();
        String actualClosing = closing.getName();
        String actualSelfOpening = selfClosing.getName();
        assertEquals(expected, actualOpening);
        assertEquals(expected, actualClosing);
        assertEquals(expected, actualSelfOpening);
    }
    
    @Test
    public void testIsOpening() throws Exception {
        Boolean expected = true;
        Boolean actual = opening.isOpening();
        assertEquals(expected, actual);
    }
    
    @Test
    public void testCanIgnore() throws Exception {
        Boolean expected = true;
        Boolean actual1 = selfClosing.canIgnore();
        Boolean actual2 = processing.canIgnore();
        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
    }
    
    public void testMultipleTagAttributes() throws Exception {
        customTag = new Tag("Language LanguageName=\"Basque\"");
        Boolean expected = true;
        Boolean actual = customTag.isOpening();
        
        String expectedName = "Language";
        String actualName = customTag.getName();
        
        assertEquals(expected, actual);
        assertEquals(expectedName, actualName);   
    }
}

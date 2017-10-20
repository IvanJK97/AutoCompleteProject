import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

// -------------------------------------------------------------------------
/**
 * Test class for Node
 *
 * @author Ivan
 * @version Nov 18, 2016
 */
public class NodeTest
{
    private Node node;


    // ----------------------------------------------------------
    /**
     * Create a node object
     */
    @Before
    public void setUp()
    {
        node = new Node();
    }


    // ----------------------------------------------------------
    /**
     * Test getter and setter for the prefix field
     */
    @Test
    public void testGetAndSetPrefixes()
    {
        node.setPrefixes(5);
        assertEquals(5, node.getPrefixes());
    }


    // ----------------------------------------------------------
    /**
     * Test getter and setter for the word field
     */
    @Test
    public void testGetAndSetWords()
    {
        node.setWords(5);
        assertEquals(5, node.getWords());
    }


    // ----------------------------------------------------------
    /**
     * Test getter and setter for the term field
     */
    @Test
    public void testGetAndSetTerms()
    {
        node.setTerm("Flash");
        node.setWeight(5);
        assertEquals("Flash", node.getTerm().getQuery());
        assertEquals(5, node.getTerm().getWeight());
    }


    // ----------------------------------------------------------
    /**
     * Test toString method
     */
    @Test
    public void testToString()
    {
        node.setTerm("Flash");
        node.setWeight(5);
        node.setWords(3);
        node.setPrefixes(4);
        node.toString();
        assertEquals("3\t4\t5\tFlash", node.toString());
    }

}

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

// -------------------------------------------------------------------------
/**
 * Test for autocomplete class.
 *
 * @author Ivan
 * @version Dec 5, 2016
 */
public class AutocompleteTest
    extends Autocomplete
{

    /**
     * String object
     */
    String       a;
    /**
     * Autocomplete object
     */
    Autocomplete b;
    /**
     * Autocomplete object
     */
    Autocomplete c;
    /**
     * Node object
     */
    Node         n1;


    // ----------------------------------------------------------
    /**
     * Creating object Autocomplete, node, and string
     */
    @Before
    public void setUp()
    {
        a = "feldspar";
        b = new Autocomplete();
        c = new Autocomplete();
        n1 = new Node();
    }


    // ----------------------------------------------------------
    /**
     * Test adding word and getting subTries
     */
    @Test
    public void testAddWord()
    {
        b.addWord(a, 2);
        assertEquals("2\tfeldspar", b.getSubTrie(a).getTerm().toString());
    }


    // ----------------------------------------------------------
    /**
     * Test adding word
     */
    @Test
    public void testAddWord2()
    {
        c.addWord("honey", 1);
        assertEquals("1\thoney", c.getSubTrie("honey").getTerm().toString());
    }
}

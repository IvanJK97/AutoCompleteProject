import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.Before;
import java.util.*;

// -------------------------------------------------------------------------
/**
 * Test class for Term
 *
 * @author Ivan
 * @version Nov 18, 2016
 */
public class TermTest
{
    private ArrayList<Term> aL;
    private Term            t1 = new Term("Dad", 5);
    private Term            t2 = new Term("Bad", 6);
    private Term            t3 = new Term("Cad", 8);
    private Term            t4 = new Term("Illiad", 15);
    private Term            t5 = new Term("Sad", 2);
    private Term            t6 = new Term("Illead", 12);


    // ----------------------------------------------------------
    /**
     * Constructor for arrayList
     */
    @Before
    public void setUp()
    {
        aL = new ArrayList<Term>();
        aL.add(t1);
        aL.add(t2);
        aL.add(t3);
        aL.add(t4);
        aL.add(t5);
    }


    // ----------------------------------------------------------
    /**
     * Test getQuery()
     */
    @Test
    public void testGetQuery()
    {
        assertEquals("Dad", t1.getQuery());
    }


    // ----------------------------------------------------------
    /**
     * Test getWeight()
     */
    @Test
    public void testGetWeight()
    {
        assertEquals(5, t1.getWeight());
    }


    // ----------------------------------------------------------
    /**
     * Test compareTo()
     */
    @Test
    public void testCompareTo()
    {
        assertEquals(1, t1.compareTo(t3));
    }


    // ----------------------------------------------------------
    /**
     * Test byReverseWeightOrder()
     */
    @Test
    public void testByReverseWeightOrder()
    {
        Collections.sort(aL, Term.byReverseWeightOrder());
        System.out.println(aL);
    }


    // ----------------------------------------------------------
    /**
     * Test byPrefixOrder()
     */
    @Test
    public void testByPrefixOrder()
    {
        aL.add(t6);
        Collections.sort(aL, Term.byPrefixOrder(3));
        System.out.print(aL);
    }


    // ----------------------------------------------------------
    /**
     * Test toString()
     */
    @Test
    public void testToString()
    {
        assertEquals("6\tBad", t2.toString());
    }
}

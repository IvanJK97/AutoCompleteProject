import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * Term class represents an auto complete term Implements Comparable
 *
 * @author Ivan
 * @version Nov 18, 2016
 */
public class Term
    implements Comparable<Term>
{

    // Instance variables
    private String query;
    private long   weight;


    // ----------------------------------------------------------
    /**
     * Constructor for Term object
     *
     * @param query
     *            String parameter
     * @param weight
     *            Long parameter
     */
    public Term(String query, long weight)
    {
        if (query == null)
        {
            throw new NullPointerException();
        }
        if (weight < 0)
        {
            throw new IllegalArgumentException("Illegal Argument");
        }
        this.query = query;
        this.weight = weight;
    }


    // ----------------------------------------------------------
    /**
     * Getter for query field
     *
     * @return This term's query field
     */
    public String getQuery()
    {
        return query;
    }


    // ----------------------------------------------------------
    /**
     * Setter for query
     *
     * @param query
     *            that you want to set it to
     */
    public void setQuery(String query)
    {
        this.query = query;
    }


    // ----------------------------------------------------------
    /**
     * Getter for weight field
     *
     * @return This term's weight field
     */
    public long getWeight()
    {
        return weight;
    }


    // ----------------------------------------------------------
    /**
     * Setter for weight
     *
     * @param weight
     *            that you want to set it to
     */
    public void setWeight(long weight)
    {
        this.weight = weight;
    }


    // ----------------------------------------------------------
    /**
     * Implementation of compareTo method which compares the query of both terms
     *
     * @return This term's weight field
     */
    public int compareTo(Term that)
    {
        return this.query.toLowerCase()
            .compareTo(that.getQuery().toLowerCase());
    }


    // ----------------------------------------------------------
    /**
     * Compares the two terms in descending order by weight
     *
     * @return Comparator comparing the terms' weights
     */
    public static Comparator<Term> byReverseWeightOrder()
    {
        return new Comparator<Term>() {
            public int compare(Term first, Term second)
            {
                return (int)(second.weight - first.weight);
            };
        };
    }


    // ----------------------------------------------------------
    /**
     * Compares the two terms in lexicographic order but using only the first r
     * characters of each query
     *
     * @param r
     *            to set first r amount of character of query to compare
     * @return Comparator comparing the terms' queries
     */
    public static Comparator<Term> byPrefixOrder(int r)
    {
        if (r < 0)
        {
            throw new IllegalArgumentException("Argument is negative");
        }
        return new Comparator<Term>() {
            public int compare(Term first, Term second)
            {
                String query1 = first.getQuery().substring(0, r);
                String query2 = second.getQuery().substring(0, r);
                return query1.compareTo(query2);
            };
        };
    }


    // ----------------------------------------------------------
    /**
     * Returns a string representation of this term
     *
     * @return the weight, followed by a tab, followed by the query
     */
    public String toString()
    {
        return weight + "\t" + query;
    }

}

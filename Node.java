// -------------------------------------------------------------------------
/**
 * Node class that represents a node in Trie. Node data type acts as a wrapper
 * class of Term data type
 *
 * @author Ivan
 * @version Nov 18, 2016
 */
public class Node
{

    private Term   term;
    private int    words;
    private int    prefixes;
    private Node[] references;


    // ----------------------------------------------------------
    /**
     * Constructor for Node object
     */
    public Node()
    {
        references = new Node[26];
        for (int i = 0; i < references.length; i++)
        {
            references[i] = null;
        }
        prefixes = 0;
        words = 0;
        term = new Term("", 0);
    }


    /**
     * Getter for children of a node
     *
     * @return Node's array children field
     */
    public Node[] getChildren()
    {
        return this.references;
    }


    /**
     * Setter for children of a node
     *
     * @param references
     *            arraylist to be set to
     */
    public void setChildren(Node[] references)
    {
        this.references = references;
    }


    /**
     * Getter for prefixes field
     *
     * @return Node's prefixes field
     */
    public int getPrefixes()
    {
        return prefixes;
    }


    /**
     * Setter for prefixes
     *
     * @param prefixes
     *            that you want to set it to
     */
    public void setPrefixes(int prefixes)
    {
        if (prefixes < 0)
        {
            throw new IllegalArgumentException();
        }
        this.prefixes = prefixes;
    }


    // ----------------------------------------------------------
    /**
     * Getter for words field
     *
     * @return Node's words field
     */
    public int getWords()
    {
        return words;
    }


    // ----------------------------------------------------------
    /**
     * Setter for words
     *
     * @param words
     *            that you want to set it to
     */
    public void setWords(int words)
    {
        if (words < 0)
        {
            throw new IllegalArgumentException();
        }
        this.words = words;
    }


    // ----------------------------------------------------------
    /**
     * Getter for term field
     *
     * @return Node's term field
     */
    public Term getTerm()
    {
        return term;
    }


    // ----------------------------------------------------------
    /**
     * Updates the field term of the Term data field
     *
     * @param term
     *            that you want to set it to
     */
    public void setTerm(String term)
    {
        if (term == null)
        {
            throw new NullPointerException();
        }
        this.term.setQuery(term);
    }


    // ----------------------------------------------------------
    /**
     * Updates the weight the Term data field
     *
     * @param weight
     *            that you want to set it to
     */
    public void setWeight(long weight)
    {
        if (weight < 0)
        {
            throw new IllegalArgumentException();
        }
        this.term.setWeight(weight);
    }


    // ----------------------------------------------------------
    /**
     * Returns a String representation of the node
     *
     * @return words, prefixes, and term, each separated by tabs.
     */
    public String toString()
    {
        return words + "\t" + prefixes + "\t" + term.toString();
    }
}

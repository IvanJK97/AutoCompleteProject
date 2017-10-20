import java.util.*;

// -------------------------------------------------------------------------
/**
 * Autocomplete class that creates a root node for the trie and allows users to
 * add words through prefixes
 *
 * @author Ivan
 * @version Dec 5, 2016
 */
public class Autocomplete
{

    private Node root;


    // ----------------------------------------------------------
    /**
     * Constructor for Autocomplete object.
     */
    public Autocomplete()
    {
        root = new Node();
    }


    // ----------------------------------------------------------
    /**
     * Recursive addWord method which cuts leftmost character of prefixes and
     * add it to the trie until prefix is empty.
     *
     * @param vertex
     *            node for each prefix
     * @param prefix
     *            for letters of the word
     * @param word
     *            to add
     * @param weight
     *            of word
     */
    public void addWord(Node vertex, String prefix, String word, int weight)
    {
        if (prefix.isEmpty())
        {
            vertex.setWords(vertex.getWords() + 1);
            vertex.setWeight(weight);
            vertex.setTerm(word);
        }
        else
        {
            vertex.setPrefixes(vertex.getPrefixes() + 1);
            char k = prefix.charAt(0);
            if (vertex.getChildren()[getCharIndex(k)] == null)
            {
                vertex.getChildren()[getCharIndex(k)] = new Node();
            }
            String prefix1 = prefix.substring(1);
            addWord(
                vertex.getChildren()[getCharIndex(k)],
                prefix1,
                word,
                weight);
        }
    }


    // ----------------------------------------------------------
    /**
     * Helper non-recursive method that launches the recursive addWord method
     * with node at the root and prefix equals to word. Adds a new word with its
     * associated weight to the Trie.
     *
     * @param word
     *            to be added
     * @param weight
     *            associated with the word
     */
    public void addWord(String word, int weight)
    {
        word.toLowerCase();
        addWord(root, word, word, weight);
    }


    // ----------------------------------------------------------
    /**
     * Recursive getSubTrie method. You launch the recursion with node at the
     * root of the Trie, with each recursive call you must remove the first
     * character of prefix. You end your search when you have exhausted all the
     * characters in prefix. charAt used to return the first character of first
     * prefix.
     *
     * @param prefix
     *            to get subTrie
     * @param node
     *            root node
     * @return children node
     */
    public Node getSubTrie(String prefix, Node node)
    {
        if (node == null)
        {
            return null;
        }
        else
        {
            if (prefix.isEmpty())
            {
                return node;
            }
            else
            {
                return getSubTrie(
                    prefix.substring(1),
                    node.getChildren()[getCharIndex(prefix.charAt(0))]);
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Helper non-recursive method that launches the recursive getSubTrie
     * method. The method returns the root of the subTrie corresponding to the
     * last character of the prefix.
     *
     * @param prefix
     *            to get subTrie for
     * @return node corresponding to last character of prefix
     */
    public Node getSubTrie(String prefix)
    {
        return getSubTrie(prefix, root);
    }


    // ----------------------------------------------------------
    /**
     * Method that given a char, returns its index in the array of references.
     * Makes the translation from an index in [97,122] to one in [0,25] for each
     * character.
     *
     * @param c
     *            char to get index for
     * @return int representation of char
     */
    public int getCharIndex(char c)
    {
        Character.toLowerCase(c);
        int x = c - 97;
        if (x > 25 || x < 0)
        {
            throw new IllegalArgumentException();
        }
        return x;
    }


    // ----------------------------------------------------------
    /**
     * Method that returns the number of words that start with the prefix
     *
     * @param prefix
     *            for words to start with
     * @return number of words that start with the prefix
     */
    public int countPrefixes(String prefix)
    {
        if (getSubTrie(prefix) == null)
        {
            return 0;
        }
        return getSubTrie(prefix).getPrefixes();
    }

// // ----------------------------------------------------------
// /**
// * Place a description of your method here.
// * @param vertex
// * @param prefix
// * @return
// */
// public int countPrefixes(Node vertex, String prefix) {
// char k = prefix.charAt(0);
// if (prefix.isEmpty()) {
// return vertex.getPrefixes();
// }
// else if (vertex.getChildren()[getCharIndex(k)] == null) {
// return 0;
// }
// else {
// String prefix1 = prefix.substring(1);
// return countPrefixes(vertex, prefix1);
// }
// }
//
// public int countPrefixes(String prefix) {
// return countPrefixes(root, prefix);
// }


    // ----------------------------------------------------------
    /**
     * Helper method getSuggestions start recursive getSuggestions at the
     * correct node
     *
     * @param prefix
     *            for each suggestion to start with
     * @return ArrayList of Terms that corresponds to the prefix
     */
    public ArrayList<Term> getSuggestions(String prefix)
    {
        Node vertex1 = getSubTrie(prefix);
        return getSuggestions(vertex1);
    }


    // ----------------------------------------------------------
    /**
     * Recursive getSuggestions start at the last node of the prefix and get
     * children nodes to find words until children are exhausted
     *
     * @param vertex
     *            corresponding to the last node of prefix
     * @return ArrayList of Terms that are found in nodes descended from the
     *         parameter node
     */
    public ArrayList<Term> getSuggestions(Node vertex)
    {
        ArrayList<Term> aL = new ArrayList<Term>();
        if (vertex == null)
        {
            return aL;
        }
        else
        {
            if (vertex.getWords() > 0)
            {
                aL.add(vertex.getTerm());
            }
            for (int i = 0; i < 26; i++)
            {
                aL.addAll(getSuggestions(vertex.getChildren()[i]));
            }
            return aL;
        }
    }
}

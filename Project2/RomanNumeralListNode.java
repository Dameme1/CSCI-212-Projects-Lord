/**
 * Node class that lets us create a node
 *
 * @author T. Ahmed
 */
public class RomanNumeralListNode { // allows us to create nodes, for the linked list
    public RomanNumeral data; // the actual data for each node
    public RomanNumeralListNode next; // the pointer to the next node.

    /**
     * constructor to create a node with a String parameter to set the 'data' into a Roman Numeral
     *
     * @param data the parameter to be set to the nodes field
     */
    public RomanNumeralListNode(RomanNumeral d) { // creates a node with an empty pointer value
        data = d;
        next = null;
    }// constructor

    /**
     * constructor to create an empty node
     */
    public RomanNumeralListNode() { // creates a node with empty data AND pointer values
        data = null;
        next = null;
    }// constructor
}

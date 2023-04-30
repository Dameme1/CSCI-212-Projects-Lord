/**
 * Roman Numeral List class that lets us create a linked list to store RomanNumerals
 *
 * @author T. Ahmed
 */
public class RomanNumeralList {

    /**
     * First node of the list
     */
    protected RomanNumeralListNode first; //protected allows the subclasses to have access to these values, without making it public
    /**
     * Last node of the list
     */
    protected RomanNumeralListNode last;
    /**
     * Length of the list
     */
    protected int length;

    /**
     * Constructor to create a new Linked List with a first and last node, as well as declaring the length to 0
     */
    public RomanNumeralList() { // constructor creates a new node in a list and keeps track of the length
        RomanNumeralListNode ln = new RomanNumeralListNode();
        first = ln; // sets first equal to the new node
        last = ln; // sets last equal to the new node
        length = 0;
    } // constructor
} // List class

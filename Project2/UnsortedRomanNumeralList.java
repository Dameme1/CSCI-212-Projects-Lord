/**
 * Unsorted RomanNumeral list class that was extended from RomanNumeralList
 *
 * @author T. Ahmed
 */
public class UnsortedRomanNumeralList extends RomanNumeralList {
    /**
     * Creates a node which stores a RomanNumeral, the node is then appended onto the end of the Linked List
     *
     * @param s the RomanNumeral to be stored in a node
     */
    public void append(RomanNumeral s) { // constructor just appends the inputed value to the end of the list
        RomanNumeralListNode n = new RomanNumeralListNode(s);
        last.next = n;  // sets the previous last node's next value to the new one.
        last = n; //sets the last to be the new last.
        length++; //increases the length of the list.
    } // constructor
} // unSorted class

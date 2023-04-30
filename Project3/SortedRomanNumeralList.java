/**
 * Sorted RomanNumeral list class that was extended from the RomanNumeralList class
 *
 * @author T. Ahmed
 */
public class SortedRomanNumeralList extends RomanNumeralList {

    /**
     * Creates a node which stores a RomanNumeral, then places the node
     * in the appropriate place in the linked list to keep the list in ascending order
     *
     * @param s the RomanNumeral to be stored in a node
     */
    public void add(RomanNumeral s) { // adds the roman numeral to the right position in the list to keep it ascending
        RomanNumeralListNode n = new RomanNumeralListNode(s);
        RomanNumeralListNode current = first; //allows me to iterate through the list
        while (current.next != null && current.next.data.getArabic() <= n.data.getArabic()) {
            current = current.next; // will continue running until the end of the array or until we find the spot for
        }                            // the new node
        n.next = current.next;
        current.next = n;
        length++;
    }// constructor
}// sortedList class

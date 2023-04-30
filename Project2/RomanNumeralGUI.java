import javax.swing.*;
import java.awt.*;

/**
 * RomanNumeralGUI that extends the JFrame class
 *
 * @author T. Ahmed
 */
public class RomanNumeralGUI extends JFrame { // extending JFrame
    /**
     * constructor that creates the GUI with a specific size and location and the title is given by the user
     *
     * @param title is the String title inputed by the user.
     */
    public RomanNumeralGUI(String title) {
        setTitle(title); // sets the title of the GUI
        setSize(800, 500); // sets the size of the GUI
        setLocation(100, 100); // sets the location on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ends the program when the GUI gets closed
    } // constructor

    /**
     * Method that takes a RomanNumeral GUI, an unsorted LinkedList, and a sorted LinkedList and displays them all on
     * the screen in three separate columns.
     *
     * @param rmnGUI   variable that holds the GUI
     * @param unSorted variable that holds the unSorted array
     * @param sorted   variable the holds the sorted array
     */
    public static void printRnGUI(RomanNumeralGUI rmnGUI, UnsortedRomanNumeralList unSorted, SortedRomanNumeralList sorted) {
        Container myContentPane = rmnGUI.getContentPane(); // creates the content pane so we get attach the text areas
        TextArea myRoman = new TextArea(); // for the Roman numerals
        TextArea myUnsorted = new TextArea(); // for the unsorted array
        TextArea mySorted = new TextArea(); // for the sorted array
        rmnGUI.setLayout(new GridLayout(1, 3)); // creates 3 columns with 1 row

        RomanNumeralListNode current1 = unSorted.first;
        RomanNumeralListNode current2 = sorted.first;
        while ((current1 = current1.next) != null) { // iterates through the whole link list
            myRoman.append(current1.data.getRoman() + "\n"); // appends the roman numerals to the first column
            myUnsorted.append(Integer.toString(current1.data.getArabic()) + "\n"); // appends the unsorted to the second
        }

        while ((current2 = current2.next) != null) { // iterates through the whole link list
            mySorted.append(Integer.toString(current2.data.getArabic()) + "\n"); // appends the sorted to the third
        }

        myContentPane.add(myRoman); // attaches the text areas to the content pane so it can actually be displayed
        myContentPane.add(myUnsorted);
        myContentPane.add(mySorted);
        rmnGUI.setVisible(true);
    }// print method
} // GUI Class

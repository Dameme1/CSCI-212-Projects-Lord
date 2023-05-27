import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Convert menu handler class that performs an action based on the user's menu selection
 * contains logic for returning the arabic value from a user-inputed Roman Numeral
 *
 * @author T. Ahmed
 */

public class ConvertMenuHandler implements ActionListener {

    /**
     * JFrame object that will allow us to change things on the GUI screen
     */
    JFrame jframe;

    /**
     * constructor that takes in the JFrame object which will be used
     *
     * @param jf JFrame object that will be passed in.
     */
    public ConvertMenuHandler(JFrame jf) {
        jframe = jf;
    }

    /**
     * checks for Actions by the user and does the corresponding event for the action.
     *
     * @param event
     */

    public void actionPerformed(ActionEvent event) {
        String user = JOptionPane.showInputDialog(null, "Enter a Roman Numeral");

        try { // first tries to create a RomanNumeral object with the user inputted String.
            RomanNumeral input = new RomanNumeral(user); // creates a Roman Numeral object
            JOptionPane.showMessageDialog(null, Integer.toString(input.getArabic())); // Shows the message dialogue
        } catch (
                IllegalRomanNumeralException e) { // if the user inputted string is not a Roman Numeral, a JOption Dialogue box will display so.
            JOptionPane.showMessageDialog(null, "You did not input a valid Roman Numeral"); // displays dialogue box.
            System.out.println(e + user); //prints error message into the console.
        }
    } //actionPerformed
}

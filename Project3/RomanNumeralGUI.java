import javax.swing.*;

/**
 * RomanNumeralGUI that extends the JFrame class
 *
 * @author T. Ahmed
 */
public class RomanNumeralGUI extends JFrame { // extending JFrame
    /**
     * constructor that creates the GUI with a specific size and location and the title is given by the user
     * and will also create the menu-bar on the GUI itself
     *
     * @param title is the String title inputted by the user.
     */
    public RomanNumeralGUI(String title) {
        setTitle(title); // sets the title of the GUI
        setSize(800, 500); // sets the size of the GUI
        setLocation(100, 100); // sets the location on the screen
        createMenu(); // creates menu selector on the GUI itself
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ends the program when the GUI gets closed
        setVisible(true); // allows user to see the GUI
    } // constructor


    /**
     * Method that creates the menu selection on the GUI with two options, 'File' which has two options (open, and quit),
     * and 'Convert' that has one option (Roman to Arabic)
     * <p>
     * File Menu - Open will let user select a file, the opened txt file will then display 3 columns, a column
     * containing the Roman Numerals, and the next two will be sorted and unsorted arabic translations.
     * <p>
     * File Menu - Close will let user close the GUI.
     * <p>
     * Convert Menu - Roman to Arabic will pop up a screen and allows the user to input a Roman Numeral and its
     * value will get returned onto the screen.
     */
    private void createMenu() { // creates the menu-bar on the GUI with its respective options

        JMenuBar menuBar = new JMenuBar(); // creates menuBar object

        JMenu fileMenu = new JMenu("File"); // creates the 'File' option for the menuBar
        JMenuItem item; // will be one of the drop-down options in 'File'
        FileMenuHandler fmh = new FileMenuHandler(this); //Handles the actions that take place in the 'File' menu
        item = new JMenuItem("Open"); // creates the 'Open' drop down option
        item.addActionListener(fmh); // action listener, runs fmh when user clicks on 'Open'
        fileMenu.add(item); // adds 'Open' to the fileMenu
        fileMenu.addSeparator(); // creates a separator for the next fileMenu option
        item = new JMenuItem("Quit"); // creates the 'Quit' option for the file menu
        item.addActionListener(fmh); // action listener, runs fmh when user clicks on 'Quit'
        fileMenu.add(item); // adds 'Quit' to the fileMenu

        JMenu convertMenu = new JMenu("Convert"); // creates the 'Convert' option for the menuBar
        JMenuItem item2; // will be one of the drop-down options in 'Convert'
        ConvertMenuHandler cmh = new ConvertMenuHandler(this); //Handles the actions that take place in the 'Convert' Menu
        item2 = new JMenuItem("Roman to Arabic");// Creates 'Roman to Arabic' drop down option
        item2.addActionListener(cmh); // action listener, runs cmh when user clicks on 'Roman to Arabic'
        convertMenu.add(item2); // adds 'Roman to Arabic' to convertMenu


        setJMenuBar(menuBar); //sets menuBar on the GUI
        menuBar.add(fileMenu); // adds the fileMenu drop down to the menuBar
        menuBar.add(convertMenu); // adds the convertMenu drop down to the menuBar
    }
} // GUI Class

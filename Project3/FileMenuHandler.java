import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.StringTokenizer;

/**
 * File menu handler class that performs an action based on the user's menu
 * selection contains logic for opening file, reading from file, reading Roman Numerals from file, and uses
 * sorted list and unsorted to list the arabic constituents respectively.
 *
 * @author T. Ahmed
 */

public class FileMenuHandler implements ActionListener {
    /**
     * jframe object that will allow us to change things on the GUI screen
     */
    JFrame jframe;

    /**
     * constructor that takes in the JFrame object which will be used
     *
     * @param jf JFrame object that will be passed in.
     */
    public FileMenuHandler(JFrame jf) {
        jframe = jf;
    }

    /**
     * Checks for actions by the user and does the corresponding event for each action.
     *
     * @param event ActionEvent object that will retrieve information from the user selection on the menubar
     */

    public void actionPerformed(ActionEvent event) {
        String menuName;
        menuName = event.getActionCommand(); // gets the actionCommand chosen (string)
        if (menuName.equals("Open")) //if 'Open' was chosen, the corresponding function will be called
            openFile(); // method that opens the file.
        else if (menuName.equals("Quit"))// if 'Quit' was chosen, the corresponding function will be called
            System.exit(0); // ends the program
    } //actionPerformed

    /**
     * Method that allows user to select an input file, and shows message if file is not
     * selected
     */
    private void openFile() {
        JFileChooser chooser = new JFileChooser(); // JFileChoose object that will retrieve information from user's choices
        int status;
        status = chooser.showOpenDialog(null); // finds out if the user opened a file
        if (status == JFileChooser.APPROVE_OPTION) // if the user opens a file, run the readSource method
            readSource(chooser.getSelectedFile());
        else // if the user doesn't choose a file, dialogue box displays which indicates so.
            JOptionPane.showMessageDialog(null, "Open File dialog canceled");
    } //openFile


    /**
     * First clears the GUI of any previous chosen output, then reads the input file and outputs the content
     * to the GUI
     *
     * @param chosenFile file to be passed through
     */
    private void readSource(File chosenFile) {
        String chosenFileName = chosenFile.getAbsolutePath(); // gets the absolute path of the user chosen file
        TextFileInput in = new TextFileInput(chosenFileName); // allows us to read the file
        UnsortedRomanNumeralList unSorted = new UnsortedRomanNumeralList(); //initialize the unsorted linked list
        SortedRomanNumeralList sorted = new SortedRomanNumeralList(); // initialize the sorted linked list

        clearGUI(); // clears the GUI with any previous baggage
        setLists(in, unSorted, sorted); // creates the linked lists, sorted and unsorted


        Container myContentPane = jframe.getContentPane(); // creates the content pane, so we get attach the text areas
        TextArea myRoman = new TextArea(); // for the Roman numerals
        TextArea myUnsorted = new TextArea(); // for the unsorted array
        TextArea mySorted = new TextArea(); // for the sorted array
        myContentPane.setLayout(new GridLayout(1, 3)); // creates 3 columns with 1 row

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
        jframe.setVisible(true);
    }// read source

    /**
     * Clears the screen by removing all the previous baggage that remained on the screen from any previous
     * uses.
     */
    private void clearGUI() {
        jframe.getContentPane().removeAll();
    }

    /**
     * Creates all the necessary linked lists that need to be displayed on the screen
     *
     * @param in       the input file the user chose
     * @param unSorted the unSorted linked list
     * @param sorted   the sorted linked list
     */
    private void setLists(TextFileInput in, UnsortedRomanNumeralList unSorted, SortedRomanNumeralList sorted) {
        StringTokenizer myTokens; // Tokenizer Object
        String line, token;
        while ((line = in.readLine()) != null) { // runs until there are no more values in the file
            myTokens = new StringTokenizer(line, ","); // tokenizes values in each line
            while (myTokens.hasMoreTokens()) {// inputs each token into array individually
                token = myTokens.nextToken();
                try {
                    RomanNumeral s = new RomanNumeral(token); // goes through each token
                    unSorted.append(s); // adds to the end of the unsorted Linked List
                    sorted.add(s); // adds to the correct order in the sorted Linked List
                } catch (IllegalRomanNumeralException e) {
                    System.out.println(e + token); // prints exception into console
                }
            } // inner while
            myTokens = new StringTokenizer(line, ","); // updates the tokenizer object with the new line.
        }// outer while
    }// setLists method
}// class
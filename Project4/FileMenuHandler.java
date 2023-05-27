import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;

/**
 * File menu handler class that performs an action based on the user's menu
 * selection contains logic for opening file, reading from file, reading Roman Numerals from file, and uses
 * a tree map to map all of the items in the file.
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
        TreeMap<RomanNumeral, Object> treeMap = new TreeMap<RomanNumeral, Object>(new romanComparator());

        clearGUI(); // clears the GUI with any previous baggage
        setTreeMap(in, treeMap); // fills in the treeMap with all the values within the input file.

        Container myContentPane = jframe.getContentPane(); // creates the content pane, so we get attach the text areas
        TextArea myRoman = new TextArea(); // for the Roman numerals
        TextArea mapSorted = new TextArea();
        myContentPane.setLayout(new GridLayout(1, 2)); // creates 2 columns with 1 row

        Set set = treeMap.entrySet(); // entrySet() returns a collection of key/value pairs
        Iterator i = set.iterator(); // iterator to iterate through the Tree Map
        Map.Entry<RomanNumeral, Object> me;
        while(i.hasNext()){ // will continue looping until there are no more leaves to visit within the treemap.
            me = (Map.Entry)i.next(); // me is equal to the next entry in the tree map
            mapSorted.append(Integer.toString(me.getKey().getArabic()) + "\n"); // appends the arabic to the arabic side
            myRoman.append(me.getKey().getRoman() + "\n"); // appends the roman to the roman side.
        }
        myContentPane.add(myRoman); // adds the sorted roman numerals to the left side of the GUI
        myContentPane.add(mapSorted); // adds the sorted arabic values to the right side of the GUI
        jframe.setVisible(true); // allows the jfame to be visible.
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
     * @param treeMap  the treeMap that holds all the individual Roman Numerals in order.
     */
    private void setTreeMap(TextFileInput in, TreeMap treeMap) { // goes through the input file and inputs it into the tree.
        StringTokenizer myTokens; // Tokenizer Object
        String line, token;
        while ((line = in.readLine()) != null) { // runs until there are no more values in the file
            myTokens = new StringTokenizer(line, ","); // tokenizes values in each line
            while (myTokens.hasMoreTokens()) {// inputs each token into array individually
                token = myTokens.nextToken();
                try {
                    RomanNumeral s = new RomanNumeral(token); // goes through each token
                    treeMap.put(s,""); // puts the Roman Numeral into the treeMap
                } catch (IllegalRomanNumeralException e) {
                    System.out.println(e + token); // prints exception into console
                }
            } // inner while
            myTokens = new StringTokenizer(line, ","); // updates the tokenizer object with the new line.
        }// outer while
    }// setTreeMap method
}// class
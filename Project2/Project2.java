import java.util.StringTokenizer;

public class Project2 {
    public static void main(String[] args) {
        RomanNumeralGUI rmnGUI = new RomanNumeralGUI("Roman to Arabic GUI"); // creates GUI
        TextFileInput in = new TextFileInput("input.txt"); // file-name
        UnsortedRomanNumeralList unSorted = new UnsortedRomanNumeralList();
        SortedRomanNumeralList sorted = new SortedRomanNumeralList();
        StringTokenizer myTokens; // Tokenizer Object
        String line;
        while ((line = in.readLine()) != null) { // runs until there are no more values in the file
            myTokens = new StringTokenizer(line, ","); // tokenizes values in each line
            while (myTokens.hasMoreTokens()) { // inputs each token into array individually
                RomanNumeral s = new RomanNumeral(myTokens.nextToken()); // goes through each token
                unSorted.append(s); // adds to the end of the unsorted array
                sorted.add(s); // adds to the correct order in the sorted array
            } // inner while
            myTokens = new StringTokenizer(line, ","); // updates the tokenizer object with the new line.
        }// outer while
        rmnGUI.printRnGUI(rmnGUI, unSorted, sorted); // calling the GUI to pop it up
    }// main function
}

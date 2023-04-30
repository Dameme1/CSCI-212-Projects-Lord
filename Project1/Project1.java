import java.util.StringTokenizer;

public class Project1 {

    public static void main(String[] args) {
        RomanNumeralGUI rmnGUI = new RomanNumeralGUI("Roman to Arabic GUI"); // creates GUI
        TextFileInput in = new TextFileInput("input.txt"); // file-name
        String roman[] = new String[100];
        StringTokenizer myTokens; // Tokenizer Object
        int count = 0;
        String line;
        while ((line = in.readLine()) != null) { // runs until there are no more values in the file
            myTokens = new StringTokenizer(line, ","); // tokenizes values in each line
            while (myTokens.hasMoreTokens()) { // inputs each token into array individually
                roman[count] = myTokens.nextToken();
                count++;
            } // inner while
            myTokens = new StringTokenizer(line, ",");
        }// outer while
        rmnGUI.printRnGUI(rmnGUI, roman, count);
    }// main function

    public static int valueOf(String s) {
        if (s == null || s.length() == 0)
            return -1; // error case

        s = s.toUpperCase();

        int values[] = new int[]{1000, 500, 100, 50, 10, 5, 1}; // corresponds to each letter
        char[] romanLiterals = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int rawValues[] = new int[s.length()]; //array thats the length of the inputed string
        int result = 0;
        for (int i = 0; i < s.length(); i++) { // runs through the whole string
            for (int j = 0; j < romanLiterals.length; j++) { // fills array with raw values of each letter
                if (s.charAt(i) == romanLiterals[j]) {
                    rawValues[i] = values[j];
                }// if statement
            }// inner for
        }// outer for
        for (int i = rawValues.length - 1; i >= 0; i--) { // subtracts or adds depending on numeral position
            if (i > 0 && rawValues[i - 1] < rawValues[i]) {
                result += rawValues[i] - rawValues[i - 1];
                i--;
            } else {
                result += rawValues[i];
            }// if statement
        } // for-loop
        return result;
    }// valueOf method

}// Project1

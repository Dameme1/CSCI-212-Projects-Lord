/**
 * RomanNumeral class that holds a string that is a Roman Numeral and its corresponding Arabic value by calculating it
 * manually.
 *
 * @author T. Ahmed
 */
public class RomanNumeral { // RomanNumeral class, which has the roman and arabic numeral values.
    /**
     * Holds the roman numeral
     */
    private String Roman; // initialization
    /**
     * Holds the corresponding arabic numeral value
     */
    private int Arabic;
    /**
     * irne is the IllegalRomanNumeralException that will be thrown when it encounters a non-RomanNumeral.
     */
    IllegalRomanNumeralException irne = new IllegalRomanNumeralException("The following is not a valid Roman Numeral: ");

    /**
     * constructor that takes a string, and sets the Roman variable to the string
     * and sets the arabic value into its corresponding arabic numeral value using "valueOf"
     *
     * @param in string that is the Roman Numeral
     */
    RomanNumeral(String in) { // creates a roman numeral with the given Roman value and also calculates the corresponding
        if (!check(in)) {     // arabic value
            throw irne; // throws error exception
        }
        Roman = in;
        Arabic = valueOf(in);
    }

    /**
     * method that checks if the user inputted String is a valid Roman Numeral or not
     *
     * @param in user inputted string
     * @return returns a boolean value of whether the String inputted is a valid Roman Numeral
     */
    public static boolean check(String in) {
        in = in.toUpperCase(); // will work even if you use inputs only lowercase characters
        String checker = "MDCLXVI"; // string that holds all the possible Roman Numerals
        for (int i = 0; i < in.length(); i++) { // goes through each character in String
            if (!checker.contains(Character.toString(in.charAt(i)))) { // if the character in question is NOT contained in the checker string, we must return false.
                return false;
            }
        }
        return true;
    } // check method

    /**
     * gets the Roman of any given RomanNumeral
     * @return returns a string, which is the Roman Numeral
     */
    public String getRoman() { // returns the roman
        return Roman;
    } // getRoman

    /**
     * sets the Roman of any given RomanNumeral to the given String, and updates its corresponding
     * arabic numeral value
     *
     * @param in String that will be the new Roman value
     */
    public void setRoman(String in) { // sets the roman to a new value and updates the arabic value
        Roman = in;
        Arabic = valueOf(in);
    } // setRoman

    /**
     * gets the Arabic Numeral value of any given RomanNumeral value.
     *
     * @return returns the arabic numeral value (integer)
     */
    public int getArabic() { // returns the arabic
        return Arabic;
    } // getArabic

    /**
     * Overrides the equals function, allowing us to compare RomanNumerals to each other and see if they are equal
     * Takes advantage of the equals method in the String superclass.
     *
     * @param other the object that we are comparing out RomanNumeral with
     * @return returns a boolean
     */
    public boolean equals(Object other) { // checks if two RomanNumeral's are equal
        return (other != null && getClass() == other.getClass() && Roman.equals(((RomanNumeral) other).Roman));
    } //equals

    /**
     * compares any given RomanNumeral (this) with another (other) and returns true if (this) is larger than (other)
     * and returns false if (other) is larger than (this)
     *
     * @param other the RomanNumeral that we are comparing (this) to
     * @return returns a boolean
     */
    public boolean compareTo(RomanNumeral other) { //compares the integer values of the two RomanNumeral's
        if (this.getArabic() > other.getArabic()) // if (this) is bigger than (other), return true, else return false
            return true;
        return false;
    } // compareTo

    /**
     * toString method for the RomanNumeral class, simply returns the Roman String.
     *
     * @return returns a string
     */
    public String toString() { // toString method for Roman Numerals
        return Roman;
    } // toString

    /**
     * valueOf method converts a given Roman Numeral (a string) into an Arabic Numeral value (an integer)
     *
     * @param s the roman numeral that gets inputed
     * @return returns an integer
     */
    public static int valueOf(String s) {
        if (s == null || s.length() == 0)
            return -1; // error case

        s = s.toUpperCase();

        int values[] = new int[]{1000, 500, 100, 50, 10, 5, 1}; // corresponds to each letter
        char[] romanLiterals = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int rawValues[] = new int[s.length()]; //array that's the length of the inputted string
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
} // class

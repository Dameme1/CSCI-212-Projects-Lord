/**
 * Exception class that will show an exception when the String inputed is not a valid Roman Numeral
 *
 * @author T. Ahmed
 */
public class IllegalRomanNumeralException extends IllegalArgumentException {
    public IllegalRomanNumeralException(String message) {
        super(message);
    } // constructor
} // class
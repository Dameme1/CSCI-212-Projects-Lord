import java.util.Comparator;
/**
 * romanComparator class that compares inputted values in a treeMap using the 'compareTo' method created in the RomanNumeral class
 * it implements the Comparator interface
 *
 * @author T. Ahmed
 */
public class romanComparator implements Comparator<RomanNumeral> {
    public int compare(RomanNumeral x, RomanNumeral y){
        return x.compareTo(y); // uses the RomanNumeral 'compareTo' method and returns its integer value.
    } //compare method
}

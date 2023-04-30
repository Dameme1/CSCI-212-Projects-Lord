import javax.swing.*;

public class Project0 {
    public static void main(String[] args) {
        String input;// will hold the user input

        while (true) { //runs infinitely until "stop" case
            input = JOptionPane.showInputDialog(null, "Please enter a sentence.");

            if (input.equalsIgnoreCase("stop")) System.exit(0); // checks if user inputted "stop"

            JOptionPane.showMessageDialog(null, "Number of lower case e's:" + lower(input) +
                    "\nNumber of upper case E's:" + upper(input)); // outputs result onto screen
        }// while - loop
    }// main

    public static int upper(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'E') count++;
        }// for - loop
        return count;
    }// upper Method

    public static int lower(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'e') count++;
        }// for-loop
        return count;
    }// lower Method

}// class


import javax.swing.*;
import java.awt.*;


public class RomanNumeralGUI extends JFrame {
    public RomanNumeralGUI(String title) {
        setTitle(title);
        setSize(800, 500);
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // constructor

    public static void printRnGUI(RomanNumeralGUI rmnGUI, String[] list, int size) {
        Container myContentPane = rmnGUI.getContentPane();
        TextArea myTextArea = new TextArea();
        TextArea mySubscripts = new TextArea();
        rmnGUI.setLayout(new GridLayout(1, 2));


        for (int i = 0; i < size; i++) {
            myTextArea.append(list[i] + "\n");
            String sub = Integer.toString(Project1.valueOf(list[i]));
            mySubscripts.append(sub + "\n");
            sub = "";
        } // for-loop

        myContentPane.add(myTextArea);
        myContentPane.add(mySubscripts);
        rmnGUI.setVisible(true);
    }// print method
} // GUI Class

package View;

import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;

public class Zadanie11 extends JOptionPane {

    private String input;
    private String upper;

    Zadanie11() {
        input =  showInputDialog(null,"Zamień na Duże");

        try {
            upper = input.toUpperCase();
            System.out.println(upper);
            showMessageDialog(null,upper);
        } catch (HeadlessException e) {
            //e.printStackTrace();
            System.out.println("Invalid Input");
        } catch (NullPointerException e) {
            //e.printStackTrace();
            System.out.println("Cancelled");
        }
    }


}

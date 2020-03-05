package Model;

import javax.swing.*;
import java.math.BigInteger;

public class Zadanie12Model {


    public Zadanie12Model() {
    }

    public BigInteger silnia(String str) {

        BigInteger bi = null;
        try {
            bi = new BigInteger(str);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane warning =  new JOptionPane("Warning");
            warning.showMessageDialog(null,"Invalid Input");
        }

        BigInteger wynik = new BigInteger("1");
        BigInteger iterator = new BigInteger("1");



            for(iterator = BigInteger.ONE; iterator.compareTo(bi) <= 0; iterator = iterator.add(BigInteger.ONE)) {

                wynik = wynik.multiply(BigInteger.valueOf(iterator.longValue()));

                System.out.println(iterator + "   " + wynik);
            }

        return wynik;
    }

    public Zadanie12Model getZadanie12Model() {
        return this;
    }
}



package Model;

import java.math.BigInteger;

public class Zadanie12Model {


    public Zadanie12Model() {
    }

    public BigInteger silnia(String str) {

        BigInteger bi = new BigInteger(str);
        BigInteger wynik = new BigInteger("1");
        BigInteger iterator = new BigInteger("1");

        for(iterator = BigInteger.ONE; iterator.compareTo(bi) <= 0; iterator = iterator.add(BigInteger.ONE)) {

            wynik = wynik.multiply(BigInteger.valueOf(iterator.longValue()));

            System.out.println(iterator + "   "+ wynik);
        }
        return wynik;
    }

    public Zadanie12Model getZadanie12Model() {
        return this;
    }
}



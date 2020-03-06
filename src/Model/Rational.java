package Model;

public class Rational {

    int licznik;
    int mianownik;

    public Rational(int licznik, int mianownik) {


        this.licznik = licznik;
        if(mianownik == 0) throw new IllegalArgumentException("mianownik = 0");
        else this.mianownik = mianownik;
    }

    public Rational add(Rational arg) {
        int wLicznik =  this.licznik * arg.getMianownik() + arg.getLicznik() * this.mianownik;
        int wMianownik =  this.mianownik * arg.getMianownik();
        Rational wynik = new Rational(wLicznik,wMianownik);

        reduce(wynik);
        return wynik;
    }
    public Rational mul(Rational arg) {

        int wLicznik = this.licznik * arg.getLicznik();
        int wMianownik = this.mianownik * arg.getMianownik();
        Rational wynik = new Rational(wLicznik, wMianownik);
        reduce(wynik);
        return wynik;
    }

    public Rational sub(Rational arg) {

        int wLicznik =  this.licznik * arg.getMianownik() - arg.getLicznik() * this.mianownik;
        int wMianownik =  this.mianownik * arg.getMianownik();
        Rational wynik = new Rational(wLicznik,wMianownik);
        reduce(wynik);
        return wynik;
    }

    public Rational div(Rational arg) {

        int wLicznik = this.licznik * arg.getMianownik();
        int wMianownik = this.mianownik * arg.getLicznik();
        Rational wynik = new Rational(wLicznik, wMianownik);
        reduce(wynik);
        return wynik;
    }


    boolean equals(Rational arg) {
        return false;
    }

    int compareTo(Rational arg) {
        return 0;
    }

    public Rational reduce(Rational arg) {
        if (Math.abs(arg.licznik) < Math.abs(arg.mianownik)) {

            for(int i = 2; i <= Math.abs(arg.licznik); i++) {
                if(arg.licznik % i == 0 && arg.mianownik % i == 0) {
                    arg.licznik/=i;
                    arg.mianownik/=i;
                    i = 1;
                }
            }
        }
        else if(Math.abs(arg.licznik) > Math.abs(arg.mianownik)) {

            for(int i = 2; i <= Math.abs(arg.mianownik); i++) {
                if(arg.licznik % i == 0 && arg.mianownik % i == 0) {
                    arg.licznik/=i;
                    arg.mianownik/=i;
                    i = 1;
                }
            }
        }
        else {
            arg.licznik = 1;
            arg.mianownik = 1;
        }
        return arg;
    }

    public int getLicznik() {
        return licznik;
    }

    public void setLicznik(int licznik) {
        this.licznik = licznik;
    }

    public int getMianownik() {
        return mianownik;
    }

    public void setMianownik(int mianownik) {
        this.mianownik = mianownik;
    }

}
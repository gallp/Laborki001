package Model;

public class Rational {

    int licznik;
    int mianownik;

    public Rational(int licznik, int mianownik) {

        this.licznik = licznik;
        if(mianownik == 0) throw new IllegalArgumentException("mianownik = 0");
        else this.mianownik =mianownik;
    }

    public Rational add(Rational arg) {
        this.licznik = this.licznik*arg.getMianownik();
        arg.setLicznik(arg.getLicznik() * this.mianownik);
        Rational wynik = new Rational(this.licznik + arg.getLicznik(),this.mianownik * arg.getMianownik());
        red(wynik);
        return wynik;
    }
    public Rational mul(Rational arg) {

        int wLicznik = this.licznik * arg.getLicznik();
        int wMianownik = this.mianownik * arg.getMianownik();
        Rational wynik = new Rational(wLicznik, wMianownik);
        red(wynik);
        return wynik;
    }

    public Rational red(Rational arg) {
        if (arg.licznik < arg.mianownik) {

            for(int i = 2; i <= licznik; i++) {

                if(arg.licznik % i == 0 && arg.mianownik % i == 0) {
                    arg.licznik/=i;
                    arg.mianownik/=i;
                }
            }
        }

        else if (arg.licznik > arg.mianownik){
            for(int i = 2; i <= mianownik; i++) {

                if(arg.licznik % i == 0 && arg.mianownik % i == 0) {
                    arg.licznik/=i;
                    arg.mianownik/=i;
                }
            }
        }
        else {
            arg.licznik = 1;
            arg.mianownik = 1;
        }
        return arg;
    }

    public Rational sub(Rational arg) {
        return null;
    }

    public Rational div(Rational arg) {
        return null;
    }

    boolean equals(Rational arg) {
        return false;
    }

    int compareTo(Rational arg) {
        return 0;
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
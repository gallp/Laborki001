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


    public boolean equals(Rational arg) {
        reduce(this);
        reduce(arg);
        if(this.licznik == arg.licznik && this.mianownik == arg.mianownik)
            return true;
        else
            return false;
    }

    public int compareTo(Rational arg) {
        reduce(this);
        reduce(arg);
        double ilorazR1 = (double)this.licznik/(double)this.mianownik;
        double ilorazR2 = (double)arg.licznik/(double)arg.mianownik;

        if(ilorazR1 > ilorazR2) {
            return 1;
        }
        else if(ilorazR1 < ilorazR2) {
            return -1;
        }
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

    public String toString() {
        String str = String.valueOf(this.licznik) + "/" + String.valueOf(this.mianownik);
        return str;
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
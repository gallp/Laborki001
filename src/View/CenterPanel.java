package View;

import Model.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CenterPanel extends JPanel {

    private Zadanie12 zadanie12;
    private Zadanie12Model zadanie12Model;
    private Zadanie13 zadanie13;
    private Zadanie13Model zadanie13Model;
    private Zadanie14 zadanie14;
    private Zadanie14Model zadanie14Model;
    private Zadanie21 zadanie21;
    private Rational rational01;
    private Rational rational02;
    private Zadanie22 zadanie22;
    private FunkcjaKwadratowa funkcjaKwadratowa;
    private Zadanie41 zadanie41;

    private JTextArea textArea;
    private JTextArea textAreaZadanie;

    public CenterPanel() {
        super();
        Border outer = new TitledBorder("Center");
        setBorder(outer);
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textAreaZadanie = new JTextArea();
        textAreaZadanie.setLineWrap(true);

    }
    public void setTextArea(String str) {
        this.textArea.setText(str);
    }

    public void refresh() {
        removeAll();
        revalidate();
        repaint();
        textArea.setMinimumSize(new Dimension(100,100));
        textArea.setPreferredSize(new Dimension(100,100));
        textArea.setMaximumSize(new Dimension(100,100));

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.SOUTH);

    }
    public void addZadanie41() {
        this.zadanie41 = new Zadanie41();
        add(zadanie41, BorderLayout.CENTER);
    }

    public Zadanie41 getZadanie41() {
        return zadanie41;
    }

    public void addZadanie22() {
        this.zadanie22 = new Zadanie22();
        this.funkcjaKwadratowa = new FunkcjaKwadratowa();
        add(zadanie22,BorderLayout.CENTER);
        textAreaZadanie.setText("Napisz klasę opisującą równanie kwadratowe o postaci y = ax2+ bx +c. Współczynniki\n" +
                "a, b i c powinny być prywatne. Zdefiniuj następujące publiczne funkcje składowe:\n" +
                "• nadającą wartości współczynnikom,\n" +
                "• obliczającą y dla podanego x,\n" +
                "• wyznaczającą liczbę pierwiastków.\n" +
                "Potrzebne wzory:\n" +
                "4\n" +
                "• delta: d = b2− 4ac,\n" +
                "• liczba pierwiastków:\n" +
                "p =0 : d < 0, 1 : d = 0, 2 : d > 0.");
        Border outer = new EtchedBorder();
        textAreaZadanie.setBorder(outer);
        add(textAreaZadanie, BorderLayout.NORTH);
        textArea.setText(null);

    }

    public Zadanie22 getZadanie22() {
        return zadanie22;
    }
    public FunkcjaKwadratowa getFunkcjaKwadratowa() {
        return funkcjaKwadratowa;
    }

    public void addZadanie21() {
        this.zadanie21 = new Zadanie21();
        this.rational01 = new Rational(1,1);
        this.rational02 = new Rational(1,1);
        add(zadanie21,BorderLayout.CENTER);
        textAreaZadanie.setText("Zaprojektuj klasę Rational, reprezentującą liczby wymierne jako pary liczb całkowitych (licznik i mianownik), wraz z podstawowymi działaniami arytmetycznymi i porównaniem. W klasie powinny znaleźć się nastę-pujące metody publiczne (oprócz konstruktora):\n" +
                "1. dodawanie: Rational add(Rational arg);\n" +
                "2. mnożenie: Rational mul(Rational arg);\n" +
                "3. odejmowanie: Rational sub(Rational arg);\n" +
                "4. dzielenie: Rational div(Rational arg);\n" +
                "5. równość: boolean equals(Rational arg);\n" +
                "6. porównanie: int compareTo(Rational arg);\n" +
                "7. tekstowa reprezentacja liczby: String toString().\n" +
                "Metody 1–4 powinny zwracać jako rezultat referencję do nowego obiektu klasy Rational, będącego wynikiem operacji wykonanej na argumencie arg i this. Metoda 5. ma porównywać obiekty klasy Rational na podstawie wartości liczb, np. 1/2 = 2/4. Metoda 6. ma działać podobnie, jak odpowiadająca jej metoda compareTo(Object o) z interfejsu\n" +
                "java.lang.Comparable:\n" +
                "• Jeśli this jest równe arg, to zwraca 0.\n" +
                "• Jeśli this jest mniejsze od arg, to zwraca −1.\n" +
                "• Jeśli this jest większe niż arg, to zwraca 1.\n" +
                "Metoda 7. ma zwracać łańcuch znakowy opisujący ten obiekt. Na przykład może to być napis postaci 1/2 lub -1/1.");
        Border outer = new EtchedBorder();
        textAreaZadanie.setBorder(outer);
        add(textAreaZadanie, BorderLayout.NORTH);
        textArea.setText(null);

    }

    public Zadanie21 getZadanie21() {
        return zadanie21;
    }
    public Rational getRational01() {
        return rational01;
    }
    public Rational getRational02() {
        return rational02;
    }

    public void addZadanie14() {
        this.zadanie14 = new Zadanie14();
        this.zadanie14Model = new Zadanie14Model();
        add(zadanie14,BorderLayout.CENTER);
        textAreaZadanie.setText("Należy zaimplementować trzy metody pobierające jako argument liczbę całkowitą typu int i zwracającą łańcuch znakowy (obiekt klasy String) będący:\n" +
                "1. binarną reprezentacją argumentu,\n" +
                "2. ósemkową reprezentacją argumentu,\n" +
                "3. szesnastkową reprezentacją argumentu.");

        add(textAreaZadanie, BorderLayout.NORTH);
        textArea.setText(null);

    }
    public Zadanie14 getZadanie14() {
        return zadanie14;
    }
    public Zadanie14Model getZadanie14Model() {
        return zadanie14Model;
    }

    public void addZadanie13() {
        this.zadanie13 = new Zadanie13();
        this.zadanie13Model = new Zadanie13Model();
        add(zadanie13,BorderLayout.CENTER);
        textAreaZadanie.setText("Zadanie 1.3.\n" +
                "Napisać program sumujący liczby nieparzyste z przedziału od 1 do n, " +
                "gdzie n podaje użytkownik na starcie programu.\nProgram powinien zakończyć sumowanie na liczbie n, " +
                "gdy liczba n jest nieparzysta lub na liczbie n − 1, gdy liczba n jest parzysta.");
        add(textAreaZadanie,BorderLayout.NORTH);
        textArea.setText(null);
    }
    public Zadanie13 getZadanie13() {
        return zadanie13;
    }
    public Zadanie13Model getZadanie13Model() {
        return this.zadanie13Model;
    }


    public void addZadanie12() {
        this.zadanie12 = new Zadanie12();
        this.zadanie12Model = new Zadanie12Model();
        add(zadanie12,BorderLayout.CENTER);
        textAreaZadanie.setText("Zadanie 1.2.\n" +
                "Korzystając z klasy BigInteger napisać program, który wyznacza silnię z podanej liczby całkowitej n " +
                "nawet dla dużych n (rzędu kilkuset).");
        add(textAreaZadanie,BorderLayout.NORTH);
        textArea.setText(null);
    }
    public Zadanie12 getZadanie12() {
        return this.zadanie12;
    }
    public Zadanie12Model getZadanie12Model() {
        return this.zadanie12Model;
    }
}

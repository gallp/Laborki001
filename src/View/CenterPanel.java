package View;

import Model.Zadanie12Model;
import Model.Zadanie13Model;
import Model.Zadanie14Model;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CenterPanel extends JPanel {

    private Zadanie12 zadanie12;
    private Zadanie12Model zadanie12Model;
    private Zadanie13 zadanie13;
    private Zadanie13Model zadanie13Model;
    private Zadanie14 zadanie14;
    private Zadanie14Model zadanie14Model;

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
        add(scrollPane,BorderLayout.SOUTH);

    }

    public void addZadanie14() {
        this.zadanie14 = new Zadanie14();
        this.zadanie14Model = new Zadanie14Model();
        add(zadanie14,BorderLayout.CENTER);
        textAreaZadanie.setText("blabla blabla");
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

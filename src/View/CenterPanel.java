package View;

import Model.Zadanie12Model;
import Model.Zadanie13Model;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CenterPanel extends JPanel {

    private Zadanie12 zadanie12;
    private Zadanie12Model zadanie12Model;
    private Zadanie13 zadanie13;
    private Zadanie13Model zadanie13Model;
    private JTextArea textArea;

    public CenterPanel() {
        super();
        Border outer = new TitledBorder("Center");
        setBorder(outer);
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        textArea.setLineWrap(true);

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



    public void addZadanie13() {
        this.zadanie13 = new Zadanie13();
        this.zadanie13Model = new Zadanie13Model();
        add(zadanie13,BorderLayout.CENTER);
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
    }
    public Zadanie12 getZadanie12() {
        return this.zadanie12;
    }
    public Zadanie12Model getZadanie12Model() {
        return this.zadanie12Model;
    }
}

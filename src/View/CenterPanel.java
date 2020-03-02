package View;

import Model.Zadanie12Model;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CenterPanel extends JPanel {

    private Zadanie12 zadanie12;
    private Zadanie12Model zadanie12Model;
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

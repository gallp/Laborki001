package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zadanie22 extends JPanel {

    private JTextField textField01;
    private JTextField textField02;
    private JTextField textField03;
    private JLabel label00;
    private JLabel label01;
    private JLabel label02;
    private JLabel label03;
    private JButton btn01;
    private Zadanie22ButtonListener listener;

    public Zadanie22() {

        setLayout(new GridBagLayout());
        layoutComponents();

        btn01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                if(listener!=null) {
                    listener.btn01Clicked();
                }
            }
        });
    }

    public void setZadanie22ButtonListener(Zadanie22ButtonListener listener){
        this.listener = listener;
    }

    public String getTextField01() {
        return textField01.getText();
    }

    public String getTextField02() {
        return textField02.getText();
    }

    public String getTextField03() {
        return textField03.getText();
    }

    private void layoutComponents() {

        setPreferredSize(new Dimension(120, 1));
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.CENTER;

        textField01 = new JTextField(5);
        textField02 = new JTextField(5);
        textField03 = new JTextField(5);
        label00 = new JLabel("y = ");
        label01 = new JLabel(" x^2 ");
        label02 = new JLabel(" x ");
        label03 = new JLabel(" = ");

        btn01 = new JButton("Oblicz");

        add(label00,gc);
        gc.gridx++;
        add(textField01, gc);
        gc.gridx++;
        add(label01, gc);
        gc.gridx++;
        add(textField02, gc);
        gc.gridx++;
        add(label02, gc);
        gc.gridx++;
        add(textField03, gc);
        gc.gridx++;

        gc.gridx++;
        gc.weightx = 5;
        add(btn01, gc);
    }


}

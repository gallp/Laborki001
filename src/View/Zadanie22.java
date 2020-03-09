package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zadanie22 extends JPanel {

    private JTextField textField01;
    private JTextField textField02;
    private JTextField textField03;
    private JTextField textField04;

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

    public String getTextField04() {
        return textField04.getText();
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
        gc.gridheight = 1;

        textField01 = new JTextField(5);
        textField02 = new JTextField(5);
        textField03 = new JTextField(5);
        textField04 = new JTextField(5);

        label00 = new JLabel("y = ");
        label01 = new JLabel(" x^2 ");
        label02 = new JLabel(" x ");
        label03 = new JLabel("x = ");


        btn01 = new JButton("Oblicz");

        gc.gridx+=7;
        add(new JLabel(" "),gc);
        gc.gridy++;
        gc.gridx = 0;
        add(label00, gc);
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
        add(btn01, gc);
        gc.gridx++;
        gc.weightx = 10;
        add(new JLabel(" "), gc);

        gc.weightx = 0.1;
        gc.gridx = 0;
        gc.gridy++;
        add(label03, gc);
        gc.gridx++;
        add(textField04, gc);
        gc.gridx++;


        gc.gridx +=5;
        gc.weightx = 10;
        add(new JLabel(" "), gc);

        gc.gridy++;
        gc.weighty = 5;
        add(new JLabel(" "), gc);

//        add(new JLabel(),gc);
    }


}

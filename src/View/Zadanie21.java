package View;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zadanie21 extends JPanel{

    private JTextField textField01;
    private JTextField textField02;
    private JTextField textField03;
    private JTextField textField04;
    private JComboBox comboBox;
    private JButton btn01;
    private Zadanie21ButtonListener listener;
    private String[] arr = {"Add","Mul","Sub","Div","Equals","CompareTo"};

    public Zadanie21() {
        super();
        setLayout(new GridBagLayout());
        layoutComponents();

        btn01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                if(listener != null)
                listener.btn01Clicked();
            }
        });
    }

    public void setZadanie21ButtonListener(Zadanie21ButtonListener listener) {
        this.listener = listener;
    }

    public JTextField getTextField01() {
        return textField01;
    }

    public JTextField getTextField02() {
        return textField02;
    }

    public JTextField getTextField03() {
        return textField03;
    }

    public JTextField getTextField04() {
        return textField04;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    private void layoutComponents() {

        setPreferredSize(new Dimension(120,1));
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
        textField04 = new JTextField(5);
        comboBox = new JComboBox(arr);
        btn01 = new JButton("Oblicz");



        add(textField01,gc);
        gc.gridx++;
        add(new JLabel("/"),gc);
        gc.gridx++;
        add(textField02,gc);

        gc.gridx++;
        add(comboBox,gc);
        gc.gridx++;
        add(textField03,gc);
        gc.gridx++;
        add(new JLabel("/"),gc);
        gc.gridx++;
        add(textField04,gc);

        gc.gridx++;
        gc.weightx = 5;
        add(btn01,gc);


    }


}

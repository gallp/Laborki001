package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zadanie14 extends JPanel {

    private JTextField textField01;
    private JComboBox comboBox;
    private JButton btn01;
    private String[] arr = {"to BINARY", "to OCTAL", "to HEXADECIMAL"};
    private Zadanie14ButtonListener listener;

    public Zadanie14(){
        super();

        textField01 = new JTextField(10);
        comboBox = new JComboBox(arr);
        btn01 = new JButton("Oblicz");

        add(textField01);
        add(comboBox);
        add(btn01);

        btn01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(listener != null) {
                    listener.btn01Clicked();
                }
            }
        });
    }

    public void setZadanie14ButtonListener (Zadanie14ButtonListener listener) {
        this.listener=listener;
    }

    public String getTextField01() {
        return textField01.getText();
    }

    public int getComboBox() {
        return comboBox.getSelectedIndex();
    }
}

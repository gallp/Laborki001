package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zadanie12 extends JPanel{

    private JTextField textField01;
    private JTextField textField02;
    private JTextField textField03;
    private JComboBox comboBox;
    private JButton btn01;
    private Zadanie12ButtonListener listener;

    public Zadanie12() {

        System.out.println("Zadanie 1.2");
        setPreferredSize(new Dimension(200,100));
        System.out.println("Size Set");
        setVisible(true);
        textField01 = new JTextField(20);
//        textField02 = new JTextField(10);
//        textField03 = new JTextField(20);
        btn01 = new JButton("!");

//        String[] arr = {"dodawanie","odejmowanie","mnożenie","dzielenie"};
//        comboBox = new JComboBox(arr);

        add(textField01);
//        add(comboBox);
//        add(textField02);
        add(btn01);
//        add(textField03);

        btn01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(listener !=null) {
                    listener.btn01Clicked();
                }
            }
        });
    }

    public String getTextField01() {
        return textField01.getText();
    }

    public void setZadanie12ButtonListener(Zadanie12ButtonListener listener) {
        this.listener = listener;
    }
}

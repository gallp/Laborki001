package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zadanie13 extends JPanel {

    private JTextField textField01;
    private JButton btn01;
    private Zadanie13ButtonListener listener;

    public Zadanie13() {
        super();
        textField01 = new JTextField(20);
        btn01 = new JButton("Suma");
        add(textField01);
        add(btn01);

        btn01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(listener!=null) {
                    listener.sumaButtonClicked();
                }
            }
        });



    }

    public void setZadanie13ButtonListener(Zadanie13ButtonListener listener) {
        this.listener = listener;
    }

    public String getTextfield01() {
        return textField01.getText();
    }
}


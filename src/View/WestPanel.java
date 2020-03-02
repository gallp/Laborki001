package View;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WestPanel extends JPanel {

    private JButton btn001;
    private JButton btn002;
    private JButton btn003;
    private JButton btn004;
    private JButton btn005;
    private JButton btn006;
    private WestPanelButtonListener listener;

    public WestPanel() {

        layoutComponents();
        btn001.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(listener != null) {
                    listener.btn01Clicked();
                }
            }
        });

        btn002.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {

                if(listener != null) {
                    listener.btn02Clicked();
                }
            }
        });

        btn003.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {

                if(listener != null) {
                    listener.btn03Clicked();
                }
            }
        });

    }

    public void setWestPaneButtonListener (WestPanelButtonListener listener) {
        this.listener = listener;
    }
    private void layoutComponents() {
        Border outer = new TitledBorder("Zadania");
        setBorder(outer);
        setPreferredSize(new Dimension(120,1));
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.CENTER;

        btn001 = new JButton("Zadanie 1.1");
        btn002 = new JButton("Zadanie 1.2");
        btn003 = new JButton("Zadanie 1.3");
        btn004 = new JButton("Zadanie 1.4");
        btn005 = new JButton("Zadanie 1.5");
        btn006 = new JButton("Zadanie 1.6");


        add(btn001,gc);
        gc.gridy++;
        add(btn002,gc);
        gc.gridy++;
        add(btn003,gc);
        gc.gridy++;
        add(btn004,gc);
        gc.gridy++;
        gc.weighty = 9;
        add(btn005,gc);

    }

}

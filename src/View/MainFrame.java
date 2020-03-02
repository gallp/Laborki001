package View;

import Model.Zadanie12Model;

import javax.swing.*;
import java.awt.*;



public class MainFrame extends JFrame {

    private WestPanel westPanel;
    private CenterPanel centerPanel;
    private Zadanie12 zadanie12;
    private Zadanie12Model zadanie12Model;


    public MainFrame() {
        super("Laborki 0001");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(800,600);
        setSize(frameSize);
        setLocation(dim.width/2-frameSize.width/2, dim.height/2-frameSize.height/2);
        setLayout(new BorderLayout());

        westPanel = new WestPanel();
        centerPanel = new CenterPanel();

        add(westPanel,BorderLayout.WEST);
        add(centerPanel,BorderLayout.CENTER);


        westPanel.setWestPaneButtonListener(new WestPanelButtonListener() {
            @Override
            public void btn01Clicked() {
                centerPanel.refresh();
                Zadanie11 zadanie11 = new Zadanie11();
            }

            @Override
            public void btn02Clicked() {
                centerPanel.refresh();
                centerPanel.addZadanie12();
                centerPanel.getZadanie12().setZadanie12ButtonListener(new Zadanie12ButtonListener() {
                    @Override
                    public void btn01Clicked() {
                        System.out.println("Zadanie 12 btn01 clicked");
                        String str = centerPanel.getZadanie12().getTextField01();
                        centerPanel.setTextArea(centerPanel.getZadanie12Model().silnia(str).toString());
                        System.out.println(str);
                        System.out.println("GIT CHECK");
                    }
                });
                System.out.println("btn02 Clicked");
            }

            @Override
            public void btn03Clicked() {
                centerPanel.refresh();
                System.out.println("btn03 Clicked");
            }
        });




        setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}

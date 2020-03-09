package View;

import Model.Rational;

import javax.swing.*;
import java.awt.*;
import java.net.Inet4Address;

public class MainFrame extends JFrame {

    private WestPanel westPanel;
    private CenterPanel centerPanel;

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

                    }
                });
                System.out.println("btn02 Clicked");
            }

            @Override
            public void btn03Clicked() {
                centerPanel.refresh();
                System.out.println("btn03 Clicked");
                centerPanel.addZadanie13();
                centerPanel.getZadanie13().setZadanie13ButtonListener(new Zadanie13ButtonListener() {
                    @Override
                    public void sumaButtonClicked() {

                        String str  = centerPanel.getZadanie13().getTextfield01();

                        try {
                            if(Integer.parseInt(str) >=0) {

                                Integer n = Integer.parseInt(str);
                                Integer wynik = centerPanel.getZadanie13Model().getSum(n);
                                centerPanel.setTextArea(wynik.toString());
                            } else {
                                centerPanel.setTextArea("Invalid Input\nValue must be positive number");
                            }

                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                            centerPanel.setTextArea("Invalid Input\nValue must be positive number");
                        }
                    }
                });
            }

            @Override
            public void btn04Clicked() {
                centerPanel.refresh();
                System.out.println("btn04 Clicked");
                centerPanel.addZadanie14();
                centerPanel.getZadanie14().setZadanie14ButtonListener(new Zadanie14ButtonListener() {
                    @Override
                    public void btn01Clicked() {
                        try {
                            String str00 = centerPanel.getZadanie14().getTextField01();
                            int choice = centerPanel.getZadanie14().getComboBox();
                            int number = Integer.parseInt(str00);
                            if(number >=0) {
                                switch (choice) {
                                    case 0:
                                        String str01 = centerPanel.getZadanie14Model().decToBin(number).toString();
                                        centerPanel.setTextArea(str01);
                                    break;
                                    case 1:
                                        String str02 = centerPanel.getZadanie14Model().decToOct(number).toString();
                                        centerPanel.setTextArea("0" + str02);
                                    break;
                                    case 2:
                                        String str03 = centerPanel.getZadanie14Model().decToHex(number).toString();
                                        centerPanel.setTextArea("0x" + str03);
                                    break;
                                }
                            }
                                else centerPanel.setTextArea("Invalid Input\nValue must be positive number");
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                            centerPanel.setTextArea("Invalid Input\nValue must be positive number");
                        }

                    }
                });
            }
            @Override
            public void btn05Clicked() {
                centerPanel.refresh();
                System.out.println("btn05 Clicked");
                centerPanel.addZadanie21();

                centerPanel.getZadanie21().setZadanie21ButtonListener(new Zadanie21ButtonListener() {
                    @Override
                    public void btn01Clicked() {

                        try {
                            int r1Licznik = Integer.parseInt(centerPanel.getZadanie21().getTextField01().getText());
                            int r1Mianownik = Integer.parseInt(centerPanel.getZadanie21().getTextField02().getText());
                            int r2Licznik = Integer.parseInt(centerPanel.getZadanie21().getTextField03().getText());
                            int r2Mianownik = Integer.parseInt(centerPanel.getZadanie21().getTextField04().getText());
                            int choice = centerPanel.getZadanie21().getComboBox().getSelectedIndex();
                            centerPanel.getRational01().setLicznik(r1Licznik);
                            centerPanel.getRational01().setMianownik(r1Mianownik);
                            centerPanel.getRational02().setLicznik(r2Licznik);
                            centerPanel.getRational02().setMianownik(r2Mianownik);
                            Rational wynik = new Rational(1,1);
                            switch(choice) {
                                case 0:
                                    wynik = centerPanel.getRational01().add(centerPanel.getRational02());
                                    centerPanel.setTextArea(wynik.toString());
                                break;
                                case 1:
                                    wynik = centerPanel.getRational01().mul(centerPanel.getRational02());
                                    centerPanel.setTextArea(wynik.toString());
                                break;
                                case 2:
                                    wynik = centerPanel.getRational01().sub(centerPanel.getRational02());
                                    centerPanel.setTextArea(wynik.toString());
                                break;
                                case 3:
                                    wynik = centerPanel.getRational01().div(centerPanel.getRational02());
                                    centerPanel.setTextArea(wynik.toString());
                                break;
                                case 4:
                                    Boolean wynikB = centerPanel.getRational01().equals(centerPanel.getRational02());
                                    centerPanel.setTextArea(wynikB.toString());
                                break;
                                case 5:
                                    Integer wynikC = centerPanel.getRational01().compareTo(centerPanel.getRational02());
                                    centerPanel.setTextArea(wynikC.toString());
                                break;
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                            System.out.println("Invalid Input");
                            centerPanel.setTextArea("Invalid Input");
                        }





                    }
                });

            }




        });




        setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}

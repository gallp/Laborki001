package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Zadanie41 extends JPanel {

    private JInternalFrame internalFrame;
    private MenuBar menuBar;
    private JTextArea textArea;

    public Zadanie41() {
        super();
        layoutComponents();

        menuBar.setMenuBarListener(new MenuBar.MenuBarListener() {
            @Override
            public void item001Selected() {
                System.out.println("item001 Selected");
                JFileChooser fc = new JFileChooser();

                if(fc.showOpenDialog(null) == fc.APPROVE_OPTION) {
                    String str = "";
                    File f = fc.getSelectedFile();

                    try {
                        InputStream iStream = new FileInputStream(f);
                        InputStreamReader iStreamReader = new InputStreamReader(iStream, menuBar.setCodePage());

                        int data = iStreamReader.read();
                        while (data != -1) {
                            str = str + (char) data;
                            data = iStreamReader.read();
                        }
                        iStreamReader.close();
                    }
                    catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    catch(IOException e) {
                        e.printStackTrace();
                    }
                    textArea.setText(str);
                }
            }
            @Override
            public void item002Selected() {
                System.out.println("item002 Selected");
                JFileChooser fc = new JFileChooser();

                if(fc.showSaveDialog(null) == fc.APPROVE_OPTION) {
                    try {
                        String str = textArea.getText();
                        File f = fc.getSelectedFile();

                        OutputStream oStream = new FileOutputStream(f.getAbsolutePath());
                        OutputStreamWriter oStreamWriter = new OutputStreamWriter(oStream, menuBar.setCodePage());
                        oStreamWriter.write(str);
                        oStreamWriter.close();
                    }
                    catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void item003Selected() {
                System.out.println("item003 Selected");
            }
            @Override
            public void radioButton001Selected() {
                System.out.println("UTF-8 Selected");
                menuBar.setCodePage();
            }
            @Override
            public void radioButton002Selected() {
                System.out.println("ISO-8859-2 Selected");
                menuBar.setCodePage();
            }
            @Override
            public void radioButton003Selected() {
                System.out.println("Windows-1250 Selected");
                menuBar.setCodePage();
            }
        });

        internalFrame.setDefaultCloseOperation(internalFrame.EXIT_ON_CLOSE);
    }

    private static class MenuBar extends JMenuBar {

        private JMenu menu001;
        private JMenu menu002;
        private JMenuItem item001;
        private JMenuItem item002;
        private JMenuItem item003;
        private JRadioButton radioButton01;
        private JRadioButton radioButton02;
        private JRadioButton radioButton03;
        private MenuBarListener listener;
        private ButtonGroup bg;

        private MenuBar() {
            super();
            menu001 = new JMenu("File");
            menu002 = new JMenu("Code");

            item001 = new JMenuItem("Open");
            item002 = new JMenuItem("Save");
            item003 = new JMenuItem("Exit");

            radioButton01 = new JRadioButton("UTF-8");
            radioButton02 = new JRadioButton("ISO-8859-2");
            radioButton03 = new JRadioButton("Windows-1250");

            bg = new ButtonGroup();

            bg.add(radioButton01);
            bg.add(radioButton02);
            bg.add(radioButton03);

            menu001.add(item001);
            menu001.add(item002);
            menu001.add(item003);

            menu002.add(radioButton01);
            menu002.add(radioButton02);
            menu002.add(radioButton03);

            add(menu001);
            add(menu002);

            System.out.println("MenuBar Constr.");

            bg.setSelected(radioButton01.getModel(),true);

            item001.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a) {
                    if(listener != null) {
                        listener.item001Selected();
                    }
                }
            });
            item002.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a) {
                    if(listener != null) {
                        listener.item002Selected();
                    }
                }
            });
            item003.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a) {
                    if(listener != null) {
                        listener.item003Selected();
                    }
                }
            });
            radioButton01.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a) {
                    if(listener != null) {
                        listener.radioButton001Selected();
                    }
                }
            });
            radioButton02.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a) {
                    if(listener != null) {
                        listener.radioButton002Selected();
                    }
                }
            });
            radioButton03.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a) {
                    if(listener != null) {
                        listener.radioButton003Selected();
                    }
                }
            });
        }

        public void setMenuBarListener(MenuBarListener listener) {
            this.listener = listener;
        }

        private interface MenuBarListener {
            void item001Selected();
            void item002Selected();
            void item003Selected();
            void radioButton001Selected();
            void radioButton002Selected();
            void radioButton003Selected();
        }

        private String setCodePage() {
            String str = "";

            if(bg.getSelection() == radioButton01.getModel()) {
                str = "UTF-8";
                System.out.println("UTF-8");
            }
            if(bg.getSelection() == radioButton02.getModel()) {
                str = "ISO-8859-2";
                System.out.println("ISO-8859-2");
            }
            if(bg.getSelection() == radioButton03.getModel()) {
                str = "windows-1250";
                System.out.println("windows-1250");
            }
            return str;
        }

    }

    private void layoutComponents() {
        setLayout(new BorderLayout());

            internalFrame = new JInternalFrame("Notepad");
            menuBar = new MenuBar();
            internalFrame.setJMenuBar(menuBar);
            internalFrame.setLayout(new BorderLayout());
            textArea = new JTextArea();
            textArea.setLineWrap(true);
            internalFrame.add(textArea, BorderLayout.CENTER);
            internalFrame.setVisible(true);
            add(internalFrame, BorderLayout.CENTER);
        }
}

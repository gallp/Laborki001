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
                        InputStreamReader iStreamReader = new InputStreamReader(iStream, "UTF-8");

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
                        System.out.println(str);

                        File f = fc.getSelectedFile();
                        System.out.println(f);

                        OutputStream oStream = new FileOutputStream(f.getAbsolutePath());
                        OutputStreamWriter oStreamWriter = new OutputStreamWriter(oStream,"UTF-8");
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
        });

        internalFrame.setDefaultCloseOperation(internalFrame.EXIT_ON_CLOSE);
    }



    private static class MenuBar extends JMenuBar {

        private JMenu menu001;
        private JMenuItem item001;
        private JMenuItem item002;
        private JMenuItem item003;
        private MenuBarListener listener;

        private MenuBar() {
            super();

            menu001 = new JMenu("File");
            item001 = new JMenuItem("Open");
            item002 = new JMenuItem("Save");
            item003 = new JMenuItem("Exit");

            menu001.add(item001);
            menu001.add(item002);
            menu001.add(item003);
            add(menu001);
            System.out.println("MenuBar Constr.");

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
                public void actionPerformed(ActionEvent actionEvent) {
                    if(listener != null) {
                        listener.item002Selected();
                    }
                }
            });
            item003.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if(listener != null) {
                        listener.item003Selected();
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

package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Zadanie42 extends JPanel {

    private JButton btn01;
    private JButton btn02;

    private Zadanie42ButtonListener listener;

    public Zadanie42() {
        super();
        btn01 = new JButton("gZip");
        btn02 = new JButton("ungZip");
        add(btn01);
        add(btn02);

        btn01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(listener != null) {
                    listener.btn01Clicked();
                }
            }
        });

        btn02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(listener != null) {
                    listener.btn02Clicked();
                }
            }
        });

        setZadanie42ButtonListener(new Zadanie42ButtonListener() {
            @Override
            public void btn01Clicked() {
                System.out.println("bt01 Clicked");
                JFileChooser fc = new JFileChooser();

                if (fc.showOpenDialog(null) == fc.APPROVE_OPTION) {

                    try {
                        InputStream istream = new FileInputStream(fc.getSelectedFile().getAbsoluteFile());
                        System.out.println(istream.toString());

                        if(fc.showSaveDialog(null) == fc.APPROVE_OPTION) {

                            byte[] data = new byte[20480000];
                            int len, count = 0;

                            OutputStream ostream = new FileOutputStream(fc.getSelectedFile().getAbsoluteFile());
                            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(ostream);

                            while((len = istream.read(data)) != -1){
                                gzipOutputStream.write(data,0, len);
                                count += len;
                                System.out.println("packed " + count);

                            }

                            istream.close();
                            gzipOutputStream.finish();
                            gzipOutputStream.close();

                        }

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
            @Override
            public void btn02Clicked() {
                System.out.println("btn02 Clicked");
                JFileChooser fc = new JFileChooser();

                if(fc.showOpenDialog(null) == fc.APPROVE_OPTION) {

                    try {
                        InputStream istream = new FileInputStream(fc.getSelectedFile().getAbsoluteFile());
                        GZIPInputStream gzipInputStream = new GZIPInputStream(istream);

                        if(fc.showSaveDialog(null) == fc.APPROVE_OPTION) {

                            byte[] data = new byte[1024];

                            int len;
                            int count = 0;
                            OutputStream ostream = new FileOutputStream(fc.getSelectedFile().getAbsoluteFile());
                            while((len = gzipInputStream.read(data)) != -1 ) {

                                ostream.write(data,0, len);
                            }

                            gzipInputStream.close();
                            ostream.close();
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

    }

    private void setZadanie42ButtonListener(Zadanie42ButtonListener listener) {
        this.listener = listener;
    }

    private interface Zadanie42ButtonListener {
        void btn01Clicked();
        void btn02Clicked();
    }


}

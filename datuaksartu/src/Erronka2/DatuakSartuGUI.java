package Erronka2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class DatuakSartuGUI {

    private static JLabel aukera = new JLabel("Klikatu zure aukeran", SwingConstants.CENTER);
    private static JFrame frame = new JFrame("Hasiera");
    private static JButton piraguistak = new JButton("Piraguista taula");
    private static JButton indibidualak = new JButton("Lehiaketa indibidualak taula");
    private static JButton taldeak = new JButton("Talde lehiaketa taula");

    public static void elementuakJarri() {
        frame.getContentPane().add(aukera);
        frame.getContentPane().add(piraguistak);
        frame.getContentPane().add(indibidualak);
        frame.getContentPane().add(taldeak);

        frame.setLayout(new FlowLayout());
        frame.setLayout(new GridLayout(4, 1));

        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 500);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        piraguistak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatuakSartuPiraguistaGUI.pantailaErakutsi();
            }
        });

        indibidualak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatuakSartuIndibidualGUI.pantailaErakutsi();
            }
        });

        taldeak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatuakSartuTaldeaGUI.pantailaErakutsi();
            }
        });
    }
}

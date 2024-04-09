package Erronka2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatuakSartuTaldeaGUI {

    private static JFrame frame4 = new JFrame("Talde lehiaketa berrien emaitzak sartzeko aukera");
    private static JPanel datuak = new JPanel();
    private static JTextField talde_txapelketa_id = new JTextField();
    private static JTextField taldekod = new JTextField();
    private static JTextField taldetxapdenbora = new JTextField();
    private static JTextArea erregistroa = new JTextArea();
    private static JButton datuaksartu = new JButton("Datuak sartu");
    private static JButton fitxategiasortu = new JButton("Fitxategia sortu");

    public static void pantailaErakutsi() {
    	datuak.setLayout(new GridLayout(5, 2, 10, 10));
        datuak.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Añadir componentes al panel
        datuak.add(new JLabel("Talde Txapelketa ID:"));
        datuak.add(talde_txapelketa_id);
        datuak.add(new JLabel("Taldekodea:"));
        datuak.add(taldekod);
        datuak.add(new JLabel("Talde txapen denbora:"));
        datuak.add(taldetxapdenbora);
        datuak.add(new JLabel("Erregistroa:"));
        datuak.add(erregistroa);
        datuak.add(datuaksartu);
        datuak.add(fitxategiasortu);

        // Configurar el botón "Datuak sartu"
        datuaksartu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para manejar el evento de clic en el botón "Datuak sartu"
                // Puedes acceder a los campos de texto y realizar las operaciones necesarias aquí
            }
        });

        // Configurar el botón "Fitxategia sortu"
        fitxategiasortu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para manejar el evento de clic en el botón "Fitxategia sortu"
                // Puedes acceder a los campos de texto y realizar las operaciones necesarias aquí
            }
        });

        // Configurar el frame
        frame4.getContentPane().setLayout(new BorderLayout());
        frame4.getContentPane().add(datuak, BorderLayout.CENTER);
        frame4.setSize(600, 400);
        frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame4.setVisible(true);
    }
    }


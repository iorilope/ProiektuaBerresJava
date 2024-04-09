package Erronka2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatuakSartuIndibidualGUI {

    private static JFrame frame3 = new JFrame("Lehiaketa indibidual berrien emaitzak sartzeko aukera");
    private static JPanel datuak = new JPanel();
    private static JTextField piraguista_nan = new JTextField();
    private static JTextField txapelketa_id = new JTextField();
    private static JTextField denbora = new JTextField();
    private static JTextArea erregistroa = new JTextArea();
    private static JButton datuaksartu = new JButton("Datuak sartu");
    private static JButton fitxategiasortu = new JButton("Fitxategia sortu");

    public static void pantailaErakutsi() {
    	// Configurar el panel principal
        datuak.setLayout(new GridLayout(5, 2, 10, 10));
        datuak.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Añadir componentes al panel
        datuak.add(new JLabel("Piraguista NAN:"));
        datuak.add(piraguista_nan);
        datuak.add(new JLabel("Txapelketa ID:"));
        datuak.add(txapelketa_id);
        datuak.add(new JLabel("Denbora:"));
        datuak.add(denbora);
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
        frame3.getContentPane().setLayout(new BorderLayout());
        frame3.getContentPane().add(datuak, BorderLayout.CENTER);
        frame3.setSize(600, 400);
        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame3.setVisible(true);
    }
    }


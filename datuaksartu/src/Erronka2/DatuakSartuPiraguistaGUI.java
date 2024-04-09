package Erronka2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatuakSartuPiraguistaGUI {

    private static JFrame frame2 = new JFrame("Piraguista berriak taulan sartzeko aukera");
    private static JPanel datuak = new JPanel();
    private static JTextField nan = new JTextField();
    private static JTextField izena = new JTextField();
    private static JTextField abizena = new JTextField();
    private static JComboBox<String> generoaBox = new JComboBox<>();
    private static JTextField telefonoa = new JTextField();
    private static JTextField herria = new JTextField();
    private static JTextField talde_kodea = new JTextField();
    private static JTextField txapelketak = new JTextField();
    private static JTextArea erregistroa = new JTextArea();
    private static JButton datuaksartu = new JButton("Datuak sartu");
    private static JButton fitxategiasortu = new JButton("Fitxategia sortu");

    public static void pantailaErakutsi() {
    	datuak.setLayout(new GridLayout(10, 2, 10, 10));
        datuak.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Añadir componentes al panel
        datuak.add(new JLabel("NAN:"));
        datuak.add(nan);
        datuak.add(new JLabel("Izena:"));
        datuak.add(izena);
        datuak.add(new JLabel("Abizena:"));
        datuak.add(abizena);
        datuak.add(new JLabel("Generoa:"));
        generoaBox.addItem("Gizonezkoa");
        generoaBox.addItem("Emakumezkoa");
        datuak.add(generoaBox);
        datuak.add(new JLabel("Telefonoa:"));
        datuak.add(telefonoa);
        datuak.add(new JLabel("Herria:"));
        datuak.add(herria);
        datuak.add(new JLabel("Talde kodea:"));
        datuak.add(talde_kodea);
        datuak.add(new JLabel("Txapelketak:"));
        datuak.add(txapelketak);
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
        frame2.getContentPane().setLayout(new BorderLayout());
        frame2.getContentPane().add(datuak, BorderLayout.CENTER);
        frame2.setSize(600, 400);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setVisible(true);
    }
    }


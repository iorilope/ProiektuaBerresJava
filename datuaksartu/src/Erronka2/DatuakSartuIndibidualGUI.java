package Erronka2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

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
    	//Panel nagusia konfiguratu
        datuak.setLayout(new GridLayout(5, 2, 10, 10));
        datuak.setBorder(new EmptyBorder(10, 10, 10, 10));

        //Konponenteak gehitu panelean
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

        // Datuak sartu botoia konfiguratu
        datuaksartu.addActionListener(new ActionListener() {
			String textuerregistroa="";
			@Override
			public void actionPerformed(ActionEvent e) {

				textuerregistroa += piraguista_nan.getText()+"\t";
				piraguista_nan.setText(null);
				//Nan kutxan gorde den datua hartu eta textu kutxa garbitu

				textuerregistroa += txapelketa_id.getText()+"\t";
				txapelketa_id.setText(null);
				//Txapelketa_ID kutxan gorde den datua hartu eta textu kutxa garbitu

				textuerregistroa += denbora.getText()+"\n";
				denbora.setText(null);
				//Denbora kutxan gorde den datua hartu eta textu kutxa garbitu

				erregistroa.setText(textuerregistroa);
				//Erregistroa textu area eguneratu gorde ditugun datuekin

			}
		});

        // Configurar el botón "Fitxategia sortu"
        fitxategiasortu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String fitxategihelbidea=	JOptionPane.showInputDialog("Sartu fitxategiaren helbide absolutua(Hemen gordeko da zure fitxategia)");
				//Fitxategia non gordeko den galdetu eta helbide hori gorde

				while (fitxategihelbidea == null || fitxategihelbidea.isEmpty()) {

					fitxategihelbidea =JOptionPane.showInputDialog("Fitxategiari helbide absolutua jarri behar zaio!");

				}
				//Kutxa bete gabe geratzen bada, berriro galdeuko du, helbide bat idatzi arte

				File file = new File(fitxategihelbidea);
				//Fitxategiraren helbidea gordetzen da

				while (!file.exists()) {

					fitxategihelbidea=JOptionPane.showInputDialog("Fitxategiaren helbidea ez da existitzen. Mesedez, sartu existitzen den helbide bat.");
					file = new File(fitxategihelbidea);
				}
				//Helbide existitzen den egiaztaten da, hau ez bada existitzen begizta jarraitzen du

				String 	fitxategizena	= 	JOptionPane.showInputDialog("Sartu fitxategiaren izena");
				//Fitxategiaren izena galdetzen da

				while (fitxategizena == null || fitxategizena.isEmpty() || fitxategizena == ".txt") {

					fitxategizena =JOptionPane.showInputDialog("Fitxategiak izena eduki behar du!");
					//Fitxategizena aldagaian ez bada ezer gorde mezu bat inprimatuko da eta beriz galdetuko du
				}

				File izena = new File(fitxategihelbidea,fitxategizena+".txt");
				//Fitxategiaren izena eta helbidea gordetzen da

				while (izena.exists()) {

					fitxategizena =JOptionPane.showInputDialog("Fitxategiaren izena iada existitzen da, jarri beste bat.");
					izena = new File(fitxategihelbidea,fitxategizena+".txt");
				}
				//Fitxategi izen hori helbide horretan existitzen den bitartean, begizta jarraituko du

				String ruta = fitxategihelbidea+ File.separator + fitxategizena +".txt";
				//Fitxategiaren helbide absolutua eta honen izena aldagai berdinean gordetzen da "\"-kin elkartuz

				try {	  
					BufferedWriter fitxategia = new BufferedWriter(new FileWriter(ruta));
					fitxategia.write(erregistroa.getText());
					//Helbide egokia hartu eta bertan fitxategia sortu

					fitxategia.close();
					//Writter-a itxi

					JOptionPane.showMessageDialog(null, "Fitxategia sortu da!!");
					//Fitxategia ondo sortu den mezua inprimatu eta begizta amaitu

				} catch (Exception ex) {
					ex.printStackTrace();
				}
				//Errore mezua inprimatu
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


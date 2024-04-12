
package Erronka2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * DatuakSartuIndibidualGUI Klasea
 */
public class DatuakSartuIndibidualGUI {

	/** Indibidualen Frame-a */
	private static JFrame frame3 = new JFrame("Lehiaketa indibidual berrien emaitzak sartzeko aukera");

	/** Datuen panela */
	private static JPanel datuak = new JPanel();

	/** Piraguistaren NaN Textfield. */
	private static JTextField piraguista_nan = new JTextField();

	/** Txapelketaren Id-a Textfield */
	private static JTextField txapelketa_id = new JTextField();

	/** Piraguistak egindako denbora Textfield. */
	private static JTextField denbora = new JTextField();

	/** Erregistroaren TextArea */
	private static JTextArea erregistroa = new JTextArea();

	/** Datuak erregistroan sartzeko botoia. */
	private static JButton datuaksartu = new JButton("Datuak sartu");

	/** Erregistroko Datuekin fitxategia sortzeko botoia. */
	private static JButton fitxategiasortu = new JButton("Fitxategia sortu");

	/**
	 * Pantaila erakutsi.
	 */
	public static void pantailaErakutsi() {
		// Panel nagusia konfiguratu
		datuak.setLayout(new GridLayout(5, 2, 10, 10));
		datuak.setBorder(new EmptyBorder(10, 10, 10, 10));

		// Konponenteak gehitu panelean
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

		/**
		 * "Datuaksartu" botoirako ActionListener, erabiltzaileak botoian klik egiten
		 * duenean aktibatzen dena. ActionListener honek parte-hartzaile batekin
		 * lotutako testu-eremuetan sartutako datuak atzitzen ditu banaka torneoan
		 * (piraguistaren NAN, txapelketaren ID, parte-hartzailearen denbora),
		 * "Indibiduala" klasea, datu horiekin, eta "erregistroa" testu-eremura gehitzen
		 * ditu, lerro-formatuan eta tabulazioak eta ondoren lerro-jauzi bat.
		 */
		datuaksartu.addActionListener(new ActionListener() {
			String textuerregistroa = "";

			@Override
			public void actionPerformed(ActionEvent e) {

				String nan = piraguista_nan.getText();
				String txapelketaId = txapelketa_id.getText();
				String denboraa = denbora.getText();

				Indibiduala indibiduala = new Indibiduala(nan, txapelketaId, denboraa);

				String DatuIndibidualak = indibiduala.getPiraguistaNan() + "\t" + indibiduala.getTxapelketaId() + "\t"
						+ indibiduala.getDenbora() + "\n";

				erregistroa.append(DatuIndibidualak);
			}
		});
		/**
		 * "Fitxategiasortu" botoirako ActionListener, erabiltzaileak botoian klik
		 * egiten duenean aktibatzen dena. ActionListener honek erabiltzaileari eskatzen
		 * dio sar dezala fitxategia eta artxiboaren izena gorde nahi dituen ibilbide
		 * osoa. Gero, testu-fitxategi bat sortzen du zehaztutako kokalekuan, eta
		 * "erregistroa" testu-arloaren edukia idazten du fitxategi sortu berrian.
		 * Azkenik, berrespen-mezu bat erakusten dio erabiltzaileari, fitxategia
		 * arrakastaz sortu dela adierazteko. Prozesuan erroreren bat gertatzen bada,
		 * salbuespen-pila inprimatu kontsolan.
		 */
		fitxategiasortu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String fitxategihelbidea = JOptionPane
						.showInputDialog("Sartu fitxategiaren helbide absolutua(Hemen gordeko da zure fitxategia)");
				// Fitxategia non gordeko den galdetu eta helbide hori gorde

				while (fitxategihelbidea == null || fitxategihelbidea.isEmpty()) {

					fitxategihelbidea = JOptionPane.showInputDialog("Fitxategiari helbide absolutua jarri behar zaio!");

				}
				// Kutxa bete gabe geratzen bada, berriro galdeuko du, helbide bat idatzi arte

				File file = new File(fitxategihelbidea);
				// Fitxategiraren helbidea gordetzen da

				while (!file.exists()) {

					fitxategihelbidea = JOptionPane.showInputDialog(
							"Fitxategiaren helbidea ez da existitzen. Mesedez, sartu existitzen den helbide bat.");
					file = new File(fitxategihelbidea);
				}
				// Helbide existitzen den egiaztaten da, hau ez bada existitzen begizta
				// jarraitzen du

				String fitxategizena = JOptionPane.showInputDialog("Sartu fitxategiaren izena");
				// Fitxategiaren izena galdetzen da

				while (fitxategizena == null || fitxategizena.isEmpty() || fitxategizena == ".txt") {

					fitxategizena = JOptionPane.showInputDialog("Fitxategiak izena eduki behar du!");
					// Fitxategizena aldagaian ez bada ezer gorde mezu bat inprimatuko da eta beriz
					// galdetuko du
				}

				File izena = new File(fitxategihelbidea, fitxategizena + ".txt");
				// Fitxategiaren izena eta helbidea gordetzen da

				while (izena.exists()) {

					fitxategizena = JOptionPane
							.showInputDialog("Fitxategiaren izena iada existitzen da, jarri beste bat.");
					izena = new File(fitxategihelbidea, fitxategizena + ".txt");
				}
				// Fitxategi izen hori helbide horretan existitzen den bitartean, begizta
				// jarraituko du

				String ruta = fitxategihelbidea + File.separator + fitxategizena + ".txt";
				// Fitxategiaren helbide absolutua eta honen izena aldagai berdinean gordetzen
				// da "\"-kin elkartuz

				try {
					BufferedWriter fitxategia = new BufferedWriter(new FileWriter(ruta));
					fitxategia.write(erregistroa.getText());
					// Helbide egokia hartu eta bertan fitxategia sortu

					fitxategia.close();
					// Writter-a itxi

					JOptionPane.showMessageDialog(null, "Fitxategia sortu da!!");
					// Fitxategia ondo sortu den mezua inprimatu eta begizta amaitu

				} catch (Exception ex) {
					ex.printStackTrace();
				}
				// Errore mezua inprimatu
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

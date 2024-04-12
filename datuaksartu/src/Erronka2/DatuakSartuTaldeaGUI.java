
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
 * Txapelketa batean ekipoekin lotutako datuak sartzeko interfaze grafiko bat
 * ematen duen klasea. Klase honek "talde_txapelketa_id", "taldekod",
 * "taldetxapdenbora" eta "erregistroa" bezalako osagaiak barne hartzen ditu.
 * "datuaksartu" eta "fitxategiasortu" botoiekin batera, datuak sartzeko eta
 * fitxategiak sortzeko, hurrenez hurren. "PantailaErakutsi ()" metodoak
 * interfaze grafikoa erakusten du eta botoietarako ActionListenerrak
 * konfiguratzen ditu "datuaksartu" eta "fitxategiasortu", datuak sartzeko eta
 * sartutako datuekin fitxategiak sortzeko, hurrenez hurren. Gainera, osagaiak
 * dituen JFrame-aren antolaera eta tamaina konfiguratzen ditu.
 */

public class DatuakSartuTaldeaGUI {

	/** Taldearen Frame-a */
	private static JFrame frame4 = new JFrame("Talde lehiaketa berrien emaitzak sartzeko aukera");

	/** Taldearen Datuen Panela. */
	private static JPanel datuak = new JPanel();

	/** Taldeak jokatutako Txapelketaren ID-a. TextField */
	private static JTextField talde_txapelketa_id = new JTextField();

	/** Taldearen Kodea TextField */
	private static JTextField taldekod = new JTextField();

	/** Txapelketan egindako denbora. TextField */
	private static JTextField taldetxapdenbora = new JTextField();

	/** Sartutako datuak bistaratzeko TextArea */
	private static JTextArea erregistroa = new JTextArea();

	/** Datuak erregistroa TextArean sartzeko botoia. */
	private static JButton datuaksartu = new JButton("Datuak sartu");

	/** Fitxategia sortzeko Botoia */
	private static JButton fitxategiasortu = new JButton("Fitxategia sortu");

	/**
	 * Interfaze grafiko bat erakusten du, ekipo-txapelketa batekin lotutako datuak
	 * bistaratzeko eta sartzeko. Interfazeak torneoaren IDa, ekipoaren kodea eta
	 * ekipoaren denbora sartzeko eta erakusteko eremuak barne hartzen ditu
	 * txapelketan eta erregistroan, baita datuak sartzeko eta fitxategiak sortzeko
	 * botoiak ere.
	 */

	public static void pantailaErakutsi() {

		datuak.setLayout(new GridLayout(5, 2, 10, 10));
		datuak.setBorder(new EmptyBorder(10, 10, 10, 10));

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

		/**
		 * ActionListener "datuaksartu" botoirako. Erabiltzaileak botoian klik egiten
		 * duenean aktibatzen da. ActionListener honek ekipo-txapelketarekin lotutako
		 * testu-eremuetan sartutako datuak hartzen ditu (Txapelketaren ID, taldearen
		 * kodea, taldearen denbora txapelketan), horiekin "Taldea" motako objektu bat
		 * sortzen du. datuak eta "erregistroa" testu-eremura gehitzen ditu, tabulazioz
		 * bereizitako lerro-formatuan, eta ondoren lerro-jauzi bat egiten du.
		 */

		datuaksartu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String txapelketaId = talde_txapelketa_id.getText();
				String taldeKod = taldekod.getText();
				String taldetxapDenbora = taldetxapdenbora.getText();

				Taldea taldea = new Taldea(txapelketaId, taldeKod, taldetxapDenbora);

				String datuTaldea = taldea.getTxapelketaId() + "\t" + taldea.getTaldeKod() + "\t"
						+ taldea.getTaldetxapDenbora() + "\n";
				erregistroa.append(datuTaldea);
			}
		});

		/**
		 * "Fitxategiasortu" botoirako ActionListener, erabiltzaileak botoian klik
		 * egiten duenean aktibatzen da. ActionListener honek erabiltzaileari eskatzen
		 * dio sar dezala fitxategia eta artxiboaren izena gorde nahi dituen ibilbide
		 * osoan. Ibilbidea eta fitxategiaren izena eman ondoren, testu-fitxategi bat
		 * sortzen du zehaztutako kokalekuan. eta idatzi "erregistroa" testu-arloaren
		 * edukia sortu berri den artxiboan. Gero, mezu bat erakusten du erabiltzaileari
		 * berresteko, fitxategia arrakastaz sortu dela adieraziz. Errorerik izanez
		 * gero, inprimatu kontsolako salbuespenak.
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

		// Frame-a konfiguratu
		frame4.getContentPane().setLayout(new BorderLayout());
		frame4.getContentPane().add(datuak, BorderLayout.CENTER);
		frame4.setSize(600, 400);
		frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame4.setVisible(true);
	}
}

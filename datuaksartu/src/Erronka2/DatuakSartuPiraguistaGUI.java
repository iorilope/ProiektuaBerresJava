
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
 * Piraguista baten datuak sartzeko interfaze grafikoa irudikatzen duen klasea.
 * Piraguistaren datuak sartzeko behar diren osagaiak konfiguratzen eta
 * erakusten ditu. baita datuak erregistro batera gehitzeko eta sartutako
 * datuekin fitxategi bat sortzeko botoiak ere. Klaseak Javaren Swing
 * liburutegiko osagaiak erabiltzen ditu interfaze grafikorako. Sartutako datuak
 * "Erregistroa" izeneko JTextArea batean erakusten dira. Gainera, klase honek
 * ActionListener barneko bi klase barne hartzen ditu logika "Datuak sartu" eta
 * "Fitxategia sortu" botoiak, hurrenez hurren.
 */

public class DatuakSartuPiraguistaGUI {

	/** Piraguisten Frame-a. */
	private static JFrame frame2 = new JFrame("Piraguista berriak taulan sartzeko aukera");

	/** Datu panela */
	private static JPanel datuak = new JPanel();

	/** Piraguistaren Nan Textfield */
	private static JTextField nan = new JTextField();

	/** Piraguistaren Izena Textfield */
	private static JTextField izena = new JTextField();

	/** Piraguistaren Abizena Textfield */
	private static JTextField abizena = new JTextField();

	/** Piraguistaren generoa ComboBox */
	private static JComboBox<String> generoaBox = new JComboBox<>();

	/** Piraguistaren Telefonoa TextField */
	private static JTextField telefonoa = new JTextField();

	/** TPiraguistaren Herria TextField */
	private static JTextField herria = new JTextField();

	/** Piraguistaren Talde Kodea TextField */
	private static JTextField talde_kodea = new JTextField();

	/** Piraguistak jokatutako Txapelketa Kopurua TextField */
	private static JTextField txapelketak = new JTextField();

	/** Datuak erakutsiko diren TextArea */
	private static JTextArea erregistroa = new JTextArea();

	/** Datuak Erregistroan sartzeko botoia */
	private static JButton datuaksartu = new JButton("Datuak sartu");

	/** Fitxategia sortzeko botoia */
	private static JButton fitxategiasortu = new JButton("Fitxategia sortu");

	/**
	 * Piraguista baten datuak sartzeko interfaze grafikoa konfiguratzen eta
	 * erakusten duen metodoa. JFrame frame2 leihoaren diseinua eta osagaiak
	 * konfiguratzen ditu, datuen sarrera-eremuak erakusteko. Etiketak eta
	 * sarrera-eremuak gehitzen ditu datuak sartzeko, hala nola Parte-hartzailearen
	 * Identifikazio Zenbakia (NAN), izena, abizena, generoa, telefonoa, hiria,
	 * talde-kodea eta parte hartzen duen ekitaldiak. JTextArea bat ere erakusten
	 * du, sartutako piraguisten erregistroa erakusteko. Gainera, JTextAreari datuak
	 * gehitzeko eta sartutako datuekin fitxategi bat sortzeko botoiak konfiguratzen
	 * ditu. Botoiak JPanel batean antolatuta daude, JTextArearekin batera. Azkenik,
	 * gehitu osagai guztiak JFrame frame2 leihoko edukiontzi nagusian, eta leihoa
	 * erakutsi.
	 */
	public static void pantailaErakutsi() {
		datuak.setLayout(new GridLayout(10, 2, 10, 10));
		datuak.setBorder(new EmptyBorder(10, 10, 10, 10));

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

		JPanel erregistroPanel = new JPanel();
		erregistroPanel.setLayout(new GridLayout(3, 1));
		erregistroPanel.add(new JLabel("Erregistroa:"));

		Dimension buttonSize = erregistroa.getPreferredSize();
		datuaksartu.setPreferredSize(buttonSize);
		fitxategiasortu.setPreferredSize(buttonSize);

		erregistroPanel.add(datuaksartu);
		erregistroPanel.add(fitxategiasortu);

		datuak.add(erregistroPanel);
		datuak.add(erregistroa);

		frame2.add(datuak);
		frame2.pack();

		/**
		 * ActionListener: "Datuak sartu" botoia sakatzean aktibatzen da. Formularioko
		 * eremuetan sartutako datuak biltzen ditu eta objektu piraguista bat sortzen du
		 * horiekin. Gero, gehitu piraguistaren datuen irudikapen bat JTextArea
		 * erregistroan.
		 *
		 * @param e Ekintza abiarazten duen gertaera (sakatu "Datuak sartu" botoia).
		 */

		datuaksartu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String nanData = nan.getText();
				String izenaData = izena.getText();
				String abizenaData = abizena.getText();
				String generoaData = generoaBox.getSelectedItem().toString();
				String telefonoaData = telefonoa.getText();
				String herriaData = herria.getText();
				String talde_kodeaData = talde_kodea.getText();
				String txapelketakData = txapelketak.getText();

				Piraguista piraguista = new Piraguista(nanData, izenaData, abizenaData, generoaData, telefonoaData,
						herriaData, talde_kodeaData, txapelketakData);

				String datuPiraguista = piraguista.getNan() + "\t" + piraguista.getIzena() + "\t"
						+ piraguista.getAbizena() + "\t" + piraguista.getGeneroa() + "\t" + piraguista.getTelefonoa()
						+ "\t" + piraguista.getHerria() + "\t" + piraguista.getTalde_kodea() + "\t"
						+ piraguista.getTxapelketak() + "\n";
				erregistroa.append(datuPiraguista);
			}
		});

		/**
		 * ActionListener: "Fitxategia sortu" botoia sakatzean aktibatzen da. Eska
		 * iezaiozu erabiltzaileari piraguistaren datuak gordeko dituen fitxategiaren
		 * helbide absolutua eta fitxategi izena. fitxategia badela eta baliozkoa dela
		 * egiaztatzen du, eta, ondoren, JTextArea erregistroko datuak idazten ditu
		 * fitxategi horretan. Arrakasta- edo errore-mezu bat erakusten du, eragiketaren
		 * emaitzaren arabera.
		 *
		 * @param e Ekintza abiarazten duen gertaera (egin klik "Fitxategia sortu"
		 *          botoian).
		 * 
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

		/**
		 * Konfiguratu JFrame frame2 leihoaren diseinua eta propietateak. BorderLayout
		 * bat erabiltzen da osagaiak leihoan antolatzeko. Datuak panela leihoaren
		 * erdira gehitzen da. Leihoaren tamaina 600x400 pixelekoa izango da. Leihoa
		 * ixtean, eragiketa lehenetsia DISPOSE_ON_CLOSE gisa ezartzen da. Leihoa
		 * ikusgai dago.
		 */

		frame2.getContentPane().setLayout(new BorderLayout());
		frame2.getContentPane().add(datuak, BorderLayout.CENTER);
		frame2.setSize(600, 400);
		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame2.setVisible(true);
	}
}

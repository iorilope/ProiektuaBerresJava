

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

/**
* Interfaze grafikoa kudeatzen duen klasea, datuak programan sartzeko.
* Mota honek "aukera", "piraguistak", "indibidualak" eta "taldeak" bezalako osagaiak ditu, leiho nagusira gehitzen direnak.
* "ElementuakJarri ()" metodo bat eskaintzen du, leihoari osagaiak gehitzen dizkiona, haien diseinua eta tamaina ezartzen dituena eta ikusgarri egiten dituena.
* "Piraguistak", "indibidualak" eta "taldeak" botoietarako ActionListeners ere badu. Botoi horiek dagozkien metodoak aipatzen dituzte.
* beste klase batzuetakoak, interfaze grafikoak erakusteko, piraguistekin, banakako parte-hartzaileekin eta taldeekin zerikusia duten datuak sartzeko, hurrenez hurren.
*/

public class DatuakSartuGUI {

	/** Aukera Label-a. */
	private static JLabel aukera = new JLabel("Klikatu zure aukeran", SwingConstants.CENTER);

	/** Hasierako Frame-a */
	private static JFrame frame = new JFrame("Hasiera");

	/** Piraguistak aukeratzeko botoia. */
	private static JButton piraguistak = new JButton("Piraguista taula");

	/** Indibidualak aukeratzeko botoiak */
	private static JButton indibidualak = new JButton("Lehiaketa indibidualak taula");

	/** Taldeka auekratzeko botoia */
	private static JButton taldeak = new JButton("Talde lehiaketa taula");

	/**
	 * Programaren leiho nagusiari osagaiak gehitzeko metodoa. Metodo honek
	 * "aukera", "piraguistak", "indibidualak" eta "taldeak" osagaiak gehitzen
	 * dizkio leiho nagusiaren edukiari. Gero, leihoaren diseinua ezartzen du, 4
	 * errenkadako eta zutabe bateko lauki-sare gisa. Osagaiak paketatu ondoren,
	 * leihoaren tamaina 500x500 pixeletan ezarri eta ikusgai jartzen du. Azkenik,
	 * gehitu WindowListener bat, leihoa ixten denean aplikazioa behar bezala
	 * ixteko.
	 */
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

		/**
		 * "Piraguistak" botoirako ActionListener, erabiltzaileak botoian klik egiten
		 * duenean aktibatzen dena. ActionListener honek "DatuakSartuPiraguistaGUI"
		 * klasearen "PantailaErakutsi ()" metodoa aipatzen du. piraguistekin lotutako
		 * datuak sartzeko interfaze grafiko bat erakusten du.
		 */

		piraguistak.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DatuakSartuPiraguistaGUI.pantailaErakutsi();
			}
		});

		/**
		 * "Indibidualak" botoirako ActionListener, erabiltzaileak botoian klik egiten
		 * duenean aktibatzen dena. ActionListener honek "DatuakSartuIndibidualGUI"
		 * klaseko "pantailaErakutsi ()" metodoa aipatzen du. interfaze grafiko bat
		 * erakusten du, banakako parte-hartzaileekin lotutako datuak sartzeko.
		 */

		indibidualak.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DatuakSartuIndibidualGUI.pantailaErakutsi();
			}
		});

		/**
		 * "Taldeak" botoirako ActionListener, erabiltzaileak botoian klik egiten
		 * duenean aktibatzen dena. ActionListener honek "DatuakSartuTaldeaGUI" klaseko
		 * "pantailaErakutsi ()" metodoa aipatzen du. interfaze grafiko bat erakusten
		 * du, taldeekin lotutako datuak sartzeko.
		 */

		taldeak.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DatuakSartuTaldeaGUI.pantailaErakutsi();
			}
		});
	}
}

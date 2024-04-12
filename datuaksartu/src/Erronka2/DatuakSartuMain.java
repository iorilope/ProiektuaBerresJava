
package Erronka2;

import javax.swing.UIManager;

/**
 * DatuakSartuMain Klasea
 */
public class DatuakSartuMain {

	/**
	 * Main metodoa
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatuakSartuGUI.elementuakJarri();
	}
}

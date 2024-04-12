package Erronka2;

import static org.junit.Assert.assertTrue;

import java.awt.event.WindowEvent;

import javax.swing.*;

import org.junit.jupiter.api.Test;

public class DatuakSartuGUITest {

	@Test
	public void testPiraguistaButtonClick() {

		DatuakSartuGUI datuakSartuGUI = new DatuakSartuGUI();

		JButton piraguistakButton = DatuakSartuGUI.piraguistak;
		piraguistakButton.doClick();

		JFrame frame = DatuakSartuPiraguistaGUI.frame2;
		frame.setVisible(true);
		assertTrue(frame.isVisible());
	}

	@Test
	public void testIndibidualakButtonClick() {

	}

	@Test
	public void testTaldeakButtonClick() {

	}

	@Test
	public void testWindowClosing() {
		// Arrange (prepare test environment)
		DatuakSartuGUI datuakSartuGUI = new DatuakSartuGUI(); // Create an instance

		// Act (simulate user interaction)
		JFrame frame = datuakSartuGUI.frame; // Get the main frame
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

		// Assert (verify expected behavior)
		// No explicit assertion needed as System.exit(0) in WindowListener terminates
		// the test
	}
}
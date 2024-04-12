package Erronka2;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.*;

public class DatuakSartuIndibidualGUITest {

    

    @Test
    public void testValidFileCreation() throws Exception {
       
        String erabiltzaileaksartupath = JOptionPane.showInputDialog("Sartu fitxategiaren helbide absolutua(Hemen gordeko da zure fitxategia)");
        while (erabiltzaileaksartupath == null || erabiltzaileaksartupath.isEmpty()) {
        	erabiltzaileaksartupath = JOptionPane.showInputDialog("Fitxategiari helbide absolutua jarri behar zaio!");
        }

        String erabiltzaileaksartuizena = JOptionPane.showInputDialog("Sartu fitxategiaren izena");
        while (erabiltzaileaksartuizena == null || erabiltzaileaksartuizena.isEmpty() || erabiltzaileaksartuizena.equals(".txt")) {
        	erabiltzaileaksartuizena = JOptionPane.showInputDialog("Fitxategiak izena eduki behar du!");
        }

        String fullPath = erabiltzaileaksartupath + File.separator + erabiltzaileaksartuizena + ".txt";

        
        File path = new File(erabiltzaileaksartupath);
        if (!path.exists()) {
            throw new Exception("Fitxategiaren helbidea ez da existitzen!");
        }

      
        File file = new File(fullPath);
        while (file.exists()) {
        	erabiltzaileaksartuizena = JOptionPane.showInputDialog("Fitxategiaren izena iada existitzen da, jarri beste bat.");
            fullPath = erabiltzaileaksartupath + File.separator + erabiltzaileaksartuizena + ".txt";
            file = new File(fullPath);
        }

        // Create the file
        try (BufferedWriter fitxategia = new BufferedWriter(new FileWriter(fullPath))) {
            fitxategia.write("NAN1\tTXAP1\tDEN1\nNAN2\tTXAP2\tDEN2\n");
        }

        // Verify file creation (might need adjustment)
        File createdFile = new File(fullPath);
        assertTrue(createdFile.exists());

        // Check file content (optional)
        String fileContent = new String(java.nio.file.Files.readAllBytes(createdFile.toPath()));
        assertEquals("NAN1\tTXAP1\tDEN1\nNAN2\tTXAP2\tDEN2\n", fileContent);
    }
    @Test
    public void testDatuakSartuButtonAction() {
      // Create mock components
      JTextField piraguistaNan = new JTextField();
      JTextField txapelketaId = new JTextField();
      JTextField denbora = new JTextField();
      JTextArea erregistroa = new JTextArea();
      JButton datuaksartu = new JButton();

      // Simulate user input
      piraguistaNan.setText("123456");
      txapelketaId.setText("ABCD");
      denbora.setText("00:10:00");

      // Add ActionListener to the button
      datuaksartu.addActionListener((ActionListener) new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          String nan = piraguistaNan.getText();
          String txapelketaIda = txapelketaId.getText();
          String denboraa = denbora.getText();

          Indibiduala indibiduala = new Indibiduala(nan, txapelketaIda, denboraa);

          String DatuIndibidualak = indibiduala.getPiraguistaNan() + "\t" + indibiduala.getTxapelketaId() + "\t"
              + indibiduala.getDenbora() + "\n";

          erregistroa.append(DatuIndibidualak);
        }
      });

      // Simulate button click
      datuaksartu.doClick();

      // Verify expected data in erregistroa
      String expectedText = "123456\tABCD\t00:10:00\n";
      assertEquals(expectedText, erregistroa.getText());
    }
}

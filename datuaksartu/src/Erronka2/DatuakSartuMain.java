package Erronka2;

import javax.swing.UIManager;

public class DatuakSartuMain {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        DatuakSartuGUI.elementuakJarri();
    }
}

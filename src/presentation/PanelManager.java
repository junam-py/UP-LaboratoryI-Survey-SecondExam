package presentation;

import javax.swing.JFrame;

public class PanelManager {
    private JFrame frame;
    // private PromoterRegistrationPanel promoterRegistrationPanel;
    // private PromoterListPanel promoterListPanel;

    public PanelManager() {
        initializeManager();
    }

    public void initializeManager() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 500);
    }

}

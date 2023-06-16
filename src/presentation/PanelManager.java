package presentation;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


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
        frame.setLocationRelative(null);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if(DialogManager.ShowConfirmationMessage == JOptionPane.YES_OPTION) {
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING);
                }
            }
        });
        promoterRegistrationPanel = new PromoterRegistrationPanel(this);
        promoterListPanel =  new PromoterListPanel(this);
        new StartMainPanel(this);

    }

}

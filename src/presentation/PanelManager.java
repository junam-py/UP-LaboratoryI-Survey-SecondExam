package presentation;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import presentation.mainpanel.PromoterRegistrationMainPanel;
import presentation.mainpanel.StartMainPanel;


public class PanelManager {
    private JFrame frame;
    private PromoterRegistrationMainPanel promoterRegistrationPanel;
    private PromoterListPanel promoterListPanel;

    public PanelManager() {
        initializeManager();
    }

    public void initializeManager() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 500);
        frame.setLocationRelativeTo(null);
        promoterRegistrationPanel = new PromoterRegistrationMainPanel(this);
        promoterListPanel =  new PromoterListPanel(this);
        new StartMainPanel(this);
    }

    public void showFrame() {
        frame.setVisible(true);
    }

    public void showMain() {
        showMainPanel(new StartMainPanel(this));
    }

    public void showMainPanel(JPanel mainPanel) {
        frame.getContentPane().removeAll();
        frame.add(mainPanel);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }

    public void showPromoterList() {
        promoterListPanel = new PromoterListPanel(this);
        showMainPanel(promoterListPanel);
    }

    public void showPromoterRegistration() {
        promoterRegistrationPanel = new PromoterRegistrationMainPanel(this);
        showMainPanel(promoterRegistrationPanel);
    }
}

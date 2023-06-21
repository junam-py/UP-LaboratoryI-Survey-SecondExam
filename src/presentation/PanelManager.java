package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.mainpanel.PromoterRegistrationMainPanel;
import presentation.mainpanel.PromoterListMainPanel;
import presentation.mainpanel.StartMainPanel;
import services.model.Promoter;


public class PanelManager {
    
    private JFrame frame;
    private PromoterRegistrationMainPanel promoterRegistrationPanel;
    private PromoterListMainPanel promoterListPanel;

    public PanelManager() { }

    public void initializeManager() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        promoterRegistrationPanel = new PromoterRegistrationMainPanel(this);
        promoterListPanel =  new PromoterListMainPanel(this);
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
        showMainPanel(new PromoterListMainPanel(this));
    }

    public void showPromoterEdition(Promoter promoter) {
        showMainPanel(new PromoterRegistrationMainPanel(this, promoter));
    }

    public void showPromoterRegistration() {
        promoterRegistrationPanel = new PromoterRegistrationMainPanel(this);
        showMainPanel(promoterRegistrationPanel);
    }

}
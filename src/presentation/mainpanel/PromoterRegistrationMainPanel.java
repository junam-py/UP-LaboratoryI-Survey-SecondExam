package presentation.mainpanel;

import presentation.PanelManager;
import presentation.basemainpanel.RegisterMainPanel;
import presentation.panel.PromoterFieldsPanel;
import services.PromoterService;
import services.exception.ServiceException;
import services.model.Promoter;

public class PromoterRegistrationMainPanel extends RegisterMainPanel {
    private final PromoterService promoterService;

    public PromoterRegistrationMainPanel(PanelManager panelManager) {
        super(panelManager);
        promoterService = new PromoterService();
    }

    @Override
    public void setFieldsPanel() {
        fieldsPanel = new PromoterFieldsPanel(panelManager);
    }

    @Override
    public void acceptAction() { 
        PromoterFieldsPanel promoterFieldsPanel = (PromoterFieldsPanel) fieldsPanel;
        String id = promoterFieldsPanel.getIdText().getText();
        String name = promoterFieldsPanel.getIdText().getText();
        String secondName = promoterFieldsPanel.getIdText().getText();
        String email = promoterFieldsPanel.getIdText().getText();
        String age = promoterFieldsPanel.getIdText().getText();
        Promoter newPromoter = new Promoter(Integer.valueOf(id), name, secondName, email, Integer.valueOf(age));
        try {
            promoterService.createPromoter(newPromoter);
            backAction();
        } catch(ServiceException e) {
            // buscar forma de mostrar error en el panel
        }
    }

    @Override 
    public void cleanAction() {
        PromoterFieldsPanel promoterFieldsPanel = (PromoterFieldsPanel) fieldsPanel;
        promoterFieldsPanel.getIdText().setText("");
        promoterFieldsPanel.getNameText().setText("");
        promoterFieldsPanel.getSecondNameText().setText("");
        promoterFieldsPanel.getEmailText().setText("");
        promoterFieldsPanel.getAgeText().setText("");
    }

    @Override
    public void backAction() {
        cleanAction();
        panelManager.showPromoterList();
    }
}

package presentation.mainpanel;

import presentation.PanelManager;
import presentation.basemainpanel.RegisterMainPanel;
import presentation.panel.PromoterFieldsPanel;
import services.PromoterService;
import services.exception.ServiceException;
import services.model.Promoter;

public class PromoterRegistrationMainPanel extends RegisterMainPanel {
    private final PromoterService promoterService;
    private boolean edition;

    public PromoterRegistrationMainPanel(PanelManager panelManager) {
        super(panelManager);
        edition = false;
        promoterService = new PromoterService();
    }

    public PromoterRegistrationMainPanel(PanelManager panelManager, Promoter promoterEdition) {
        super(panelManager);
        edition = true;
        promoterService = new PromoterService();
        fillFields(promoterEdition);
    }

    public void fillFields(Promoter promoter) {
        PromoterFieldsPanel promoterFieldsPanel = (PromoterFieldsPanel) fieldsPanel;
        promoterFieldsPanel.getIdText().setText(String.valueOf(promoter.getID()));
        promoterFieldsPanel.getNameText().setText(promoter.getName());
        promoterFieldsPanel.getSecondNameText().setText(promoter.getSecondName());
        promoterFieldsPanel.getEmailText().setText(promoter.getEmail());
        promoterFieldsPanel.getAgeText().setText(String.valueOf(promoter.getAge()));
    }

    @Override
    public void setFieldsPanel() {
        fieldsPanel = new PromoterFieldsPanel(panelManager);
    }

    @Override
    public void acceptAction() {
        PromoterFieldsPanel promoterFieldsPanel = (PromoterFieldsPanel) fieldsPanel;
        String id = promoterFieldsPanel.getIdText().getText();
        String name = promoterFieldsPanel.getNameText().getText();
        String secondName = promoterFieldsPanel.getSecondNameText().getText();
        String email = promoterFieldsPanel.getEmailText().getText();
        String age = promoterFieldsPanel.getAgeText().getText();
        Promoter newPromoter = new Promoter(Integer.valueOf(id), name, secondName, email, Integer.valueOf(age));
        if (edition == false) {
            try {
                promoterService.createPromoter(newPromoter);
                backAction();
            } catch (ServiceException e) {
                // buscar forma de mostrar error en el panel
            }

        } else {
            try {
                promoterService.updatePromoter(newPromoter);
                backAction();
            } catch (ServiceException e) {
                // buscar forma de mostrar error en el panel
            }
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

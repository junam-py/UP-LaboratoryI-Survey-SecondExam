package presentation.mainpanel;

import java.awt.BorderLayout;
import presentation.PanelManager;
import presentation.basemainpanel.RegisterMainPanel;
import presentation.panel.PromoterFieldsPanel;
import services.PromoterService;
import services.exception.ServiceException;
import services.model.Promoter;

/**
 * Formulario de alta/edición de promotores.
 */
public class PromoterRegistrationMainPanel extends RegisterMainPanel {
    private final PromoterService promoterService;
    private final boolean edition;

    /** Constructor para crear un promotor nuevo */
    public PromoterRegistrationMainPanel(PanelManager panelManager) {
        super(panelManager);
        this.promoterService = new PromoterService();
        this.edition         = false;
        setFieldsPanel();
    }

    /** Constructor para editar un promotor existente */
    public PromoterRegistrationMainPanel(PanelManager panelManager, Promoter promoterToEdit) {
        super(panelManager);
        this.promoterService = new PromoterService();
        this.edition         = true;
        setFieldsPanel();
        fillFields(promoterToEdit);
    }

    /** Rellena los campos con los datos del promotor */
    private void fillFields(Promoter promoter) {
        PromoterFieldsPanel p = (PromoterFieldsPanel) fieldsPanel;
        p.getIdText().setText(promoter.getId() != null ? promoter.getId().toString() : "");
        p.getUsernameText().setText(promoter.getUsername());
        p.getPasswordText().setText(promoter.getPassword());
        p.getRoleText().setText(promoter.getRole());
        p.getLocationText().setText(promoter.getLocation());
    }

    @Override
    public void setFieldsPanel() {
        fieldsPanel = new PromoterFieldsPanel(panelManager);
        add(fieldsPanel, BorderLayout.CENTER);
    }

    @Override
    public void acceptAction() {
        PromoterFieldsPanel p = (PromoterFieldsPanel) fieldsPanel;
        Long   id       = p.getIdText().getText().isEmpty() 
                            ? null 
                            : Long.valueOf(p.getIdText().getText());
        String username = p.getUsernameText().getText().trim();
        String password = p.getPasswordText().getText().trim();
        String role     = p.getRoleText().getText().trim();
        String location = p.getLocationText().getText().trim();

        Promoter promoter = new Promoter(id, username, password, role, location);
        try {
            if (!edition) {
                promoterService.createPromoter(promoter);
            } else {
                promoterService.updatePromoter(promoter);
            }
            backAction();
        } catch (ServiceException e) {
            // TODO: mostrar mensaje de error (ej. JOptionPane)
        }
    }

    @Override
    public void cleanAction() {
        PromoterFieldsPanel p = (PromoterFieldsPanel) fieldsPanel;
        p.getIdText().setText("");
        p.getUsernameText().setText("");
        p.getPasswordText().setText("");
        p.getRoleText().setText("");
        p.getLocationText().setText("");
    }

    @Override
    public void backAction() {
        cleanAction();
        panelManager.showPromoterList();
    }
}

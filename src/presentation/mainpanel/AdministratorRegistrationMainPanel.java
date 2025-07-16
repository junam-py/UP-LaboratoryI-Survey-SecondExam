package presentation.mainpanel;

import java.awt.BorderLayout;
import presentation.PanelManager;
import presentation.basemainpanel.RegisterMainPanel;
import presentation.panel.AdministratorFieldsPanel;
import services.AdministratorService;
import services.exception.ServiceException;
import services.model.Administrator;

/**
 * Formulario de alta/edición de administradores.
 */
public class AdministratorRegistrationMainPanel extends RegisterMainPanel {
    private final AdministratorService adminService;
    private final boolean edition;

    public AdministratorRegistrationMainPanel(PanelManager panelManager) {
        super(panelManager);
        this.adminService = new AdministratorService();
        this.edition      = false;
        setFieldsPanel();
    }

    public AdministratorRegistrationMainPanel(PanelManager panelManager, Administrator adminToEdit) {
        super(panelManager);
        this.adminService = new AdministratorService();
        this.edition      = true;
        setFieldsPanel();
        fillFields(adminToEdit);
    }

    private void fillFields(Administrator admin) {
        AdministratorFieldsPanel p = (AdministratorFieldsPanel) fieldsPanel;
        p.getIdText().setText(String.valueOf(admin.getId()));
        p.getUsernameText().setText(admin.getUsername());
        p.getPasswordText().setText(admin.getPassword());
    }

    @Override
    public void setFieldsPanel() {
        fieldsPanel = new AdministratorFieldsPanel(panelManager);
        add(fieldsPanel, BorderLayout.CENTER);
    }

    @Override
    public void acceptAction() {
        AdministratorFieldsPanel p = (AdministratorFieldsPanel) fieldsPanel;
        Long   id       = p.getIdText().getText().isEmpty()
                            ? null
                            : Long.valueOf(p.getIdText().getText());
        String username = p.getUsernameText().getText().trim();
        String password = p.getPasswordText().getText().trim();

        Administrator a = new Administrator(id, username, password);
        try {
            if (!edition) {
                adminService.register(a);
            } else {
                adminService.updateAdministrator(a);
            }
            backAction();
        } catch (ServiceException e) {
            // TODO: mostrar mensaje de error
        }
    }

    @Override
    public void cleanAction() {
        AdministratorFieldsPanel p = (AdministratorFieldsPanel) fieldsPanel;
        p.getIdText().setText("");
        p.getUsernameText().setText("");
        p.getPasswordText().setText("");
    }

    @Override
    public void backAction() {
        cleanAction();
        panelManager.showAdministratorList();
    }
}

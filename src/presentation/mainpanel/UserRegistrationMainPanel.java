package presentation.mainpanel;

import java.awt.BorderLayout;
import presentation.PanelManager;
import presentation.basemainpanel.RegisterMainPanel;
import presentation.panel.UserFieldsPanel;
import services.UserService;
import services.exception.ServiceException;
import services.model.User;

/**
 * Formulario de alta/edición de usuarios.
 */
public class UserRegistrationMainPanel extends RegisterMainPanel {
    private final UserService userService;
    private final boolean edition;

    public UserRegistrationMainPanel(PanelManager panelManager) {
        super(panelManager);
        this.userService = new UserService();
        this.edition     = false;
        setFieldsPanel();
    }

    public UserRegistrationMainPanel(PanelManager panelManager, User userToEdit) {
        super(panelManager);
        this.userService = new UserService();
        this.edition     = true;
        setFieldsPanel();
        fillFields(userToEdit);
    }

    private void fillFields(User user) {
        UserFieldsPanel p = (UserFieldsPanel) fieldsPanel;
        p.getIdText().setText(user.getId() != null ? user.getId().toString() : "");
        p.getUsernameText().setText(user.getUsername());
        p.getPasswordText().setText(user.getPassword());
        p.getRoleText().setText(user.getRole());
    }

    @Override
    public void setFieldsPanel() {
        fieldsPanel = new UserFieldsPanel(panelManager);
        add(fieldsPanel, BorderLayout.CENTER);
    }

    @Override
    public void acceptAction() {
        UserFieldsPanel p = (UserFieldsPanel) fieldsPanel;
        Long   id       = p.getIdText().getText().isEmpty()
                            ? null
                            : Long.valueOf(p.getIdText().getText());
        String username = p.getUsernameText().getText().trim();
        String password = p.getPasswordText().getText().trim();
        String role     = p.getRoleText().getText().trim();

        User u = new User(id, username, password, role);
        try {
            if (!edition) {
                userService.createUser(u);
            } else {
                userService.updateUser(u);
            }
            backAction();
        } catch (ServiceException e) {
            // TODO: mostrar mensaje de error
        }
    }

    @Override
    public void cleanAction() {
        UserFieldsPanel p = (UserFieldsPanel) fieldsPanel;
        p.getIdText().setText("");
        p.getUsernameText().setText("");
        p.getPasswordText().setText("");
        p.getRoleText().setText("");
    }

    @Override
    public void backAction() {
        cleanAction();
        panelManager.showUserList();
    }
}

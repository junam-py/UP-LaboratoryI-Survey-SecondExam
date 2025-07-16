package presentation.mainpanel;

import java.util.List;

import presentation.PanelManager;
import presentation.basemainpanel.ListMainPanel;
import presentation.tablepanel.UserTablePanel;
import services.UserService;
import services.exception.ServiceException;
import services.model.User;

/**
 * List view for Users.
 */
public class UserListMainPanel extends ListMainPanel<User> {
    private final UserService userService;

    public UserListMainPanel(PanelManager panelManager) {
        super(panelManager);
        this.userService = new UserService();
    }

    @Override
    protected void setTablePanel() {
        tablePanel = new UserTablePanel(panelManager);
    }

    @Override
    public void loadData() {
        List<User> items;
        try {
            items = userService.findAll();
        } catch (ServiceException e) {
            items = List.of();
        }
        tablePanel.initializePanel(items);
    }

    @Override
    public void addAction() {
        panelManager.showUserRegistration();
    }

    @Override
    public void editAction() {
        UserTablePanel up = (UserTablePanel) tablePanel;
        int row = up.getSelectedRow();
        if (row >= 0) {
            User u = up.getUserTableModel().getContent().get(row);
            panelManager.showUserEdition(u);
        }
    }

    @Override
    public void deleteAction() {
        UserTablePanel up = (UserTablePanel) tablePanel;
        int row = up.getSelectedRow();
        if (row >= 0) {
            User u = up.getUserTableModel().getContent().get(row);
            try {
                userService.deleteUser(u.getId());
                loadData();
            } catch (ServiceException ignore) { }
        }
    }

    @Override
    public void backAction() {
        panelManager.showMain();
    }
}

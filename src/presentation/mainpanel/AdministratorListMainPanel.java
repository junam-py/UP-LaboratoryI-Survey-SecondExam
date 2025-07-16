package presentation.mainpanel;

import java.util.List;

import presentation.PanelManager;
import presentation.basemainpanel.ListMainPanel;
import presentation.tablepanel.AdministratorTablePanel;
import services.AdministratorService;
import services.exception.ServiceException;
import services.model.Administrator;

/**
 * List view for Administrators.
 */
public class AdministratorListMainPanel extends ListMainPanel<Administrator> {
    private final AdministratorService adminService;

    public AdministratorListMainPanel(PanelManager panelManager) {
        super(panelManager);
        this.adminService = new AdministratorService();
    }

    @Override
    protected void setTablePanel() {
        tablePanel = new AdministratorTablePanel(panelManager);
    }

    @Override
    public void loadData() {
        List<Administrator> items;
        try {
            items = adminService.findAll();
        } catch (ServiceException e) {
            items = List.of();
        }
        tablePanel.initializePanel(items);
    }

    @Override
    public void addAction() {
        panelManager.showAdministratorRegistration();
    }

    @Override
    public void editAction() {
        AdministratorTablePanel atp = (AdministratorTablePanel) tablePanel;
        int row = atp.getSelectedRow();
        if (row >= 0) {
            Administrator a = atp.getAdministratorTableModel().getContent().get(row);
            panelManager.showAdministratorEdition(a);
        }
    }

    @Override
    public void deleteAction() {
        AdministratorTablePanel atp = (AdministratorTablePanel) tablePanel;
        int row = atp.getSelectedRow();
        if (row >= 0) {
            Administrator a = atp.getAdministratorTableModel().getContent().get(row);
            try {
                adminService.deleteAdministrator(a.getId());
                loadData();
            } catch (ServiceException ignore) { }
        }
    }

    @Override
    public void backAction() {
        panelManager.showMain();
    }
}

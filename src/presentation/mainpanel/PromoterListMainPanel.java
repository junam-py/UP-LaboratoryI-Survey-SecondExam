package presentation.mainpanel;

import java.util.List;

import presentation.PanelManager;
import presentation.basemainpanel.ListMainPanel;
import presentation.tablepanel.PromoterTablePanel;
import services.PromoterService;
import services.exception.ServiceException;
import services.model.Promoter;

/**
 * List view for Promoters.
 */
public class PromoterListMainPanel extends ListMainPanel<Promoter> {
    private final PromoterService promoterService;

    public PromoterListMainPanel(PanelManager panelManager) {
        super(panelManager);
        this.promoterService = new PromoterService();
    }

    @Override
    protected void setTablePanel() {
        tablePanel = new PromoterTablePanel(panelManager);
    }

    @Override
    public void loadData() {
        List<Promoter> items;
        try {
            items = promoterService.findAll();
        } catch (ServiceException e) {
            items = List.of();
        }
        tablePanel.initializePanel(items);
    }

    @Override
    public void addAction() {
        panelManager.showPromoterRegistration();
    }

    @Override
    public void editAction() {
        PromoterTablePanel pp = (PromoterTablePanel) tablePanel;
        int row = pp.getSelectedRow();
        if (row >= 0) {
            Promoter p = pp.getPromoterTableModel().getContent().get(row);
            panelManager.showPromoterEdition(p);
        }
    }

    @Override
    public void deleteAction() {
        PromoterTablePanel pp = (PromoterTablePanel) tablePanel;
        int row = pp.getSelectedRow();
        if (row >= 0) {
            Promoter p = pp.getPromoterTableModel().getContent().get(row);
            try {
                promoterService.deletePromoter(p.getId());
                loadData();
            } catch (ServiceException ignore) { }
        }
    }

    @Override
    public void backAction() {
        panelManager.showMain();
    }
}

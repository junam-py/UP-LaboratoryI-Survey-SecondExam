package presentation.mainpanel;

import java.util.ArrayList;

import presentation.PanelManager;
import presentation.basemainpanel.ListMainPanel;
import presentation.tablepanel.PromoterTablePanel;
import services.PromoterService;
import services.exception.ServiceException;
import services.model.Promoter;

public class PromoterListMainPanel extends ListMainPanel {
    private final PromoterService promoterService;

    public PromoterListMainPanel(PanelManager panelManager) {
        super(panelManager);
        promoterService = new PromoterService();
        tablePanel.initializePanel(obtainPromoters());
    }

    public ArrayList<Promoter> obtainPromoters() {
        ArrayList<Promoter> promotersList = null;
        try {
            promotersList = promoterService.obtainPromoters();
        } catch(ServiceException e) {
            // TODO buscar forma de mostrar error en el panel
        }
        return promotersList;
    }

    @Override
    public void setTablePanel() {
        tablePanel = new PromoterTablePanel(panelManager);
    }
}

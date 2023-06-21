package presentation.basepanel;

import java.util.List;

import javax.swing.JPanel;

import presentation.PanelManager;
import services.model.Promoter;

public abstract class TableBasePanel extends JPanel {
    protected final PanelManager panelManager;

    public TableBasePanel(PanelManager panelManager) {
        this.panelManager = panelManager;
    }

    /**
    * This method depends on which panel we are working in
    * @see PromoterTablePanel.java file
    */
    public abstract void initializePanel(List<Promoter> list);
}

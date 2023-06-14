package presentation.basepanel;

import java.util.List;

import javax.swing.JPanel;

import presentation.PanelManager;
import services.Promoter;

public abstract class TableBasePanel extends JPanel {
    protected final PanelManager panelManager;

    public TableBasePanel(PanelManager panelManager) {
        this.panelManager = panelManager;
    }

    public abstract void initializePanel(List<Promoter> list);
}

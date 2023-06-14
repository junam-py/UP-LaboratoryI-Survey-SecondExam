package presentation.basepanel;

import javax.swing.JPanel;

import presentation.PanelManager;

public abstract class FiltersBasePanel extends JPanel {
    protected final PanelManager panelManager;

    public FiltersBasePanel(PanelManager panelManager) {
        this.panelManager = panelManager;
    }

    public abstract void initializePanel();
}

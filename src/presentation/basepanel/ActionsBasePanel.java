package presentation.basepanel;

import javax.swing.JPanel;

import presentation.PanelManager;

public abstract class ActionsBasePanel extends JPanel {
    protected final PanelManager panelManager;

    public ActionsBasePanel(PanelManager panelManager) {
        this.panelManager = panelManager;
        initializePanel();
    }

    public abstract void initializePanel();
}

package presentation.basepanel;

import javax.swing.JPanel;

import presentation.PanelManager;

public abstract class ActionsBasePanel extends JPanel {
    protected final PanelManager panelManager;

    public ActionsBasePanel(PanelManager panelManager) {
        this.panelManager = panelManager;
        initializePanel();
    }

    /**
    * This method depends on which panel we are working in
    * @see FormActionsPanel.java & ListActionsPanel file
    */
    public abstract void initializePanel();
}

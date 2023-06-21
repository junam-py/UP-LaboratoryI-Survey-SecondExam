package presentation.basepanel;

import javax.swing.JPanel;

import presentation.PanelManager;
import presentation.panel.FormActionsPanel;

public abstract class FieldsBasePanel extends JPanel {
    protected final PanelManager panelManager;

    public FieldsBasePanel(PanelManager panelManager) {
        this.panelManager = panelManager;
    }
    
    /**
    * This method depends on which panel we are working in
    * @see FormActionsPanel.java & ListActionsPanel file
    */
    public abstract void initializePanel();
}

package presentation.basepanel;

import javax.swing.JPanel;

import presentation.PanelManager;

public abstract class FieldsBasePanel extends JPanel {
    protected final PanelManager panelManager;

    public FieldsBasePanel(PanelManager panelManager) {
        this.panelManager = panelManager;
    }

    public abstract void initializePanel();
}

package presentation.panel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import presentation.PanelManager;
import presentation.basepanel.ActionsBasePanel;

public class FormActionsPanel extends ActionsBasePanel {

    private JButton acceptButton;
    private JButton backButton;
    private JButton cleanButton;

    public FormActionsPanel(PanelManager panelManager) {
        super(panelManager);
    }

    public void initializePanel() {
        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new BoxLayout(actionsPanel, BoxLayout.X_AXIS));
        acceptButton = new JButton("Accept");
        cleanButton = new JButton("Clean");
        backButton = new JButton("Back");

        actionsPanel.add(acceptButton);
        actionsPanel.add(cleanButton);
        actionsPanel.add(backButton);

        this.add(actionsPanel);
    }

    public JButton getAcceptButton() {
        return acceptButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getCleanButton() {
        return cleanButton;
    }

}
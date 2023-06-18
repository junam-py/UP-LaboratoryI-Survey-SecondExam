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
        backButton = new JButton("Back");
        cleanButton = new JButton("Clean");

        actionsPanel.add(acceptButton);
        actionsPanel.add(backButton);
        actionsPanel.add(cleanButton);

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

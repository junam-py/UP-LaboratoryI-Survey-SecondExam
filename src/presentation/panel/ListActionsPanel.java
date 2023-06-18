package presentation.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import presentation.PanelManager;
import presentation.basepanel.ActionsBasePanel;

public class ListActionsPanel extends ActionsBasePanel {
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton backButton;

    public ListActionsPanel(PanelManager panelManager) {
        super(panelManager);
    }

    public void initializePanel() {
        setLayout(new BorderLayout());
        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new FlowLayout());
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        backButton = new JButton("Back");

        actionsPanel.add(addButton);
        actionsPanel.add(editButton);
        actionsPanel.add(deleteButton);
        actionsPanel.add(backButton);

        add(actionsPanel);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getBackButton() {
        return backButton;
    }
}

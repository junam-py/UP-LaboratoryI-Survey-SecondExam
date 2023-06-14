package presentation.basemainpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import presentation.PanelManager;
import presentation.basepanel.TableBasePanel;
import presentation.panel.ListActionsPanel;

public abstract class ListMainPanel extends JPanel {
    protected PanelManager panelManager;

    protected TableBasePanel tablePanel;
    protected ListActionsPanel listPanel;

    public ListMainPanel(PanelManager panelManager) {
        this.panelManager = panelManager;
        setTablePanel();
        setActionsPanel();
        initializePanel();
    }

    public void initializePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(tablePanel);
        add(listPanel);

        listPanel.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                addAction();
            }
        });

        listPanel.getEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                editAction();
            }
        });

        listPanel.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAction();
            }
        });

        listPanel.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backAction();
            }

        });
    }

    public void setActionsPanel() {
        listPanel = new ListActionsPanel(panelManager);
    }

    public abstract void setTablePanel();

    public abstract void addAction();

    public abstract void editAction();

    public abstract void backAction();

    public abstract void deleteAction();
}

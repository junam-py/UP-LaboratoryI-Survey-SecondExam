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
        add(tablePanel); // base table panel for promoters list
        add(listPanel); // base actions table panel for promoters list

        listPanel.getAddButton().addActionListener(new ActionListener() {
            // if user press add button
            @Override
            public void actionPerformed(ActionEvent event) {
                addAction();
            }
        });

        listPanel.getEditButton().addActionListener(new ActionListener() {
            // if user press edit button
            @Override
            public void actionPerformed(ActionEvent event) {
                editAction();
            }
        });

        listPanel.getDeleteButton().addActionListener(new ActionListener() {
            // if user press delete button
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAction();
            }
        });

        listPanel.getBackButton().addActionListener(new ActionListener() {
            // if user press back button
            @Override
            public void actionPerformed(ActionEvent e) {
                backAction();
            }

        });
    }

    // Same actions for all panel lists
    public void setActionsPanel() {
        listPanel = new ListActionsPanel(panelManager);
    }

    /**
    * This methods depends on which table we are working in
    * @see PromoterListMainPanel.java file
    */

    public abstract void setTablePanel();

    public abstract void addAction();

    public abstract void editAction();

    public abstract void backAction();

    public abstract void deleteAction();

}
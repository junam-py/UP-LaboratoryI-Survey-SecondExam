package presentation.basemainpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.h2.engine.SettingsBase;
import org.h2.table.TableBase;

import presentation.PanelManager;
import presentation.basepanel.TableBasePanel;
import presentation.panel.ListActionsPanel;
import services.Promoter;

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
    }
}

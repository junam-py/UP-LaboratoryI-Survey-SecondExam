package presentation.basemainpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import presentation.PanelManager;
import presentation.basepanel.FieldsBasePanel;
import presentation.panel.FormActionsPanel;

public abstract class RegisterMainPanel extends JPanel {
    protected PanelManager panelManager;

    protected FieldsBasePanel fieldsPanel;
    protected FormActionsPanel formPanel;

    public RegisterMainPanel(PanelManager panelManager) {
        this.panelManager = panelManager;
        setFieldsPanel();
        setActionsPanel();
        initializePanel();
    }

    public void initializePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(fieldsPanel);
        add(formPanel);

        formPanel.getAcceptButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                acceptAction();
            }
        });

        formPanel.getCleanButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                cleanAction();
            }
        });

        formPanel.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                backAction();
            }
        });
    
    }

    private void setActionsPanel() {
        formPanel = new FormActionsPanel(panelManager);
    }

    public abstract void setFieldsPanel();

    public abstract void acceptAction();
    public abstract void cleanAction();
    public abstract void backAction();

}

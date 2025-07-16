package presentation.panel;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.PanelManager;
import presentation.basepanel.FieldsBasePanel;

public class SurveyFieldsPanel extends FieldsBasePanel {

    private JTextField idText;
    private JTextField titleText;
    private JTextField descriptionText;

    public SurveyFieldsPanel(PanelManager panelManager) {
        super(panelManager);
        initializePanel();
    }

    @Override
    public void initializePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // ID
        JPanel idPanel = new JPanel();
        idPanel.setLayout(new BoxLayout(idPanel, BoxLayout.X_AXIS));
        idPanel.add(new JLabel("ID:"));
        idText = new JTextField();
        idPanel.add(idText);
        add(idPanel);

        // Title
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        titlePanel.add(new JLabel("Title:"));
        titleText = new JTextField();
        titlePanel.add(titleText);
        add(titlePanel);

        // Description
        JPanel descPanel = new JPanel();
        descPanel.setLayout(new BoxLayout(descPanel, BoxLayout.X_AXIS));
        descPanel.add(new JLabel("Description:"));
        descriptionText = new JTextField();
        descPanel.add(descriptionText);
        add(descPanel);
    }

    public JTextField getIdText() {
        return idText;
    }

    public JTextField getTitleText() {
        return titleText;
    }

    public JTextField getDescriptionText() {
        return descriptionText;
    }
}

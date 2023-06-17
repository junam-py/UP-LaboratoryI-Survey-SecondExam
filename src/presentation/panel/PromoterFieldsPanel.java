package presentation.panel;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.PanelManager;
import presentation.basepanel.FieldsBasePanel;

public class PromoterFieldsPanel extends FieldsBasePanel {
    private JTextField idText;
    private JTextField nameText;
    private JTextField secondNameText;
    private JTextField emailText;
    private JTextField ageText;

    public PromoterFieldsPanel(PanelManager panelManager) {
        super(panelManager);
        initializePanel();
    }

    public void initializePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        addFieldPanel(idText, "ID:");
        addFieldPanel(nameText, "Name:");  
        addFieldPanel(secondNameText, "Second name:");
        addFieldPanel(emailText, "Email:");
        addFieldPanel(ageText, "Age:");
    }

    public void addFieldPanel(JTextField textField, String labelText) {
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.X_AXIS));
        JLabel label = new JLabel(labelText);
        textField = new JTextField("");
        fieldPanel.add(label);
        fieldPanel.add(textField);
        add(fieldPanel);
    }

    public JTextField getNameText() {
        return nameText;
    }

    public JTextField getSecondNameText() {
        return secondNameText;
    }

    public JTextField getEmailText() {
        return emailText;
    }

    public JTextField getIdText() {
        return idText;
    }

    public JTextField getAgeText() {
        return ageText;
    }
}

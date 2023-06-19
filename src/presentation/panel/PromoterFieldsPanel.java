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

        JPanel idFieldPanel = new JPanel();
        idFieldPanel.setLayout(new BoxLayout(idFieldPanel, BoxLayout.X_AXIS));
        JLabel idLabel = new JLabel("ID:");
        idText = new JTextField("");
        idFieldPanel.add(idLabel);
        idFieldPanel.add(idText);
        add(idFieldPanel);

        JPanel nameFieldPanel = new JPanel();
        nameFieldPanel.setLayout(new BoxLayout(nameFieldPanel, BoxLayout.X_AXIS));
        JLabel nameLabel = new JLabel("Name:");
        nameText = new JTextField("");
        nameFieldPanel.add(nameLabel);
        nameFieldPanel.add(nameText);
        add(nameFieldPanel);

        JPanel secondNameFieldPanel = new JPanel();
        secondNameFieldPanel.setLayout(new BoxLayout(secondNameFieldPanel, BoxLayout.X_AXIS));
        JLabel secondNameLabel = new JLabel("Second Name:");
        secondNameText = new JTextField("");
        secondNameFieldPanel.add(secondNameLabel);
        secondNameFieldPanel.add(secondNameText);
        add(secondNameFieldPanel);

        JPanel emailFieldPanel = new JPanel();
        emailFieldPanel.setLayout(new BoxLayout(emailFieldPanel, BoxLayout.X_AXIS));
        JLabel emaiLabel = new JLabel("Email:");
        emailText = new JTextField("");
        emailFieldPanel.add(emaiLabel);
        emailFieldPanel.add(emailText);
        add(emailFieldPanel);

        JPanel ageFieldPanel = new JPanel();
        ageFieldPanel.setLayout(new BoxLayout(ageFieldPanel, BoxLayout.X_AXIS));
        JLabel ageLabel = new JLabel("Age:");
        ageText = new JTextField("");
        ageFieldPanel.add(ageLabel);
        ageFieldPanel.add(ageText);
        add(ageFieldPanel);

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

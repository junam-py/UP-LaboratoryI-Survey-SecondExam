package presentation.panel;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.PanelManager;
import presentation.basepanel.FieldsBasePanel;

/**
 * Panel de campos para Promoter con username, password, role y location.
 */
public class PromoterFieldsPanel extends FieldsBasePanel {
    private JTextField idText;
    private JTextField usernameText;
    private JTextField passwordText;
    private JTextField roleText;
    private JTextField locationText;

    public PromoterFieldsPanel(PanelManager panelManager) {
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
        idText = new JTextField(10);
        idText.setEditable(false);
        idPanel.add(idText);
        add(idPanel);

        // Username
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.X_AXIS));
        userPanel.add(new JLabel("Username:"));
        usernameText = new JTextField(15);
        userPanel.add(usernameText);
        add(userPanel);

        // Password
        JPanel passPanel = new JPanel();
        passPanel.setLayout(new BoxLayout(passPanel, BoxLayout.X_AXIS));
        passPanel.add(new JLabel("Password:"));
        passwordText = new JTextField(15);
        passPanel.add(passwordText);
        add(passPanel);

        // Role
        JPanel rolePanel = new JPanel();
        rolePanel.setLayout(new BoxLayout(rolePanel, BoxLayout.X_AXIS));
        rolePanel.add(new JLabel("Role:"));
        roleText = new JTextField(15);
        rolePanel.add(roleText);
        add(rolePanel);

        // Location
        JPanel locPanel = new JPanel();
        locPanel.setLayout(new BoxLayout(locPanel, BoxLayout.X_AXIS));
        locPanel.add(new JLabel("Location:"));
        locationText = new JTextField(15);
        locPanel.add(locationText);
        add(locPanel);
    }

    public JTextField getIdText() {
        return idText;
    }

    public JTextField getUsernameText() {
        return usernameText;
    }

    public JTextField getPasswordText() {
        return passwordText;
    }

    public JTextField getRoleText() {
        return roleText;
    }

    public JTextField getLocationText() {
        return locationText;
    }
}

package presentation.panel;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.PanelManager;
import presentation.basepanel.FieldsBasePanel;

public class UserFieldsPanel extends FieldsBasePanel {

    private JTextField idText;
    private JTextField usernameText;
    private JTextField passwordText;
    private JTextField roleText;

    public UserFieldsPanel(PanelManager panelManager) {
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

        // Username
        JPanel usernamePanel = new JPanel();
        usernamePanel.setLayout(new BoxLayout(usernamePanel, BoxLayout.X_AXIS));
        usernamePanel.add(new JLabel("Username:"));
        usernameText = new JTextField();
        usernamePanel.add(usernameText);
        add(usernamePanel);

        // Password
        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
        passwordPanel.add(new JLabel("Password:"));
        passwordText = new JTextField();
        passwordPanel.add(passwordText);
        add(passwordPanel);

        // Role
        JPanel rolePanel = new JPanel();
        rolePanel.setLayout(new BoxLayout(rolePanel, BoxLayout.X_AXIS));
        rolePanel.add(new JLabel("Role:"));
        roleText = new JTextField();
        rolePanel.add(roleText);
        add(rolePanel);
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
}

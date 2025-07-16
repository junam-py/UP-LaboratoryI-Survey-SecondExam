package presentation.panel;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.PanelManager;
import presentation.basepanel.FieldsBasePanel;

public class AnswerFieldsPanel extends FieldsBasePanel {

    private JTextField idText;
    private JTextField questionIdText;
    private JTextField userIdText;
    private JTextField ratingText;

    public AnswerFieldsPanel(PanelManager panelManager) {
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

        // Question ID
        JPanel qPanel = new JPanel();
        qPanel.setLayout(new BoxLayout(qPanel, BoxLayout.X_AXIS));
        qPanel.add(new JLabel("Question ID:"));
        questionIdText = new JTextField();
        qPanel.add(questionIdText);
        add(qPanel);

        // User ID
        JPanel uPanel = new JPanel();
        uPanel.setLayout(new BoxLayout(uPanel, BoxLayout.X_AXIS));
        uPanel.add(new JLabel("User ID:"));
        userIdText = new JTextField();
        uPanel.add(userIdText);
        add(uPanel);

        // Rating
        JPanel ratingPanel = new JPanel();
        ratingPanel.setLayout(new BoxLayout(ratingPanel, BoxLayout.X_AXIS));
        ratingPanel.add(new JLabel("Rating:"));
        ratingText = new JTextField();
        ratingPanel.add(ratingText);
        add(ratingPanel);
    }

    public JTextField getIdText() {
        return idText;
    }

    public JTextField getQuestionIdText() {
        return questionIdText;
    }

    public JTextField getUserIdText() {
        return userIdText;
    }

    public JTextField getRatingText() {
        return ratingText;
    }
}

package presentation.panel;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.PanelManager;
import presentation.basepanel.FieldsBasePanel;

public class QuestionFieldsPanel extends FieldsBasePanel {

    private JTextField idText;
    private JTextField surveyIdText;
    private JTextField textText;

    public QuestionFieldsPanel(PanelManager panelManager) {
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

        // Survey ID
        JPanel surveyIdPanel = new JPanel();
        surveyIdPanel.setLayout(new BoxLayout(surveyIdPanel, BoxLayout.X_AXIS));
        surveyIdPanel.add(new JLabel("Survey ID:"));
        surveyIdText = new JTextField();
        surveyIdPanel.add(surveyIdText);
        add(surveyIdPanel);

        // Text
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.X_AXIS));
        textPanel.add(new JLabel("Text:"));
        textText = new JTextField();
        textPanel.add(textText);
        add(textPanel);
    }

    public JTextField getIdText() {
        return idText;
    }

    public JTextField getSurveyIdText() {
        return surveyIdText;
    }

    public JTextField getTextText() {
        return textText;
    }
}

// src/presentation/mainpanel/StartMainPanel.java
package presentation.mainpanel;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import presentation.PanelManager;

public class StartMainPanel extends JPanel {
    
    protected PanelManager panelManager;
    private JButton usersButton;
    private JButton promotersButton;
    private JButton adminsButton;
    private JButton surveysButton;
    private JButton questionsButton;
    private JButton answersButton;

    public StartMainPanel(PanelManager panelManager) {
        this.panelManager = panelManager;
        initializePanel();
    }

    public void initializePanel() {
        setLayout(new FlowLayout());

        usersButton      = new JButton("Users");
        promotersButton  = new JButton("Promoters");
        adminsButton     = new JButton("Administrators");
        surveysButton    = new JButton("Surveys");
        questionsButton  = new JButton("Questions");
        answersButton    = new JButton("Answers");

        add(usersButton);
        add(promotersButton);
        add(adminsButton);
        add(surveysButton);
        add(questionsButton);
        add(answersButton);

        usersButton.addActionListener(e -> panelManager.showUserList());
        promotersButton.addActionListener(e -> panelManager.showPromoterList());
        adminsButton.addActionListener(e -> panelManager.showAdministratorList());
        surveysButton.addActionListener(e -> panelManager.showSurveyList());
        questionsButton.addActionListener(e -> panelManager.showQuestionList());
        answersButton.addActionListener(e -> panelManager.showAnswerList());
    }
}

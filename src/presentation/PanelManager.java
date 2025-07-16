package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.mainpanel.*;
import services.model.User;
import services.model.Promoter;
import services.model.Administrator;
import services.model.Survey;
import services.model.Question;
import services.model.Answer;

/**
 * Manages the navigation between main panels by replacing the content of the frame.
 */
public class PanelManager {
    private JFrame frame;

    private UserRegistrationMainPanel     userRegistrationPanel;
    private UserListMainPanel             userListPanel;

    private PromoterRegistrationMainPanel promoterRegistrationPanel;
    private PromoterListMainPanel         promoterListPanel;

    private AdministratorRegistrationMainPanel administratorRegistrationPanel;
    private AdministratorListMainPanel         administratorListPanel;

    private SurveyRegistrationMainPanel    surveyRegistrationPanel;
    private SurveyListMainPanel            surveyListPanel;

    private QuestionRegistrationMainPanel  questionRegistrationPanel;
    private QuestionListMainPanel          questionListPanel;

    private AnswerRegistrationMainPanel    answerRegistrationPanel;
    private AnswerListMainPanel            answerListPanel;

    public PanelManager() { }

    public void initializeManager() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Pre-initialize all list panels
        userListPanel          = new UserListMainPanel(this);
        promoterListPanel      = new PromoterListMainPanel(this);
        administratorListPanel = new AdministratorListMainPanel(this);
        surveyListPanel        = new SurveyListMainPanel(this);
        questionListPanel      = new QuestionListMainPanel(this);
        answerListPanel        = new AnswerListMainPanel(this);

        // Show start panel
        showMainPanel(new StartMainPanel(this));
    }

    public void showFrame() {
        frame.setVisible(true);
    }

    public void showMain() {
        showMainPanel(new StartMainPanel(this));
    }

    public void showMainPanel(JPanel mainPanel) {
        frame.getContentPane().removeAll();
        frame.add(mainPanel);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }

    // ---- User ----
    public void showUserRegistration() {
        userRegistrationPanel = new UserRegistrationMainPanel(this);
        showMainPanel(userRegistrationPanel);
    }

    public void showUserEdition(User user) {
        showMainPanel(new UserRegistrationMainPanel(this, user));
    }

    public void showUserList() {
        showMainPanel(userListPanel);
    }

    // ---- Promoter ----
    public void showPromoterRegistration() {
        promoterRegistrationPanel = new PromoterRegistrationMainPanel(this);
        showMainPanel(promoterRegistrationPanel);
    }

    public void showPromoterEdition(Promoter promoter) {
        showMainPanel(new PromoterRegistrationMainPanel(this, promoter));
    }

    public void showPromoterList() {
        showMainPanel(promoterListPanel);
    }

    // ---- Administrator ----
    public void showAdministratorRegistration() {
        administratorRegistrationPanel = new AdministratorRegistrationMainPanel(this);
        showMainPanel(administratorRegistrationPanel);
    }

    public void showAdministratorEdition(Administrator admin) {
        showMainPanel(new AdministratorRegistrationMainPanel(this, admin));
    }

    public void showAdministratorList() {
        showMainPanel(administratorListPanel);
    }

    // ---- Survey ----
    public void showSurveyRegistration() {
        surveyRegistrationPanel = new SurveyRegistrationMainPanel(this);
        showMainPanel(surveyRegistrationPanel);
    }

    public void showSurveyEdition(Survey survey) {
        showMainPanel(new SurveyRegistrationMainPanel(this, survey));
    }

    public void showSurveyList() {
        showMainPanel(surveyListPanel);
    }

    // ---- Question ----
    public void showQuestionRegistration() {
        questionRegistrationPanel = new QuestionRegistrationMainPanel(this);
        showMainPanel(questionRegistrationPanel);
    }

    public void showQuestionEdition(Question question) {
        showMainPanel(new QuestionRegistrationMainPanel(this, question));
    }

    public void showQuestionList() {
        showMainPanel(questionListPanel);
    }

    // ---- Answer ----
    public void showAnswerRegistration() {
        answerRegistrationPanel = new AnswerRegistrationMainPanel(this);
        showMainPanel(answerRegistrationPanel);
    }

    public void showAnswerEdition(Answer answer) {
        showMainPanel(new AnswerRegistrationMainPanel(this, answer));
    }

    public void showAnswerList() {
        showMainPanel(answerListPanel);
    }
}

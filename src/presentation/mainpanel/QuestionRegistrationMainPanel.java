package presentation.mainpanel;

import java.awt.BorderLayout;
import presentation.PanelManager;
import presentation.basemainpanel.RegisterMainPanel;
import presentation.panel.QuestionFieldsPanel;
import services.QuestionService;
import services.exception.ServiceException;
import services.model.Question;

/**
 * Formulario de alta/edición de preguntas.
 */
public class QuestionRegistrationMainPanel extends RegisterMainPanel {
    private final QuestionService questionService;
    private final boolean edition;

    /**
     * Constructor para crear una nueva pregunta.
     */
    public QuestionRegistrationMainPanel(PanelManager panelManager) {
        super(panelManager);
        this.questionService = new QuestionService();
        this.edition         = false;
        setFieldsPanel();
    }

    /**
     * Constructor para editar una pregunta existente.
     */
    public QuestionRegistrationMainPanel(PanelManager panelManager, Question questionToEdit) {
        super(panelManager);
        this.questionService = new QuestionService();
        this.edition         = true;
        setFieldsPanel();
        fillFields(questionToEdit);
    }

    /**
     * Rellena los campos con los datos de la pregunta.
     */
    private void fillFields(Question question) {
        QuestionFieldsPanel p = (QuestionFieldsPanel) fieldsPanel;
        p.getIdText().setText(question.getId() != null ? question.getId().toString() : "");
        p.getSurveyIdText().setText(question.getSurveyId() != null ? question.getSurveyId().toString() : "");
        p.getTextText().setText(question.getText());
    }

    @Override
    public void setFieldsPanel() {
        fieldsPanel = new QuestionFieldsPanel(panelManager);
        add(fieldsPanel, BorderLayout.CENTER);
    }

    @Override
    public void acceptAction() {
        QuestionFieldsPanel p = (QuestionFieldsPanel) fieldsPanel;
        Long   id       = p.getIdText().getText().isEmpty()
                            ? null
                            : Long.valueOf(p.getIdText().getText());
        Long   surveyId = Long.valueOf(p.getSurveyIdText().getText().trim());
        String text     = p.getTextText().getText().trim();

        Question q = new Question(id, surveyId, text);
        try {
            if (!edition) {
                questionService.addQuestion(q);
            } else {
                questionService.updateQuestion(q);
            }
            backAction();
        } catch (ServiceException e) {
            // TODO: mostrar mensaje de error (e.g. JOptionPane)
        }
    }

    @Override
    public void cleanAction() {
        QuestionFieldsPanel p = (QuestionFieldsPanel) fieldsPanel;
        p.getIdText().setText("");
        p.getSurveyIdText().setText("");
        p.getTextText().setText("");
    }

    @Override
    public void backAction() {
        cleanAction();
        panelManager.showQuestionList();
    }
}

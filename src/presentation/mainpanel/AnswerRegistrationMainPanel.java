package presentation.mainpanel;

import java.awt.BorderLayout;
import java.util.Date;
import presentation.PanelManager;
import presentation.basemainpanel.RegisterMainPanel;
import presentation.panel.AnswerFieldsPanel;
import services.AnswerService;
import services.exception.ServiceException;
import services.model.Answer;

/**
 * Formulario de registro de respuestas de usuarios.
 */
public class AnswerRegistrationMainPanel extends RegisterMainPanel {
    private final AnswerService answerService;
    private final boolean edition;

    public AnswerRegistrationMainPanel(PanelManager panelManager) {
        super(panelManager);
        this.answerService = new AnswerService();
        this.edition       = false;
        setFieldsPanel();
    }

    public AnswerRegistrationMainPanel(PanelManager panelManager, Answer answerToEdit) {
        super(panelManager);
        this.answerService = new AnswerService();
        this.edition       = true;
        setFieldsPanel();
        fillFields(answerToEdit);
    }

    private void fillFields(Answer answer) {
        AnswerFieldsPanel p = (AnswerFieldsPanel) fieldsPanel;
        p.getIdText().setText(answer.getId() != null ? answer.getId().toString() : "");
        p.getQuestionIdText().setText(answer.getQuestionId().toString());
        p.getUserIdText().setText(answer.getUserId().toString());
        p.getRatingText().setText(String.valueOf(answer.getRating()));
    }

    @Override
    public void setFieldsPanel() {
        fieldsPanel = new AnswerFieldsPanel(panelManager);
        add(fieldsPanel, BorderLayout.CENTER);
    }

    @Override
    public void acceptAction() {
        AnswerFieldsPanel p = (AnswerFieldsPanel) fieldsPanel;
        Long   id         = p.getIdText().getText().isEmpty()
                              ? null
                              : Long.valueOf(p.getIdText().getText());
        Long   questionId = Long.valueOf(p.getQuestionIdText().getText().trim());
        Long   userId     = Long.valueOf(p.getUserIdText().getText().trim());
        int    rating     = Integer.parseInt(p.getRatingText().getText().trim());
        Date   now        = new Date();

        Answer a = new Answer(id, questionId, userId, rating, now);
        try {
            if (!edition) {
                answerService.answerQuestion(questionId, userId, rating, now);
            } else {
                answerService.updateAnswer(a);
            }
            backAction();
        } catch (ServiceException e) {
            // TODO: mostrar mensaje de error
        }
    }

    @Override
    public void cleanAction() {
        AnswerFieldsPanel p = (AnswerFieldsPanel) fieldsPanel;
        p.getIdText().setText("");
        p.getQuestionIdText().setText("");
        p.getUserIdText().setText("");
        p.getRatingText().setText("");
    }

    @Override
    public void backAction() {
        cleanAction();
        panelManager.showAnswerList();
    }
}

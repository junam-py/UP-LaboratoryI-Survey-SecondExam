package presentation.mainpanel;

import java.awt.BorderLayout;
import presentation.PanelManager;
import presentation.basemainpanel.RegisterMainPanel;
import presentation.panel.SurveyFieldsPanel;
import services.SurveyService;
import services.exception.ServiceException;
import services.model.Survey;

/**
 * Formulario de alta/edición de encuestas.
 */
public class SurveyRegistrationMainPanel extends RegisterMainPanel {
    private final SurveyService surveyService;
    private final boolean edition;

    public SurveyRegistrationMainPanel(PanelManager panelManager) {
        super(panelManager);
        this.surveyService = new SurveyService();
        this.edition       = false;
        setFieldsPanel();
    }

    public SurveyRegistrationMainPanel(PanelManager panelManager, Survey surveyToEdit) {
        super(panelManager);
        this.surveyService = new SurveyService();
        this.edition       = true;
        setFieldsPanel();
        fillFields(surveyToEdit);
    }

    private void fillFields(Survey survey) {
        SurveyFieldsPanel p = (SurveyFieldsPanel) fieldsPanel;
        p.getIdText().setText(survey.getId() != null ? survey.getId().toString() : "");
        p.getTitleText().setText(survey.getTitle());
        p.getDescriptionText().setText(survey.getDescription());
    }

    @Override
    public void setFieldsPanel() {
        fieldsPanel = new SurveyFieldsPanel(panelManager);
        add(fieldsPanel, BorderLayout.CENTER);
    }

    @Override
    public void acceptAction() {
        SurveyFieldsPanel p = (SurveyFieldsPanel) fieldsPanel;
        Long   id          = p.getIdText().getText().isEmpty()
                              ? null
                              : Long.valueOf(p.getIdText().getText());
        String title       = p.getTitleText().getText().trim();
        String description = p.getDescriptionText().getText().trim();

        Survey s = new Survey(id, title, description);
        try {
            if (!edition) {
                surveyService.createSurvey(s);
            } else {
                surveyService.updateSurvey(s);
            }
            backAction();
        } catch (ServiceException e) {
            // TODO: mostrar mensaje de error
        }
    }

    @Override
    public void cleanAction() {
        SurveyFieldsPanel p = (SurveyFieldsPanel) fieldsPanel;
        p.getIdText().setText("");
        p.getTitleText().setText("");
        p.getDescriptionText().setText("");
    }

    @Override
    public void backAction() {
        cleanAction();
        panelManager.showSurveyList();
    }
}

package presentation.mainpanel;

import java.util.List;

import presentation.PanelManager;
import presentation.basemainpanel.ListMainPanel;
import presentation.tablepanel.SurveyTablePanel;
import services.SurveyService;
import services.exception.ServiceException;
import services.model.Survey;

/**
 * List view for Surveys.
 */
public class SurveyListMainPanel extends ListMainPanel<Survey> {
    private final SurveyService surveyService;

    public SurveyListMainPanel(PanelManager panelManager) {
        super(panelManager);
        this.surveyService = new SurveyService();
    }

    @Override
    protected void setTablePanel() {
        tablePanel = new SurveyTablePanel(panelManager);
    }

    @Override
    public void loadData() {
        List<Survey> items;
        try {
            items = surveyService.findAll();
        } catch (ServiceException e) {
            items = List.of();
        }
        tablePanel.initializePanel(items);
    }

    @Override
    public void addAction() {
        panelManager.showSurveyRegistration();
    }

    @Override
    public void editAction() {
        SurveyTablePanel sp = (SurveyTablePanel) tablePanel;
        int row = sp.getSelectedRow();
        if (row >= 0) {
            Survey s = sp.getSurveyTableModel().getContent().get(row);
            panelManager.showSurveyEdition(s);
        }
    }

    @Override
    public void deleteAction() {
        SurveyTablePanel sp = (SurveyTablePanel) tablePanel;
        int row = sp.getSelectedRow();
        if (row >= 0) {
            Survey s = sp.getSurveyTableModel().getContent().get(row);
            try {
                surveyService.deleteSurvey(s.getId());
                loadData();
            } catch (ServiceException ignore) { }
        }
    }

    @Override
    public void backAction() {
        panelManager.showMain();
    }
}

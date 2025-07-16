package presentation.mainpanel;

import java.util.List;

import presentation.PanelManager;
import presentation.basemainpanel.ListMainPanel;
import presentation.tablepanel.QuestionTablePanel;
import services.QuestionService;
import services.exception.ServiceException;
import services.model.Question;

/**
 * List view for Questions.
 */
public class QuestionListMainPanel extends ListMainPanel<Question> {
    private final QuestionService questionService;

    public QuestionListMainPanel(PanelManager panelManager) {
        super(panelManager);
        this.questionService = new QuestionService();
    }

    @Override
    protected void setTablePanel() {
        tablePanel = new QuestionTablePanel(panelManager);
    }

    @Override
    public void loadData() {
        List<Question> items;
        try {
            items = questionService.findAll();
        } catch (ServiceException e) {
            items = List.of();
        }
        tablePanel.initializePanel(items);
    }

    @Override
    public void addAction() {
        panelManager.showQuestionRegistration();
    }

    @Override
    public void editAction() {
        QuestionTablePanel qp = (QuestionTablePanel) tablePanel;
        int row = qp.getSelectedRow();
        if (row >= 0) {
            Question q = qp.getQuestionTableModel().getContent().get(row);
            panelManager.showQuestionEdition(q);
        }
    }

    @Override
    public void deleteAction() {
        QuestionTablePanel qp = (QuestionTablePanel) tablePanel;
        int row = qp.getSelectedRow();
        if (row >= 0) {
            Question q = qp.getQuestionTableModel().getContent().get(row);
            try {
                questionService.deleteQuestion(q.getId());
                loadData();
            } catch (ServiceException ignore) { }
        }
    }

    @Override
    public void backAction() {
        panelManager.showMain();
    }
}

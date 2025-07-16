package presentation.mainpanel;

import java.util.List;

import presentation.PanelManager;
import presentation.basemainpanel.ListMainPanel;
import presentation.tablepanel.AnswerTablePanel;
import services.AnswerService;
import services.exception.ServiceException;
import services.model.Answer;

/**
 * List view for Answers.
 */
public class AnswerListMainPanel extends ListMainPanel<Answer> {
    private final AnswerService answerService;

    public AnswerListMainPanel(PanelManager panelManager) {
        super(panelManager);
        this.answerService = new AnswerService();
    }

    @Override
    protected void setTablePanel() {
        tablePanel = new AnswerTablePanel(panelManager);
    }

    @Override
    public void loadData() {
        List<Answer> items;
        try {
            items = answerService.findAll();
        } catch (ServiceException e) {
            items = List.of();
        }
        tablePanel.initializePanel(items);
    }

    @Override
    public void addAction() {
        panelManager.showAnswerRegistration();
    }

    @Override
    public void editAction() {
        AnswerTablePanel ap = (AnswerTablePanel) tablePanel;
        int row = ap.getSelectedRow();
        if (row >= 0) {
            Answer a = ap.getAnswerTableModel().getContent().get(row);
            panelManager.showAnswerEdition(a);
        }
    }

    @Override
    public void deleteAction() {
        AnswerTablePanel ap = (AnswerTablePanel) tablePanel;
        int row = ap.getSelectedRow();
        if (row >= 0) {
            Answer a = ap.getAnswerTableModel().getContent().get(row);
            try {
                answerService.deleteAnswer(a.getId());
                loadData();
            } catch (ServiceException ignore) { }
        }
    }

    @Override
    public void backAction() {
        panelManager.showMain();
    }
}

package presentation.tablepanel;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import presentation.PanelManager;
import presentation.basepanel.TableBasePanel;
import presentation.tablemodel.SurveyTableModel;
import services.model.Survey;

public class SurveyTablePanel extends TableBasePanel<Survey> {

    private JTable surveyTable;
    private JScrollPane surveyTableScrollPane;
    private SurveyTableModel surveyTableModel;

    public SurveyTablePanel(PanelManager panelManager) {
        super(panelManager);
    }

    @Override
    public void initializePanel(List<Survey> list) {
        List<Survey> surveys = new ArrayList<>(list);
        setLayout(new BorderLayout());
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.X_AXIS));

        surveyTableModel      = new SurveyTableModel();
        surveyTable           = new JTable(surveyTableModel);
        surveyTableModel.setData(surveys);
        surveyTableScrollPane = new JScrollPane(surveyTable);

        add(surveyTableScrollPane, BorderLayout.CENTER);
    }

    public SurveyTableModel getSurveyTableModel() {
        return surveyTableModel;
    }

    public JScrollPane getSurveyTableScrollPane() {
        return surveyTableScrollPane;
    }

    public int getSelectedRow() {
        return surveyTable.getSelectedRow();
    }
}

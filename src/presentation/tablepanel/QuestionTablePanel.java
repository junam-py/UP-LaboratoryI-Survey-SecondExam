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
import presentation.tablemodel.QuestionTableModel;
import services.model.Question;

public class QuestionTablePanel extends TableBasePanel<Question> {

    private JTable questionTable;
    private JScrollPane questionTableScrollPane;
    private QuestionTableModel questionTableModel;

    public QuestionTablePanel(PanelManager panelManager) {
        super(panelManager);
    }

    @Override
    public void initializePanel(List<Question> list) {
        List<Question> questions = new ArrayList<>(list);
        setLayout(new BorderLayout());
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.X_AXIS));

        questionTableModel      = new QuestionTableModel();
        questionTable           = new JTable(questionTableModel);
        questionTableModel.setData(questions);
        questionTableScrollPane = new JScrollPane(questionTable);

        add(questionTableScrollPane, BorderLayout.CENTER);
    }

    public QuestionTableModel getQuestionTableModel() {
        return questionTableModel;
    }

    public JScrollPane getQuestionTableScrollPane() {
        return questionTableScrollPane;
    }

    public int getSelectedRow() {
        return questionTable.getSelectedRow();
    }
}

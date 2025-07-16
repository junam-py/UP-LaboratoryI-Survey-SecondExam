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
import presentation.tablemodel.AnswerTableModel;
import services.model.Answer;

public class AnswerTablePanel extends TableBasePanel<Answer> {

    private JTable answerTable;
    private JScrollPane answerTableScrollPane;
    private AnswerTableModel answerTableModel;

    public AnswerTablePanel(PanelManager panelManager) {
        super(panelManager);
    }

    @Override
    public void initializePanel(List<Answer> list) {
        List<Answer> answers = new ArrayList<>(list);
        setLayout(new BorderLayout());
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.X_AXIS));

        answerTableModel      = new AnswerTableModel();
        answerTable           = new JTable(answerTableModel);
        answerTableModel.setData(answers);
        answerTableScrollPane = new JScrollPane(answerTable);

        add(answerTableScrollPane, BorderLayout.CENTER);
    }

    public AnswerTableModel getAnswerTableModel() {
        return answerTableModel;
    }

    public JScrollPane getAnswerTableScrollPane() {
        return answerTableScrollPane;
    }

    public int getSelectedRow() {
        return answerTable.getSelectedRow();
    }
}

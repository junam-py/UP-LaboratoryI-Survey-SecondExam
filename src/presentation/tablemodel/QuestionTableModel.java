package presentation.tablemodel;

import services.model.Question;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * TableModel for Questions.
 */
public class QuestionTableModel extends AbstractTableModel {
    private List<Question> content;
    private final String[] headers = {"ID", "Survey ID", "Text"};

    public QuestionTableModel(List<Question> content) {
        this.content = content;
    }

    /** Returns the underlying list so callers can read/remove elements. */
    public List<Question> getContent() {
        return content;
    }

    @Override
    public int getRowCount() {
        return content != null ? content.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Question q = content.get(rowIndex);
        switch (columnIndex) {
            case 0: return q.getId();
            case 1: return q.getSurveyId();
            case 2: return q.getText();
            default: return null;
        }
    }
}

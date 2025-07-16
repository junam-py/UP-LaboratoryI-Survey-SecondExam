package presentation.tablemodel;

import services.model.Answer;
import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * TableModel for Answers.
 */
public class AnswerTableModel extends AbstractTableModel {
    private List<Answer> content;
    private final String[] headers = {"ID", "Question ID", "User ID", "Rating", "Answered At"};
    private final SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public AnswerTableModel(List<Answer> content) {
        this.content = content;
    }

    /** Returns the underlying list so callers can read/remove elements. */
    public List<Answer> getContent() {
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
        Answer a = content.get(rowIndex);
        switch (columnIndex) {
            case 0: return a.getId();
            case 1: return a.getQuestionId();
            case 2: return a.getUserId();
            case 3: return a.getRating();
            case 4: return fmt.format(a.getAnsweredAt());
            default: return null;
        }
    }
}

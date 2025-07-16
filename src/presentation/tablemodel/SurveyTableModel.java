package presentation.tablemodel;

import services.model.Survey;
import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * TableModel for Surveys.
 */
public class SurveyTableModel extends AbstractTableModel {
    private List<Survey> content;
    private final String[] headers = {"ID", "Title", "Description", "Created At"};
    private final SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public SurveyTableModel(List<Survey> content) {
        this.content = content;
    }

    /** Returns the underlying list so callers can read/remove elements. */
    public List<Survey> getContent() {
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
        Survey s = content.get(rowIndex);
        switch (columnIndex) {
            case 0: return s.getId();
            case 1: return s.getTitle();
            case 2: return s.getDescription();
            case 3: return s.getCreatedAt() != null ? fmt.format(s.getCreatedAt()) : "";
            default: return null;
        }
    }
}

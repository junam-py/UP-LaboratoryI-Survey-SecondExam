package presentation.tablemodel;

import services.model.Promoter;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * TableModel for Promoters.
 */
public class PromoterTableModel extends AbstractTableModel {
    private List<Promoter> content;
    private final String[] headers = {"ID", "Username", "Password", "Role", "Location"};

    public PromoterTableModel(List<Promoter> content) {
        this.content = content;
    }

    /** Returns the underlying list so callers can read/remove elements. */
    public List<Promoter> getContent() {
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
        Promoter p = content.get(rowIndex);
        switch (columnIndex) {
            case 0: return p.getId();
            case 1: return p.getUsername();
            case 2: return p.getPassword();
            case 3: return p.getRole();
            case 4: return p.getLocation();
            default: return null;
        }
    }
}

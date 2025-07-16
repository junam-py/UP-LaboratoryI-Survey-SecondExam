package presentation.tablemodel;

import services.model.Administrator;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * TableModel for Administrators.
 */
public class AdministratorTableModel extends AbstractTableModel {
    private List<Administrator> content;
    private final String[] headers = {"ID", "Username", "Password", "Role"};

    public AdministratorTableModel(List<Administrator> content) {
        this.content = content;
    }

    /** Returns the underlying list so callers can read/remove elements. */
    public List<Administrator> getContent() {
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
        Administrator a = content.get(rowIndex);
        switch (columnIndex) {
            case 0: return a.getId();
            case 1: return a.getUsername();
            case 2: return a.getPassword();
            case 3: return a.getRole();
            default: return null;
        }
    }
}

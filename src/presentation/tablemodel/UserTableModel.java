package presentation.tablemodel;

import services.model.User;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * TableModel for Users.
 */
public class UserTableModel extends AbstractTableModel {
    private List<User> content;
    private final String[] headers = {"ID", "Username", "Password", "Role"};

    public UserTableModel(List<User> content) {
        this.content = content;
    }

    /** Returns the underlying list so callers can read/remove elements. */
    public List<User> getContent() {
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
        User u = content.get(rowIndex);
        switch (columnIndex) {
            case 0: return u.getId();
            case 1: return u.getUsername();
            case 2: return u.getPassword();
            case 3: return u.getRole();
            default: return null;
        }
    }
}

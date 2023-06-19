package presentation.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import services.model.Promoter;

public class PromoterTableModel extends AbstractTableModel {
    private static final int ID_COL = 0;
    private static final int NAME_COL = 1;
    private static final int SECONDNAME_COL = 2;
    private static final int EMAIL_COL = 3;
    private static final int AGE_COL = 4;

    private String[] colNames = { "ID", "NAME", "SECONDNAME", "EMAIL", "AGE" };
    private Class[] colTypes = { Integer.class, String.class, String.class, String.class, Integer.class };
    private List<Promoter> content;

    public PromoterTableModel() {
        this.content = new ArrayList<Promoter>();
    }

    public PromoterTableModel(List<Promoter> initialContent) {
        this.content = initialContent;
    }

    public int getColumnCount() {
        return colNames.length;
    }

    public int getRowCount() {
        return content.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Promoter promoter = content.get(rowIndex);
        Object result = null;
        switch (columnIndex) {
            case ID_COL:
                result = promoter.getID();
                break;
            case NAME_COL:
                result = promoter.getName();
                break;
            case SECONDNAME_COL:
                result = promoter.getSecondName();
                break;
            case EMAIL_COL:
                result = promoter.getEmail();
                break;
            case AGE_COL:
                result = promoter.getAge();
                break;
            default:
                result = new String("");
        }
        return result;
    }

    public String getColumnName(int col) {
        return colNames[col];
    }

    public Class getColumnClass(int col) {
        return colTypes[col];
    }

    public List<Promoter> getContent() {
        return content;
    }

    public void setContent(List<Promoter> content) {
        this.content = content;
    }
}

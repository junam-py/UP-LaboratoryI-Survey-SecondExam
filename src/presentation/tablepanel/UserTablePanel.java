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
import presentation.tablemodel.UserTableModel;
import services.model.User;

public class UserTablePanel extends TableBasePanel<User> {

    private JTable userTable;
    private JScrollPane userTableScrollPane;
    private UserTableModel userTableModel;

    public UserTablePanel(PanelManager panelManager) {
        super(panelManager);
    }

    @Override
    public void initializePanel(List<User> list) {
        List<User> users = new ArrayList<>(list);
        setLayout(new BorderLayout());
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.X_AXIS));

        userTableModel      = new UserTableModel();
        userTable           = new JTable(userTableModel);
        userTableModel.setData(users);
        userTableScrollPane = new JScrollPane(userTable);

        add(userTableScrollPane, BorderLayout.CENTER);
    }

    public UserTableModel getUserTableModel() {
        return userTableModel;
    }

    public JScrollPane getUserTableScrollPane() {
        return userTableScrollPane;
    }

    public int getSelectedRow() {
        return userTable.getSelectedRow();
    }
}

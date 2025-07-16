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
import presentation.tablemodel.AdministratorTableModel;
import services.model.Administrator;

public class AdministratorTablePanel extends TableBasePanel<Administrator> {

    private JTable adminTable;
    private JScrollPane adminTableScrollPane;
    private AdministratorTableModel adminTableModel;

    public AdministratorTablePanel(PanelManager panelManager) {
        super(panelManager);
    }

    @Override
    public void initializePanel(List<Administrator> list) {
        List<Administrator> admins = new ArrayList<>(list);
        setLayout(new BorderLayout());
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.X_AXIS));

        adminTableModel      = new AdministratorTableModel();
        adminTable           = new JTable(adminTableModel);
        adminTableModel.setData(admins);
        adminTableScrollPane = new JScrollPane(adminTable);

        add(adminTableScrollPane, BorderLayout.CENTER);
    }

    public AdministratorTableModel getAdministratorTableModel() {
        return adminTableModel;
    }

    public JScrollPane getAdministratorTableScrollPane() {
        return adminTableScrollPane;
    }

    public int getSelectedRow() {
        return adminTable.getSelectedRow();
    }
}

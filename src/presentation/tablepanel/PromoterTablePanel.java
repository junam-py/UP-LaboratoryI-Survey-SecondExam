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
import presentation.tablemodel.PromoterTableModel;
import services.model.Promoter;

public class PromoterTablePanel extends TableBasePanel<Promoter> {

    private JTable promoterTable;
    private JScrollPane promoterTableScrollPane;
    private PromoterTableModel promoterTableModel;

    public PromoterTablePanel(PanelManager panelManager) {
        super(panelManager);
    }

    @Override
    public void initializePanel(List<Promoter> list) {
        List<Promoter> promoters = new ArrayList<>(list);
        setLayout(new BorderLayout());
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.X_AXIS));

        promoterTableModel      = new PromoterTableModel();
        promoterTable           = new JTable(promoterTableModel);
        promoterTableModel.setData(promoters);
        promoterTableScrollPane = new JScrollPane(promoterTable);

        add(promoterTableScrollPane, BorderLayout.CENTER);
    }

    public PromoterTableModel getPromoterTableModel() {
        return promoterTableModel;
    }

    public JScrollPane getPromoterTableScrollPane() {
        return promoterTableScrollPane;
    }

    public int getSelectedRow() {
        return promoterTable.getSelectedRow();
    }
}

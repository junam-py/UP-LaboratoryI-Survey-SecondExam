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

public class PromoterTablePanel extends TableBasePanel {

    private JTable promoterTable;
    private JScrollPane promoterTableScrollPane;
    private PromoterTableModel promoterTableModel;

    public PromoterTablePanel(PanelManager panelManager) {
        super(panelManager);
    }

    @Override
    public void initializePanel(List<Promoter> list) {
        ArrayList<Promoter> promoters = new ArrayList<Promoter>();
        for(Promoter value : list) {
            promoters.add(value);
        }
        setLayout(new BorderLayout());
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.X_AXIS));
        promoterTableModel = new PromoterTableModel();
        promoterTableModel.fireTableDataChanged();
        promoterTable = new JTable(promoterTableModel);
        promoterTableModel.setContent(promoters);
        add(tablePanel);
        add(promoterTable);
    }

    public JTable getPromoterTable() {
        return promoterTable;
    }

    public void setPromoterTable(JTable promoterTable) {
        this.promoterTable = promoterTable;
    }

    public PromoterTableModel getPromoterTableModel() {
        return promoterTableModel;
    }

    public void setPromoterTableModel(PromoterTableModel promoterTableModel) {
        this.promoterTableModel = promoterTableModel;
    }

    public JScrollPane getPromoterTableScrollPane() {
        return promoterTableScrollPane;
    }

    public void setPromoterTableScrollPane(JScrollPane promoterTableScrollPane) {
        this.promoterTableScrollPane = promoterTableScrollPane;
    }

}
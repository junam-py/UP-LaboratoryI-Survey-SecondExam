package presentation.tablepanel;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import presentation.PanelManager;
import presentation.tablemodel.PromoterTableModel;

public class PromoterTablePanel extends JPanel implements ActionListener, Printable {

    private PanelManager panelManager;
    private JTable promoterTable;
    private PromoterTableModel model;

    private JScrollPane scrollPane;
    private JButton fillButton;
    private JButton addButton;
    private JButton deleteButton;
    private JButton editButton;
    private JButton printButton;

    public PromoterTablePanel() {
        super();
        doPanel();
    }

    private void doPanel() {
        setLayout(new FlowLayout());
        model = new PromoterTableModel();
        promoterTable = new JTable(model);
        scrollPane = new JScrollPane(promoterTable);
        add(scrollPane);

        fillButton = new JButton("Load Table");
        fillButton.addActionListener(this);
        add(fillButton);

        deleteButton = new JButton("Delete Table");
        deleteButton.addActionListener(this);
        add(deleteButton);

        addButton = new JButton("Add Row");
        addButton.addActionListener(this);
        add(addButton);

        printButton = new JButton("Print Table");
        printButton.addActionListener(this);
        add(printButton);
    }


    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == printButton) {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(this);
            if(job.printDialog()) {
                try {
                    job.print();
                } catch(PrinterException e) {

                }
            }
        } else if(event.getSource() == addButton) {
            
        }
    }

}

// src/presentation/basemainpanel/ListMainPanel.java
package presentation.basemainpanel;

import javax.swing.*;

import presentation.PanelManager;
import presentation.basepanel.TableBasePanel;

import java.awt.*;


/**
 * Base abstract panel for listing entities of type T, with Add/Edit/Delete.
 */
public abstract class ListMainPanel<T> extends JPanel {
    protected final PanelManager panelManager;
    protected TableBasePanel<T> tablePanel;

    private final JButton addBtn    = new JButton("Add");
    private final JButton editBtn   = new JButton("Edit");
    private final JButton deleteBtn = new JButton("Delete");
    private final JButton backBtn   = new JButton("Back");

    public ListMainPanel(PanelManager panelManager) {
        this.panelManager = panelManager;
        setLayout(new BorderLayout());

        // 1. Botonera
        JPanel north = new JPanel(new FlowLayout(FlowLayout.LEFT));
        north.add(addBtn);
        north.add(editBtn);
        north.add(deleteBtn);
        north.add(backBtn);
        add(north, BorderLayout.NORTH);

        // 2. El tablePanel lo define cada subclase en setTablePanel()
        setTablePanel();
        add(tablePanel, BorderLayout.CENTER);

        // 3. Enlazar acciones
        addBtn   .addActionListener(e -> addAction());
        editBtn  .addActionListener(e -> editAction());
        deleteBtn.addActionListener(e -> deleteAction());
        backBtn  .addActionListener(e -> backAction());

        // 4. Cargar datos iniciales
        loadData();
    }

    /** Cada subclase debe instanciar su TableBasePanel concreto */
    protected abstract void setTablePanel();

    /** Rellena la tabla con los datos */
    public abstract void loadData();
    /** Abre el formulario de alta */
    public abstract void addAction();
    /** Abre el formulario de edición */
    public abstract void editAction();
    /** Elimina el elemento seleccionado */
    public abstract void deleteAction();
    /** Vuelve al menú principal */
    public abstract void backAction();
}

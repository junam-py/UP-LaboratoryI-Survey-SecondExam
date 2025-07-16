package presentation.basepanel;

import java.util.List;
import javax.swing.JPanel;
import presentation.PanelManager;

/**
 * Base genérico para todos los paneles de tabla.
 * Cada subclase indica su propio tipo T.
 */
public abstract class TableBasePanel<T> extends JPanel {
    protected final PanelManager panelManager;

    public TableBasePanel(PanelManager panelManager) {
        this.panelManager = panelManager;
    }

    /** Inicializa la tabla con la lista de entidades T */
    public abstract void initializePanel(List<T> list);
}

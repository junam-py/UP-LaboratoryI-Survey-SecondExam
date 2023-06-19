package services;

import database.exception.TableManagerException;
import database.tablemanager.PromoterTableManager;

public class DataInitialization {
    private PromoterService promoterService;
    
    public DataInitialization() {
        promoterService = new PromoterService();
    }

    public void initilizeData() {
        initializeTable();
    }

    public void initializeTable() {
        PromoterTableManager promoterTableManager = new PromoterTableManager();
        try {
            promoterTableManager.deletePromoterTable();
            promoterTableManager.createPromoterTable();
        } catch (TableManagerException e) {
            // TODO buscar forma de mostrar error en el panel
        }
    }
}

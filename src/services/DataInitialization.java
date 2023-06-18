package services;

import java.util.ArrayList;

import database.exception.TableManagerException;
import database.tablemanager.PromoterTableManager;
import services.exception.ServiceException;
import services.model.Promoter;

public class DataInitialization {
    private PromoterService promoterService;
    
    public DataInitialization() {
        promoterService = new PromoterService();
    }

    public void initilizeData() {
        initializeTable();
        initializePromoterModel();
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

    private void initializePromoterModel() {
        ArrayList<Promoter> promotersDB;
        try {
            promotersDB = promoterService.obtainPromoters();
        } catch (ServiceException e) {
            // TODO buscar forma de mostrar error en el panel
        }
    }
}

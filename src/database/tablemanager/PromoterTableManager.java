package database.tablemanager;

import database.DBManager;
import database.exception.DBManagerException;
import database.exception.TableManagerException;

public class PromoterTableManager {

    public void createPromoterTable() throws TableManagerException {
        String sql = "CREATE TABLE promoters ( id INTEGER IDENTITY, name VARCHAR(256), secondname VARCHAR(256), email VARCHAR(256), age INTEGER)";
        try {
            DBManager.generateStatementEx(sql);
        } catch (DBManagerException e) {
            throw new TableManagerException("Error creating promoter table");
        }
    }
    
    public void deletePromoterTable() throws TableManagerException {
        String sql = "DROP TABLE promoters";
        try {
            DBManager.generateStatementEx(sql);
        } catch(DBManagerException e)
        {
            throw new TableManagerException("Error deleting promoter table");
        }
    }

}

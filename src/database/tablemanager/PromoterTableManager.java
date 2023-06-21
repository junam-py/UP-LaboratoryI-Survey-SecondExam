package database.tablemanager;

import database.DBManager;
import database.exception.DBManagerException;
import database.exception.TableManagerException;

public class PromoterTableManager {

    public PromoterTableManager() { }

    /** 
     * @throws TableManagerException in case of error generating executing statement
     */
    public void createPromoterTable() throws TableManagerException {
        // SQL format be like: "CREATE TABLE IF NOT EXISTS PROMOTERS (id INTEGER IDENTITY, name VARCHAR(256), secondname VARCHAR(256), email VARCHAR(256), age INTEGER)"
        String sql = "CREATE TABLE IF NOT EXISTS PROMOTERS (id INTEGER IDENTITY, name VARCHAR(256), secondname VARCHAR(256), email VARCHAR(256), age INTEGER)";
        try {
            DBManager.generateStatementEx(sql);
        } catch (DBManagerException e) {
            throw new TableManagerException("Error creating promoters table");
        }
    }
    
    /** 
     * @throws TableManagerException in case of error generating executing statement
     */
    public void deletePromoterTable() throws TableManagerException {
        String sql = "DROP TABLE IF EXISTS PROMOTERS";
        try {
            DBManager.generateStatementEx(sql);
        } catch(DBManagerException e)
        {
            throw new TableManagerException("Error deleting promoters table");
        }
    }

}
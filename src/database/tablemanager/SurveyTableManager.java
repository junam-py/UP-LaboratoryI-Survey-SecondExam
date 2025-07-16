package database.tablemanager;

import database.DBManager;
import database.exception.DBManagerException;
import database.exception.TableManagerException;

/**
 * Creates the SURVEYS table.
 */
public class SurveyTableManager {
    public void createSurveysTable() throws TableManagerException {
        String sql = "CREATE TABLE IF NOT EXISTS SURVEYS (" +
                     "id INTEGER IDENTITY, " +
                     "title VARCHAR(255) NOT NULL, " +
                     "description VARCHAR(1024), " +
                     "created_at TIMESTAMP" +
                     ")";
        try {
            DBManager.generateStatementEx(sql);
        } catch (DBManagerException e) {
            throw new TableManagerException("Error creating surveys table", e);
        }
    }
}

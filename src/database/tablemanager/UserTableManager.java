package database.tablemanager;

import database.DBManager;
import database.exception.DBManagerException;
import database.exception.TableManagerException;

/**
 * Creates the USERS table (for User, Promoter, Administrator).
 */
public class UserTableManager {
    public void createUsersTable() throws TableManagerException {
        String sql = "CREATE TABLE IF NOT EXISTS USERS (" +
                     "id INTEGER IDENTITY, " +
                     "username VARCHAR(256) NOT NULL, " +
                     "password VARCHAR(256) NOT NULL, " +
                     "role VARCHAR(20) NOT NULL, " +
                     "location VARCHAR(255)" +
                     ")";
        try {
            DBManager.generateStatementEx(sql);
        } catch (DBManagerException e) {
            throw new TableManagerException("Error creating users table", e);
        }
    }
}

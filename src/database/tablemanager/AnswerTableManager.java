package database.tablemanager;

import database.DBManager;
import database.exception.DBManagerException;
import database.exception.TableManagerException;

/**
 * Creates the ANSWERS table.
 */
public class AnswerTableManager {
    public void createAnswersTable() throws TableManagerException {
        String sql = "CREATE TABLE IF NOT EXISTS ANSWERS (" +
                     "id INTEGER IDENTITY, " +
                     "question_id INTEGER NOT NULL, " +
                     "user_id INTEGER NOT NULL, " +
                     "rating INTEGER NOT NULL, " +
                     "answered_at TIMESTAMP" +
                     ")";
        try {
            DBManager.generateStatementEx(sql);
        } catch (DBManagerException e) {
            throw new TableManagerException("Error creating answers table", e);
        }
    }
}

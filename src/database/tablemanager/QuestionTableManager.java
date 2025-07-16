package database.tablemanager;

import database.DBManager;
import database.exception.DBManagerException;
import database.exception.TableManagerException;

/**
 * Creates the QUESTIONS table.
 */
public class QuestionTableManager {
    public void createQuestionsTable() throws TableManagerException {
        String sql = "CREATE TABLE IF NOT EXISTS QUESTIONS (" +
                     "id INTEGER IDENTITY, " +
                     "survey_id INTEGER NOT NULL, " +
                     "text VARCHAR(1024) NOT NULL" +
                     ")";
        try {
            DBManager.generateStatementEx(sql);
        } catch (DBManagerException e) {
            throw new TableManagerException("Error creating questions table", e);
        }
    }
}

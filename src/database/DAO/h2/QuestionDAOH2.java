package database.DAO.h2;

import database.DAO.QuestionDAO;
import database.DBManager;
import database.exception.DBManagerException;
import services.model.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAOH2 implements QuestionDAO {

    private static final String INSERT_SQL     = "INSERT INTO QUESTIONS (survey_id, text) VALUES (%d, '%s')";
    private static final String SELECT_BY_ID   = "SELECT * FROM QUESTIONS WHERE id = %d";
    private static final String SELECT_BY_SURV = "SELECT * FROM QUESTIONS WHERE survey_id = %d";
    private static final String SELECT_ALL     = "SELECT * FROM QUESTIONS";
    private static final String UPDATE_SQL     = "UPDATE QUESTIONS SET survey_id = %d, text = '%s' WHERE id = %d";
    private static final String DELETE_SQL     = "DELETE FROM QUESTIONS WHERE id = %d";

    @Override
    public Question create(Question q) throws DBManagerException {
        String sql = String.format(
            INSERT_SQL,
            q.getSurveyId(),
            q.getText().replace("'", "''")
        );
        DBManager.generateStatementExUpdate(sql);
        return q;
    }

    @Override
    public Question findById(Long id) throws DBManagerException {
        String sql = String.format(SELECT_BY_ID, id);
        ResultSet rs = DBManager.generateQuery(sql);
        try {
            if (rs.next()) {
                return mapRow(rs);
            }
        } catch (SQLException e) {
            throw new DBManagerException("Error reading question by ID", e);
        }
        return null;
    }

    @Override
    public List<Question> findBySurveyId(Long surveyId) throws DBManagerException {
        String sql = String.format(SELECT_BY_SURV, surveyId);
        ResultSet rs = DBManager.generateQuery(sql);
        List<Question> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            throw new DBManagerException("Error reading questions for survey", e);
        }
        return list;
    }

    @Override
    public List<Question> findAll() throws DBManagerException {
        String sql = SELECT_ALL;
        ResultSet rs = DBManager.generateQuery(sql);
        List<Question> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            throw new DBManagerException("Error reading all questions", e);
        }
        return list;
    }

    @Override
    public Question update(Question q) throws DBManagerException {
        String sql = String.format(
            UPDATE_SQL,
            q.getSurveyId(),
            q.getText().replace("'", "''"),
            q.getId()
        );
        DBManager.generateStatementExUpdate(sql);
        return q;
    }

    @Override
    public void delete(Long id) throws DBManagerException {
        String sql = String.format(DELETE_SQL, id);
        DBManager.generateStatementExUpdate(sql);
    }

    /** Mapea una fila del ResultSet a un objeto Question. */
    private Question mapRow(ResultSet rs) throws SQLException {
        Long   id       = rs.getLong("id");
        Long   surveyId = rs.getLong("survey_id");
        String text     = rs.getString("text");
        return new Question(id, surveyId, text);
    }
}

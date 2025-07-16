package database.DAO.h2;

import database.DAO.AnswerDAO;
import database.DBManager;
import database.exception.DBManagerException;
import services.model.Answer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * H2 implementation of AnswerDAO.
 */
public class AnswerDAOH2 implements AnswerDAO {
    private static final SimpleDateFormat DATE_FMT = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void create(Answer answer) throws DBManagerException {
        String sql = String.format(
            "INSERT INTO ANSWERS (question_id, user_id, rating, answeredAt) VALUES (%d, %d, %d, '%s')",
            answer.getQuestionId(),
            answer.getUserId(),
            answer.getRating(),
            DATE_FMT.format(answer.getAnsweredAt())
        );
        DBManager.generateStatementExUpdate(sql);
    }

    @Override
    public Answer findById(Long id) throws DBManagerException {
        String sql = "SELECT * FROM ANSWERS WHERE id = " + id;
        ResultSet rs = DBManager.generateQuery(sql);
        try {
            if (rs.next()) {
                return mapRow(rs);
            }
        } catch (SQLException e) {
            throw new DBManagerException("Error querying answer by ID", e);
        }
        return null;
    }

    @Override
    public List<Answer> findAll() throws DBManagerException {
        String sql = "SELECT * FROM ANSWERS";
        ResultSet rs = DBManager.generateQuery(sql);
        List<Answer> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            throw new DBManagerException("Error querying all answers", e);
        }
        return list;
    }

    @Override
    public List<Answer> findBySurveyAndDateRange(Long surveyId, Date from, Date to) throws DBManagerException {
        String sql = String.format(
            "SELECT a.* FROM ANSWERS a JOIN QUESTIONS q ON a.question_id = q.id " +
            "WHERE q.survey_id = %d AND a.answeredAt BETWEEN '%s' AND '%s'",
            surveyId,
            DATE_FMT.format(from),
            DATE_FMT.format(to)
        );
        ResultSet rs = DBManager.generateQuery(sql);
        List<Answer> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            throw new DBManagerException("Error querying answers by survey and date range", e);
        }
        return list;
    }

    @Override
    public List<Answer> findByUserId(Long userId) throws DBManagerException {
        String sql = "SELECT * FROM ANSWERS WHERE user_id = " + userId;
        ResultSet rs = DBManager.generateQuery(sql);
        List<Answer> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            throw new DBManagerException("Error querying answers by user ID", e);
        }
        return list;
    }

    @Override
    public Answer update(Answer answer) throws DBManagerException {
        String sql = String.format(
            "UPDATE ANSWERS SET question_id=%d, user_id=%d, rating=%d, answeredAt='%s' WHERE id = %d",
            answer.getQuestionId(),
            answer.getUserId(),
            answer.getRating(),
            DATE_FMT.format(answer.getAnsweredAt()),
            answer.getId()
        );
        DBManager.generateStatementExUpdate(sql);
        return answer;
    }

    @Override
    public void delete(Long id) throws DBManagerException {
        String sql = "DELETE FROM ANSWERS WHERE id = " + id;
        DBManager.generateStatementExUpdate(sql);
    }

    /** Mapea una fila del ResultSet a un objeto Answer. */
    private Answer mapRow(ResultSet rs) throws SQLException {
        Long   id         = rs.getLong("id");
        Long   questionId = rs.getLong("question_id");
        Long   userId     = rs.getLong("user_id");
        int    rating     = rs.getInt("rating");
        Date   answeredAt = rs.getDate("answeredAt");
        return new Answer(id, questionId, userId, rating, answeredAt);
    }
}

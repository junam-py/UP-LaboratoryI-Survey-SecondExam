package database.DAO.h2;

import database.DAO.SurveyDAO;
import services.model.Survey;
import database.DBManager;
import database.exception.DBManagerException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SurveyDAOH2 implements SurveyDAO {
    private static final String INSERT_SQL =
        "INSERT INTO surveys(title, description, created_at) VALUES('%s','%s','%s')";
    private static final String SELECT_BY_ID =
        "SELECT id, title, description, created_at FROM surveys WHERE id = %d";
    private static final String SELECT_ALL =
        "SELECT id, title, description, created_at FROM surveys";
    private static final String UPDATE_SQL =
        "UPDATE surveys SET title = '%s', description = '%s' WHERE id = %d";
    private static final String DELETE_SQL =
        "DELETE FROM surveys WHERE id = %d";

    @Override
    public Survey create(Survey survey) throws DBManagerException {
        String sql = String.format(
            INSERT_SQL,
            survey.getTitle().replace("'", "''"),
            survey.getDescription().replace("'", "''"),
            new Timestamp(survey.getCreatedAt().getTime())
        );
        DBManager.generateStatementEx(sql);
        return survey;
    }

    @Override
    public Survey findById(Long id) throws DBManagerException {
        String sql = String.format(SELECT_BY_ID, id);
        try {
            ResultSet rs = DBManager.generateQuery(sql);
            if (!rs.next()) return null;
            return new Survey(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getTimestamp("created_at"),
                null
            );
        } catch (SQLException e) {
            throw new DBManagerException("Error finding survey by ID", e);
        }
    }

    @Override
    public List<Survey> findAll() throws DBManagerException {
        String sql = SELECT_ALL;
        List<Survey> list = new ArrayList<>();
        try {
            ResultSet rs = DBManager.generateQuery(sql);
            while (rs.next()) {
                list.add(new Survey(
                    rs.getLong("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getTimestamp("created_at"),
                    null
                ));
            }
            return list;
        } catch (SQLException e) {
            throw new DBManagerException("Error listing surveys", e);
        }
    }

    @Override
    public Survey update(Survey survey) throws DBManagerException {
        String sql = String.format(
            UPDATE_SQL,
            survey.getTitle().replace("'", "''"),
            survey.getDescription().replace("'", "''"),
            survey.getId()
        );
        DBManager.generateStatementExUpdate(sql);
        return survey;
    }

    @Override
    public void delete(Long id) throws DBManagerException {
        String sql = String.format(DELETE_SQL, id);
        DBManager.generateStatementEx(sql);
    }
}

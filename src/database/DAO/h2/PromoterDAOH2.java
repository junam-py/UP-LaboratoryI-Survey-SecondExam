package database.DAO.h2;

import database.DAO.PromoterDAO;
import services.model.Promoter;
import database.DBManager;
import database.exception.DBManagerException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PromoterDAOH2 implements PromoterDAO {
    private static final String INSERT_SQL =
        "INSERT INTO users(username, password, role, location) VALUES('%s','%s','PROMOTER','%s')";
    private static final String SELECT_BY_ID =
        "SELECT id, username, password, role, location FROM users WHERE id = %d AND role = 'PROMOTER'";
    private static final String SELECT_ALL =
        "SELECT id, username, password, role, location FROM users WHERE role = 'PROMOTER'";
    private static final String UPDATE_SQL =
        "UPDATE users SET username = '%s', password = '%s', location = '%s' WHERE id = %d AND role = 'PROMOTER'";
    private static final String DELETE_SQL =
        "DELETE FROM users WHERE id = %d AND role = 'PROMOTER'";

    @Override
    public Promoter create(Promoter promoter) throws DBManagerException {
        String sql = String.format(
            INSERT_SQL,
            promoter.getUsername().replace("'", "''"),
            promoter.getPassword().replace("'", "''"),
            promoter.getLocation().replace("'", "''")
        );
        DBManager.generateStatementEx(sql);
        return promoter;
    }

    @Override
    public Promoter findById(Long id) throws DBManagerException {
        String sql = String.format(SELECT_BY_ID, id);
        try {
            ResultSet rs = DBManager.generateQuery(sql);
            if (!rs.next()) return null;
            return new Promoter(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("role"),
                rs.getString("location")
            );
        } catch (SQLException e) {
            throw new DBManagerException("Error finding promoter by ID", e);
        }
    }

    @Override
    public List<Promoter> findAll() throws DBManagerException {
        String sql = SELECT_ALL;
        List<Promoter> list = new ArrayList<>();
        try {
            ResultSet rs = DBManager.generateQuery(sql);
            while (rs.next()) {
                list.add(new Promoter(
                    rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role"),
                    rs.getString("location")
                ));
            }
            return list;
        } catch (SQLException e) {
            throw new DBManagerException("Error listing promoters", e);
        }
    }

    @Override
    public Promoter update(Promoter promoter) throws DBManagerException {
        String sql = String.format(
            UPDATE_SQL,
            promoter.getUsername().replace("'", "''"),
            promoter.getPassword().replace("'", "''"),
            promoter.getLocation().replace("'", "''"),
            promoter.getId()
        );
        DBManager.generateStatementExUpdate(sql);
        return promoter;
    }

    @Override
    public void delete(Long id) throws DBManagerException {
        String sql = String.format(DELETE_SQL, id);
        DBManager.generateStatementEx(sql);
    }
}

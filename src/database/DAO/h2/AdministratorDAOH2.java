package database.DAO.h2;

import database.DAO.AdministratorDAO;
import services.model.Administrator;
import database.DBManager;
import database.exception.DBManagerException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministratorDAOH2 implements AdministratorDAO {
    private static final String INSERT_SQL =
        "INSERT INTO users(username, password, role) VALUES('%s','%s','ADMIN')";
    private static final String SELECT_BY_ID =
        "SELECT id, username, password, role FROM users WHERE id = %d AND role = 'ADMIN'";
    private static final String SELECT_ALL =
        "SELECT id, username, password, role FROM users WHERE role = 'ADMIN'";
    private static final String UPDATE_SQL =
        "UPDATE users SET username = '%s', password = '%s' WHERE id = %d AND role = 'ADMIN'";
    private static final String DELETE_SQL =
        "DELETE FROM users WHERE id = %d AND role = 'ADMIN'";

    @Override
    public Administrator create(Administrator admin) throws DBManagerException {
        String sql = String.format(
            INSERT_SQL,
            admin.getUsername().replace("'", "''"),
            admin.getPassword().replace("'", "''")
        );
        DBManager.generateStatementEx(sql);
        return admin;
    }

    @Override
    public Administrator findById(Long id) throws DBManagerException {
        String sql = String.format(SELECT_BY_ID, id);
        try {
            ResultSet rs = DBManager.generateQuery(sql);
            if (!rs.next()) return null;
            return new Administrator(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("role")
            );
        } catch (SQLException e) {
            throw new DBManagerException("Error finding administrator by ID", e);
        }
    }

    @Override
    public List<Administrator> findAll() throws DBManagerException {
        String sql = SELECT_ALL;
        List<Administrator> list = new ArrayList<>();
        try {
            ResultSet rs = DBManager.generateQuery(sql);
            while (rs.next()) {
                list.add(new Administrator(
                    rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role")
                ));
            }
            return list;
        } catch (SQLException e) {
            throw new DBManagerException("Error listing administrators", e);
        }
    }

    @Override
    public Administrator update(Administrator admin) throws DBManagerException {
        String sql = String.format(
            UPDATE_SQL,
            admin.getUsername().replace("'", "''"),
            admin.getPassword().replace("'", "''"),
            admin.getId()
        );
        DBManager.generateStatementExUpdate(sql);
        return admin;
    }

    @Override
    public void delete(Long id) throws DBManagerException {
        String sql = String.format(DELETE_SQL, id);
        DBManager.generateStatementEx(sql);
    }
}

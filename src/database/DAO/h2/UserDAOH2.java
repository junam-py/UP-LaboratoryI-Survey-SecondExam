package database.DAO.h2;

import database.DAO.UserDAO;
import services.model.User;
import database.DBManager;
import database.exception.DBManagerException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOH2 implements UserDAO {
    private static final String INSERT_SQL =
        "INSERT INTO users(username, password, role) VALUES('%s','%s','%s')";
    private static final String SELECT_BY_ID =
        "SELECT id, username, password, role FROM users WHERE id = %d";
    private static final String SELECT_ALL =
        "SELECT id, username, password, role FROM users";
    private static final String UPDATE_SQL =
        "UPDATE users SET username = '%s', password = '%s', role = '%s' WHERE id = %d";
    private static final String DELETE_SQL =
        "DELETE FROM users WHERE id = %d";

    @Override
    public User create(User user) throws DBManagerException {
        String sql = String.format(
            INSERT_SQL,
            user.getUsername().replace("'", "''"),
            user.getPassword().replace("'", "''"),
            user.getRole()
        );
        DBManager.generateStatementEx(sql);
        return user;
    }

    @Override
    public User findById(Long id) throws DBManagerException {
        String sql = String.format(SELECT_BY_ID, id);
        try {
            ResultSet rs = DBManager.generateQuery(sql);
            if (!rs.next()) return null;
            return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("role")
            );
        } catch (SQLException e) {
            throw new DBManagerException("Error finding user by ID", e);
        }
    }

    @Override
    public List<User> findAll() throws DBManagerException {
        String sql = SELECT_ALL;
        List<User> list = new ArrayList<>();
        try {
            ResultSet rs = DBManager.generateQuery(sql);
            while (rs.next()) {
                list.add(new User(
                    rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role")
                ));
            }
            return list;
        } catch (SQLException e) {
            throw new DBManagerException("Error listing users", e);
        }
    }

    @Override
    public User update(User user) throws DBManagerException {
        String sql = String.format(
            UPDATE_SQL,
            user.getUsername().replace("'", "''"),
            user.getPassword().replace("'", "''"),
            user.getRole(),
            user.getId()
        );
        DBManager.generateStatementExUpdate(sql);
        return user;
    }

    @Override
    public void delete(Long id) throws DBManagerException {
        String sql = String.format(DELETE_SQL, id);
        DBManager.generateStatementEx(sql);
    }
}

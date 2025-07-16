package database.DAO;

import services.model.User;
import database.exception.DBManagerException;
import java.util.List;

/**
 * CRUD operations for User.
 */
public interface UserDAO {
    User create(User user) throws DBManagerException;
    User findById(Long id) throws DBManagerException;
    List<User> findAll() throws DBManagerException;
    User update(User user) throws DBManagerException;
    void delete(Long id) throws DBManagerException;
}

package database.DAO;

import services.model.Administrator;
import database.exception.DBManagerException;
import java.util.List;

/**
 * CRUD operations for Administrator.
 */
public interface AdministratorDAO {
    Administrator create(Administrator admin) throws DBManagerException;
    Administrator findById(Long id) throws DBManagerException;
    List<Administrator> findAll() throws DBManagerException;
    Administrator update(Administrator admin) throws DBManagerException;
    void delete(Long id) throws DBManagerException;
}

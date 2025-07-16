package database.DAO;

import services.model.Promoter;
import database.exception.DBManagerException;
import java.util.List;

/**
 * CRUD operations for Promoter.
 */
public interface PromoterDAO {
    Promoter create(Promoter promoter) throws DBManagerException;
    Promoter findById(Long id) throws DBManagerException;
    List<Promoter> findAll() throws DBManagerException;
    Promoter update(Promoter promoter) throws DBManagerException;
    void delete(Long id) throws DBManagerException;
}

package database.DAO;

import services.model.Survey;
import database.exception.DBManagerException;
import java.util.List;

/**
 * CRUD operations for Survey.
 */
public interface SurveyDAO {
    Survey create(Survey survey) throws DBManagerException;
    Survey findById(Long id) throws DBManagerException;
    List<Survey> findAll() throws DBManagerException;
    Survey update(Survey survey) throws DBManagerException;
    void delete(Long id) throws DBManagerException;
}

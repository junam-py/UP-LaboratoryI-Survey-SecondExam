package database.DAO;

import services.model.Question;
import database.exception.DBManagerException;
import java.util.List;

/**
 * CRUD operations for Question.
 */
public interface QuestionDAO {
    /** Inserta una nueva pregunta */
    Question create(Question question) throws DBManagerException;

    /** Busca una pregunta por su ID */
    Question findById(Long id) throws DBManagerException;

    /** Lista todas las preguntas de una encuesta */
    List<Question> findBySurveyId(Long surveyId) throws DBManagerException;

    /** Lista todas las preguntas */
    List<Question> findAll() throws DBManagerException;

    /** Actualiza una pregunta existente */
    Question update(Question question) throws DBManagerException;

    /** Elimina una pregunta por su ID */
    void delete(Long id) throws DBManagerException;
}

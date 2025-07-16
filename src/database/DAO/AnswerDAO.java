package database.DAO;

import services.model.Answer;
import database.exception.DBManagerException;
import java.util.Date;
import java.util.List;

/**
 * CRUD operations and summary for Answer.
 */
public interface AnswerDAO {
    /** Inserta una nueva respuesta */
    void create(Answer answer) throws DBManagerException;

    /** Busca una respuesta por su ID */
    Answer findById(Long id) throws DBManagerException;

    /** Lista todas las respuestas */
    List<Answer> findAll() throws DBManagerException;

    /** Busca todas las respuestas de una encuesta en un rango de fechas */
    List<Answer> findBySurveyAndDateRange(Long surveyId, Date from, Date to) throws DBManagerException;

    /** Busca todas las respuestas de un usuario */
    List<Answer> findByUserId(Long userId) throws DBManagerException;

    /** Actualiza una respuesta existente */
    Answer update(Answer answer) throws DBManagerException;

    /** Elimina una respuesta por su ID */
    void delete(Long id) throws DBManagerException;
}

package services;

import database.DAO.AnswerDAO;
import database.DAO.h2.AnswerDAOH2;
import database.exception.DBManagerException;
import services.exception.ServiceException;
import services.model.Answer;

import java.util.Date;
import java.util.List;

/**
 * Lógica de negocio para respuestas.
 */
public class AnswerService {
    private final AnswerDAO answerDAO;

    public AnswerService() {
        this.answerDAO = new AnswerDAOH2();
    }

    /**
     * Crea una nueva respuesta y la devuelve.
     */
    public Answer answerQuestion(Long questionId, Long userId, int rating, Date answeredAt)
            throws ServiceException {
        Answer a = new Answer(null, questionId, userId, rating, answeredAt);
        try {
            answerDAO.create(a);
            return a;
        } catch (DBManagerException e) {
            throw new ServiceException("Error creating answer", e);
        }
    }

    /**
     * Busca una respuesta por su ID.
     */
    public Answer findById(Long id) throws ServiceException {
        try {
            Answer a = answerDAO.findById(id);
            if (a == null) {
                throw new ServiceException("Answer not found: " + id);
            }
            return a;
        } catch (DBManagerException e) {
            throw new ServiceException("Error finding answer by ID", e);
        }
    }

    /**
     * Devuelve todas las respuestas.
     */
    public List<Answer> findAll() throws ServiceException {
        try {
            return answerDAO.findAll();
        } catch (DBManagerException e) {
            throw new ServiceException("Error fetching answers", e);
        }
    }

    /**
     * Busca respuestas por encuesta y rango de fechas.
     */
    public List<Answer> findBySurveyAndDateRange(Long surveyId, Date from, Date to)
            throws ServiceException {
        try {
            return answerDAO.findBySurveyAndDateRange(surveyId, from, to);
        } catch (DBManagerException e) {
            throw new ServiceException("Error fetching answers in date range", e);
        }
    }

    /**
     * Busca respuestas por usuario.
     */
    public List<Answer> findByUserId(Long userId) throws ServiceException {
        try {
            return answerDAO.findByUserId(userId);
        } catch (DBManagerException e) {
            throw new ServiceException("Error fetching answers by user ID", e);
        }
    }

    /**
     * Actualiza una respuesta existente.
     */
    public Answer updateAnswer(Answer answer) throws ServiceException {
        try {
            return answerDAO.update(answer);
        } catch (DBManagerException e) {
            throw new ServiceException("Error updating answer", e);
        }
    }

    /**
     * Elimina una respuesta por ID.
     */
    public void deleteAnswer(Long id) throws ServiceException {
        try {
            answerDAO.delete(id);
        } catch (DBManagerException e) {
            throw new ServiceException("Error deleting answer", e);
        }
    }
}

package services;

import database.DAO.QuestionDAO;
import database.DAO.h2.QuestionDAOH2;
import database.exception.DBManagerException;
import services.exception.ServiceException;
import services.model.Question;

import java.util.List;

public class QuestionService {
    private final QuestionDAO questionDAO;

    public QuestionService() {
        this.questionDAO = new QuestionDAOH2();
    }

    /**
     * Inserta una nueva pregunta.
     */
    public Question addQuestion(Question question) throws ServiceException {
        try {
            return questionDAO.create(question);
        } catch (DBManagerException e) {
            throw new ServiceException("Error creating question", e);
        }
    }

    /**
     * Actualiza una pregunta existente.
     */
    public Question updateQuestion(Question question) throws ServiceException {
        try {
            return questionDAO.update(question);
        } catch (DBManagerException e) {
            throw new ServiceException("Error updating question", e);
        }
    }

    /**
     * Obtiene todas las preguntas.
     */
    public List<Question> findAll() throws ServiceException {
        try {
            return questionDAO.findAll();
        } catch (DBManagerException e) {
            throw new ServiceException("Error fetching all questions", e);
        }
    }

    /**
     * Busca una pregunta por ID.
     */
    public Question findById(Long id) throws ServiceException {
        try {
            Question q = questionDAO.findById(id);
            if (q == null) {
                throw new ServiceException("Question not found: " + id);
            }
            return q;
        } catch (DBManagerException e) {
            throw new ServiceException("Error finding question by ID", e);
        }
    }

    /**
     * Elimina una pregunta por ID.
     */
    public void deleteQuestion(Long id) throws ServiceException {
        try {
            questionDAO.delete(id);
        } catch (DBManagerException e) {
            throw new ServiceException("Error deleting question", e);
        }
    }

    /**
     * Obtiene todas las preguntas de una encuesta dada.
     */
    public List<Question> findBySurveyId(Long surveyId) throws ServiceException {
        try {
            return questionDAO.findBySurveyId(surveyId);
        } catch (DBManagerException e) {
            throw new ServiceException("Error fetching questions for survey " + surveyId, e);
        }
    }
}

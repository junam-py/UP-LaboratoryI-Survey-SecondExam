package services;

import database.DAO.SurveyDAO;
import database.DAO.h2.SurveyDAOH2;
import database.exception.DBManagerException;
import services.exception.ServiceException;
import services.model.Survey;

import java.util.Date;
import java.util.List;

public class SurveyService {
    private final SurveyDAO surveyDAO;

    public SurveyService() {
        this.surveyDAO = new SurveyDAOH2();
    }

    public Survey createSurvey(Survey survey) throws ServiceException {
        try {
            return surveyDAO.create(survey);
        } catch (DBManagerException e) {
            throw new ServiceException("Error creating survey", e);
        }
    }

    public Survey updateSurvey(Survey survey) throws ServiceException {
        try {
            return surveyDAO.update(survey);
        } catch (DBManagerException e) {
            throw new ServiceException("Error updating survey", e);
        }
    }

    public List<Survey> findAll() throws ServiceException {
        try {
            return surveyDAO.findAll();
        } catch (DBManagerException e) {
            throw new ServiceException("Error fetching surveys", e);
        }
    }

    public Survey findById(Long id) throws ServiceException {
        try {
            Survey s = surveyDAO.findById(id);
            if (s == null) {
                throw new ServiceException("Survey not found: " + id);
            }
            return s;
        } catch (DBManagerException e) {
            throw new ServiceException("Error finding survey by ID", e);
        }
    }

    public void deleteSurvey(Long id) throws ServiceException {
        try {
            surveyDAO.delete(id);
        } catch (DBManagerException e) {
            throw new ServiceException("Error deleting survey", e);
        }
    }
}

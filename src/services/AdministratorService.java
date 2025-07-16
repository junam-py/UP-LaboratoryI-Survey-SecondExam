package services;

import database.DAO.AdministratorDAO;
import database.DAO.h2.AdministratorDAOH2;
import database.exception.DBManagerException;
import services.exception.ServiceException;
import services.model.Administrator;

import java.util.List;

public class AdministratorService {
    private final AdministratorDAO administratorDAO;

    public AdministratorService() {
        this.administratorDAO = new AdministratorDAOH2();
    }

    public Administrator register(Administrator admin) throws ServiceException {
        try {
            return administratorDAO.create(admin);
        } catch (DBManagerException e) {
            throw new ServiceException("Error creating administrator", e);
        }
    }

    public Administrator updateAdministrator(Administrator admin) throws ServiceException {
        try {
            return administratorDAO.update(admin);
        } catch (DBManagerException e) {
            throw new ServiceException("Error updating administrator", e);
        }
    }

    public List<Administrator> findAll() throws ServiceException {
        try {
            return administratorDAO.findAll();
        } catch (DBManagerException e) {
            throw new ServiceException("Error fetching administrators", e);
        }
    }

    public Administrator findById(Long id) throws ServiceException {
        try {
            Administrator a = administratorDAO.findById(id);
            if (a == null) {
                throw new ServiceException("Administrator not found: " + id);
            }
            return a;
        } catch (DBManagerException e) {
            throw new ServiceException("Error finding administrator by ID", e);
        }
    }

    public void deleteAdministrator(Long id) throws ServiceException {
        try {
            administratorDAO.delete(id);
        } catch (DBManagerException e) {
            throw new ServiceException("Error deleting administrator", e);
        }
    }
}

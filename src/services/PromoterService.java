package services;

import database.DAO.PromoterDAO;
import database.DAO.h2.PromoterDAOH2;
import database.exception.DBManagerException;
import services.exception.ServiceException;
import services.model.Promoter;

import java.util.List;

public class PromoterService {
    private final PromoterDAO promoterDAO;

    public PromoterService() {
        this.promoterDAO = new PromoterDAOH2();
    }

    public Promoter createPromoter(Promoter promoter) throws ServiceException {
        try {
            return promoterDAO.create(promoter);
        } catch (DBManagerException e) {
            throw new ServiceException("Error creating promoter", e);
        }
    }

    public Promoter updatePromoter(Promoter promoter) throws ServiceException {
        try {
            return promoterDAO.update(promoter);
        } catch (DBManagerException e) {
            throw new ServiceException("Error updating promoter", e);
        }
    }

    public List<Promoter> findAll() throws ServiceException {
        try {
            return promoterDAO.findAll();
        } catch (DBManagerException e) {
            throw new ServiceException("Error fetching promoters", e);
        }
    }

    public Promoter findById(Long id) throws ServiceException {
        try {
            Promoter p = promoterDAO.findById(id);
            if (p == null) {
                throw new ServiceException("Promoter not found: " + id);
            }
            return p;
        } catch (DBManagerException e) {
            throw new ServiceException("Error finding promoter by ID", e);
        }
    }

    public void deletePromoter(Long id) throws ServiceException {
        try {
            promoterDAO.delete(id);
        } catch (DBManagerException e) {
            throw new ServiceException("Error deleting promoter", e);
        }
    }
}

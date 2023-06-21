package services;

import java.util.ArrayList;

import database.DAO.PromoterDAO;
import database.DAO.h2.PromoterDAOH2;
import database.exception.DAOException;
import services.exception.ServiceException;
import services.model.Promoter;

public class PromoterService {

    private final PromoterDAO promoterDAO;

    public PromoterService() {
        promoterDAO = new PromoterDAOH2();
    }

    /** 
     * @param promoter to obtain
     * @return Promoter obtained
     * @throws ServiceException in case of error obtaining promoter
     */
    public Promoter obtainPromoter(Promoter promoter) throws ServiceException {
        try {
            Promoter promoterFounded = promoterDAO.showPromoter(promoter);
            return promoterFounded;
        } catch(DAOException e) {
            throw new ServiceException(e);
        }
    }

    /** 
     * @return ArrayList<Promoter> obtained
     * @throws ServiceException in case of error obtaining promoters
     */
    public ArrayList<Promoter> obtainPromoters() throws ServiceException {
        ArrayList<Promoter> promotersDB = null;
        try {
            promotersDB = promoterDAO.listPromoters();
        } catch(DAOException e) {
            throw new ServiceException(e);
        }
        return promotersDB;
    }

    /** 
     * @param promoter to create
     * @throws ServiceException in case of error creating promoter
     */
    public void createPromoter(Promoter promoter) throws ServiceException {
        try {
            promoterDAO.createPromoter(promoter);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
    
    /** 
     * @param promoter to update
     * @throws ServiceException in case of error updating promoter
     */
    public void updatePromoter(Promoter promoter) throws ServiceException {
        try {
            promoterDAO.updatePromoter(promoter);
        } catch(DAOException e) {
            throw new ServiceException(e);
        }
    }
    
    /** 
     * @param promoter to delete
     * @throws ServiceException in case of error deleting promoter
     */
    public void deletePromoter(Promoter promoter) throws ServiceException {
        try {
            promoterDAO.deletePromoter(promoter);
        } catch(DAOException e) {
            throw new ServiceException(e);
        }
    }

}
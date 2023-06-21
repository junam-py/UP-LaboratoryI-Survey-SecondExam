package database.DAO;

import java.util.ArrayList;

import database.exception.DAOException;

import services.model.Promoter;

/**
* @see PromoterDAOH2.java file
*/

public interface PromoterDAO {

    void createPromoter(Promoter promoter) throws DAOException;
    void deletePromoter(Promoter promoter) throws DAOException;
    void updatePromoter(Promoter promoter) throws DAOException;
    Promoter showPromoter(Promoter promoter) throws DAOException;
    ArrayList<Promoter> listPromoters() throws DAOException;
    
}

package database.DAO;

import java.util.List;

import database.exception.DAOException;

import services.Promoter;

public interface PromoterDAO { // methods implemented in PromoterDAOH2
    void createPromoter(Promoter promoter) throws DAOException;
    void deletePromoter(Promoter promoter) throws DAOException;
    void updatePromoter(Promoter promoter) throws DAOException;
    Promoter showPromoter(Promoter promoter) throws DAOException;
    List<Promoter> listPromoters() throws DAOException;
}

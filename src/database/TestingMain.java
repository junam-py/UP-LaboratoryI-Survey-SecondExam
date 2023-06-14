package database;

import java.util.List;

import database.DAO.PromoterDAO;
import database.DAO.h2.PromoterDAOH2;
import database.exception.DAOException;
import database.exception.TableManagerException;
import database.tablemanager.PromoterTableManager;
import services.Promoter;

public class TestingMain {
    public static void main(String[] args) {
        // Genero tabla de promotores
        PromoterTableManager ptm = new PromoterTableManager();
        try {
            ptm.createPromoterTable();
        } catch (TableManagerException e) {
            System.out.println(e.getMessage());
        }

        PromoterDAO dao = new PromoterDAOH2();

        // Agrego 2 promotores
        Promoter p = new Promoter(0, "Juan", "Garcia", "unmailrandom@nose.com", 20);
        try {
            dao.createPromoter(p);
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }

        Promoter p2 = new Promoter(1, "Manuel", "Gimenez", "otromailrandom@nose.com", 04);
        try {
            dao.createPromoter(p2);
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }

        Promoter p3 = new Promoter(2, "Agustin", "Gonzalez", "otromailrandom@nose.com", 23);
        try {
            dao.createPromoter(p3);
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }

        // Muestro un promotor
        try {
            Promoter show = dao.showPromoter(p);
            System.out.println(show.getName() + " " + show.getSecondName());
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }

        // Modifico un promotor
        p2.setAge(40);
        try {
            dao.updatePromoter(p2);
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }

        // Elimino un promotor
        try {
            dao.deletePromoter(p);
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }

        // Imprimo todos los promotores
        try {
            List<Promoter> ls = dao.listPromoters();
            Promoter show = null;
            for (int i = 0; i < ls.size(); i++) {
                show = ls.get(i);
                System.out.println(show.getName() + " " + show.getSecondName());
            }
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }

        // Elimino tabla de promotores
        try {
            ptm.deletePromoterTable();
        } catch (TableManagerException e) {
            System.out.println(e.getMessage());
        }
    }
}

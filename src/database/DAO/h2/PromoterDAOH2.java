package database.DAO.h2;

/** 
 * Importing Java SQL Packages
*/
import java.sql.ResultSet;
import java.sql.SQLException;

/** 
 * Importing Util Packages
*/
import java.util.ArrayList;
import java.util.List;

/**
 * Importing DB Packages 
 */
import database.DBManager;
import database.DAO.PromoterDAO;

/**
 * Importing Exceptions Packages
 */
import database.exception.DAOException;
import database.exception.DBManagerException;

/**
 * Importing Services Packages
 */
import services.Promoter;

public class PromoterDAOH2 implements PromoterDAO {

    /**
     * @param promoter to create
     * @throws DAOException in case of error creating promoter
     */
    @Override
    public void createPromoter(Promoter promoter) throws DAOException {
        // SQL format be like: "INSERT INTO PROMOTERS (id, name, secondname, email, age)
        // VALUES (ID, 'name', 'secondname', 'email', age)"
        String sql = "INSERT INTO PROMOTERS (id, name, secondname, email, age) VALUES (" + promoter.getID() + ", '"
                + promoter.getName() + "', '" + promoter.getSecondName() + "', '" + promoter.getEmail() + "', "
                + promoter.getAge() + ")";
        try {
            DBManager.generateStatementExUpdate(sql);
        } catch (DBManagerException e) {
            throw new DAOException("Error creating promoter");
        }
    }

    /**
     * @param promoter to delete
     * @throws DAOException in case of error deleting promoter
     */
    @Override
    public void deletePromoter(Promoter promoter) throws DAOException {
        // SQL format be like: "DELETE FROM PROMOTERS WHERE id = ID"
        String sql = "DELETE FROM PROMOTERS WHERE id = " + promoter.getID();
        try {
            DBManager.generateStatementEx(sql);
        } catch (DBManagerException e) {
            throw new DAOException("Error deleting promoter");
        }
    }

    /**
     * @param promoter to update
     * @throws DAOException in case of error updating promoter
     */
    @Override
    public void updatePromoter(Promoter promoter) throws DAOException {
        // SQL format be like: "UPDATE PROMOTERS SET name = 'name', secondname =
        // 'secondname', email = 'email', age = age WHERE id = id"
        String sql = "UPDATE PROMOTERS SET name = '" + promoter.getName() + "', secondname = '"
                + promoter.getSecondName() + "', email = '" + promoter.getEmail() + "', age = " + promoter.getAge()
                + " WHERE id = " + promoter.getID() + "";
        try {
            DBManager.generateStatementEx(sql);
        } catch (DBManagerException e) {
            throw new DAOException("Error updating promoter");
        }
    }

    /**
     * @param promoter to show
     * @return Promoter to show, or null
     * @throws DAOException in case of error getting promoter
     */
    @Override
    public Promoter showPromoter(Promoter promoter) throws DAOException {
        // SQL format be like: "SELECT * FROM PROMOTERS WHERE name = 'name'"
        String sql = "SELECT * FROM PROMOTERS WHERE name = '" + promoter.getName() + "'";
        try {
            ResultSet rs = DBManager.generateQuery(sql);
            if (rs.next()) { // if there is next row (!= null)...
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String secondName = rs.getString("secondname");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                Promoter newPromoter = new Promoter(id, name, secondName, email, age);
                return newPromoter;
            }
        } catch (DBManagerException e) { // from generateQuery
            throw new DAOException("Error showing promoter");
        } catch (SQLException e) { // from rs.next()
            throw new DAOException("Error showing promoter");
        }
        return null;
    }

    /**
     * @return List<Promoter> all the promoters founded in DB
     * @throws DAOException in case of error getting promoter
     */
    public List<Promoter> listPromoters() throws DAOException {
        List<Promoter> resul = new ArrayList<>();
        String sql = "SELECT * from promoters";
        try {
            ResultSet rs = DBManager.generateQuery(sql);
            while (rs.next()) { // if there is next row (!= null)...
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String secondName = rs.getString("secondname");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                Promoter newPromoter = new Promoter(id, name, secondName, email, age);
                resul.add(newPromoter);
            }
        } catch (DBManagerException e) { // from generateQuery
            throw new DAOException("Error getting promoters list");
        } catch (SQLException e) { // from rs.next()
            throw new DAOException("Error getting promoters list");
        }
        return resul;
    }
}

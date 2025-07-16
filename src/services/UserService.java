package services;

import database.DAO.UserDAO;
import database.DAO.h2.UserDAOH2;
import database.exception.DBManagerException;
import services.exception.ServiceException;
import services.model.User;

import java.util.List;

public class UserService {
    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAOH2();
    }

    public User createUser(User user) throws ServiceException {
        try {
            return userDAO.create(user);
        } catch (DBManagerException e) {
            throw new ServiceException("Error creating user", e);
        }
    }

    public User updateUser(User user) throws ServiceException {
        try {
            return userDAO.update(user);
        } catch (DBManagerException e) {
            throw new ServiceException("Error updating user", e);
        }
    }

    public List<User> findAll() throws ServiceException {
        try {
            return userDAO.findAll();
        } catch (DBManagerException e) {
            throw new ServiceException("Error fetching users", e);
        }
    }

    public User findById(Long id) throws ServiceException {
        try {
            User u = userDAO.findById(id);
            if (u == null) {
                throw new ServiceException("User not found: " + id);
            }
            return u;
        } catch (DBManagerException e) {
            throw new ServiceException("Error finding user by ID", e);
        }
    }

    public void deleteUser(Long id) throws ServiceException {
        try {
            userDAO.delete(id);
        } catch (DBManagerException e) {
            throw new ServiceException("Error deleting user", e);
        }
    }
}

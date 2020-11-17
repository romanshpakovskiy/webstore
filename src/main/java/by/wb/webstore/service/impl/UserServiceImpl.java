package by.wb.webstore.service.impl;

import by.wb.webstore.bean.User;
import by.wb.webstore.dao.DAOException;
import by.wb.webstore.dao.UserDAO;
import by.wb.webstore.dao.factoryDAO.DAOFactory;
import by.wb.webstore.service.ServiceException;
import by.wb.webstore.service.UserService;
import by.wb.webstore.service.Validator;

public class UserServiceImpl implements UserService {
    @Override
    public User signIn(String email, String password) throws ServiceException {
        Validator validator = new Validator();
/*        if (!validator.checkEmailValidation(email) || !validator.checkPasswordValidation(password))
            throw new ServiceException("Invalid email or password");*/
        UserDAO userDAO = DAOFactory.INSTANCE.getUserDAO();
        try {
            return userDAO.signIn(email, password);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public User registration(User user) throws ServiceException {
        UserDAO userDAO = DAOFactory.INSTANCE.getUserDAO();
        try {
            return userDAO.registration(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteUser(int userId, String password) {
        return false;
    }

    @Override
    public boolean changePassword(int userId, String oldPassword, String newPassword) {
        return false;
    }

   /* @Override
    public User getRegistrationData(int userId) throws ServiceException {
        try {
            return userDAO.getRegistrationData(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }*/
}

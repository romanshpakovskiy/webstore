package by.wb.webstore.service.impl;

import by.wb.webstore.bean.User;
import by.wb.webstore.dao.DAOException;
import by.wb.webstore.dao.UserDAO;
import by.wb.webstore.dao.factoryDAO.DAOFactory;
import by.wb.webstore.service.ServiceException;
import by.wb.webstore.service.UserService;
import by.wb.webstore.service.Validator;

public class UserServiceImpl implements UserService {
    private final UserDAO userDAO = DAOFactory.INSTANCE.getUserDAO();
    Validator validator = new Validator();

    @Override
    public boolean signIn(String email, String password) throws ServiceException {
        if(!validator.checkEmailValidation(email) && !validator.checkPasswordValidation(password))
            throw new ServiceException("Invalid email or password");
        try {
            return userDAO.signIn(email, password);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean checkEmailAccessibility(String email) {
        return false;
    }

    @Override
    public boolean registration(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(int userId, String password) {
        return false;
    }

    @Override
    public boolean changePassword(int userId, String oldPassword, String newPassword) {
        return false;
    }
}

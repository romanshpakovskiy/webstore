package by.wb.webstore.service.impl;

import by.wb.webstore.bean.User;
import by.wb.webstore.dao.DAOException;
import by.wb.webstore.dao.UserDAO;
import by.wb.webstore.dao.factoryDAO.connectionpool.ConnectionPoolException;
import by.wb.webstore.dao.factoryDAO.DAOFactory;
import by.wb.webstore.service.ServiceException;
import by.wb.webstore.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private final UserDAO userDAO = DAOFactory.INSTANCE.getUserDAO();

    @Override
    public boolean signIn(String login, String password) throws ServiceException {
        try {
            return userDAO.signIn(login, password);
        } catch (ConnectionPoolException | SQLException | DAOException e) {
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

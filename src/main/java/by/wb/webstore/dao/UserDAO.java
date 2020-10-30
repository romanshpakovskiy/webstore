package by.wb.webstore.dao;

import by.wb.webstore.bean.User;
import by.wb.webstore.dao.factoryDAO.connectionpool.ConnectionPoolException;

import java.sql.SQLException;

public interface UserDAO {
    boolean signIn(String login, String password) throws ConnectionPoolException, SQLException, DAOException;

    boolean checkEmailAccessibility(String email) throws DAOException;

    boolean registration(User user) throws DAOException, SQLException;

    boolean deleteUser(int userId, String password) throws DAOException;

    boolean changePassword(int userId, String oldPassword, String newPassword) throws DAOException;
}

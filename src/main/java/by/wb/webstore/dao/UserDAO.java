package by.wb.webstore.dao;

import by.wb.webstore.bean.User;

public interface UserDAO {
    User signIn(String login, String password) throws DAOException;

    User registration(User user) throws DAOException;

    boolean deleteUser(int userId, String password) throws DAOException;

    boolean changePassword(int userId, String oldPassword, String newPassword) throws DAOException;

//    User getRegistrationData(int userId) throws DAOException;
}

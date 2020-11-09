package by.wb.webstore.dao;

import by.wb.webstore.bean.User;

import java.sql.Connection;

public interface UserDAO {
    User signIn(String login, String password) throws DAOException;

    User registration(User user, int roleId) throws DAOException;

    boolean deleteUser(int userId, String password) throws DAOException;

    boolean changePassword(int userId, String oldPassword, String newPassword) throws DAOException;

//    User getRegistrationData(int userId) throws DAOException;
}

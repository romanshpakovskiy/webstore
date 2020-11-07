package by.wb.webstore.dao;

import by.wb.webstore.bean.User;

public interface UserDAO {
    boolean signIn(String login, String password) throws DAOException;

    boolean checkEmailAccessibility(String email) throws DAOException;

    boolean registration(User user) throws DAOException;

    boolean deleteUser(int userId, String password) throws DAOException;

    boolean changePassword(int userId, String oldPassword, String newPassword) throws DAOException;

    User getRegistrationData(int userId) throws DAOException;
}

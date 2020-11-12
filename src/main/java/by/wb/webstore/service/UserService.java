package by.wb.webstore.service;

import by.wb.webstore.bean.User;

public interface UserService {
    User signIn(String login, String password) throws ServiceException;

    User registration(User user) throws ServiceException;

    boolean deleteUser(int userId, String password);

    boolean changePassword(int userId, String oldPassword, String newPassword);

//    User getRegistrationData(int userId) throws ServiceException;
}

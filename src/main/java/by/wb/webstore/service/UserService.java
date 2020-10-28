package by.wb.webstore.service;

import by.wb.webstore.bean.User;

public interface UserService {
    boolean signIn(String login, String password) throws ServiceException;

    boolean checkEmailAccessibility(String email);

    boolean registration(User user);

    boolean deleteUser(int userId, String password);

    boolean changePassword(int userId, String oldPassword, String newPassword);
}

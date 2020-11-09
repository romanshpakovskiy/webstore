package by.wb.webstore.dao.impl;

import by.wb.webstore.bean.User;
import by.wb.webstore.dao.DAOException;
import by.wb.webstore.dao.UserDAO;
import by.wb.webstore.dao.impl.connectionpool.ConnectionPool;
import by.wb.webstore.dao.impl.connectionpool.ConnectionPoolException;

import java.sql.*;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String SIGN_IN_QUERY = "SELECT * FROM users WHERE  email=? AND password=?";
    private static final String DELETE_QUERY = "DELETE * FROM users WHERE id=? AND password=?";
    private static final String CHANGE_PASSWORD_QUERY = "UPDATE users SET password=? WHERE password=? AND id=?";
    private static final String GET_REGISTRATION_DATA_QUERY = "SELECT name, surname, email, password, address FROM users WHERE id=?";
    private static final String GET_ROLE_QUERY = "SELECT";
    private static final String REGISTRATION_QUERY = "INSERT INTO users(name,surname,email,password,address,role_id) VALUES(?,?,?,?,?,?)";
    private static final String CHECK_EMAIL_ACCESSIBILITY_QUERY = "SELECT email FROM users WHERE email=?";

    @Override
    public User signIn(String email, String password) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = (PreparedStatement) connection.createStatement();
            resultSet = preparedStatement.executeQuery(SIGN_IN_QUERY);

            if (!resultSet.next()) {
                return null;
            }

            User user = new User();
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            return user;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException("Incorrect email or password");
        }
    }

    @Override
    public User registration(User user, int roleId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = (PreparedStatement) connection.createStatement();

            if (checkEmailAccessibility(user.getEmail(), connection))
                return null;

            resultSet = preparedStatement.executeQuery(REGISTRATION_QUERY);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setInt(6, roleId);

            int updatedRows = preparedStatement.executeUpdate();

            if (updatedRows == 0 & !resultSet.next())
                throw new DAOException("Registration Error");
            return user;
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException(e);
        } finally {
            if (resultSet != null) {
                connectionPool.closeConnection(connection, preparedStatement, resultSet);
            }
        }
    }

    private boolean checkEmailAccessibility(String email, Connection connection) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(CHECK_EMAIL_ACCESSIBILITY_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
                return false;
            return email.equals(resultSet.getString(1));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean deleteUser(int userId, String password) {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = (PreparedStatement) connection.createStatement();
            resultSet = preparedStatement.executeQuery(DELETE_QUERY);

        } catch (ConnectionPoolException | SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean changePassword(int userId, String oldPassword, String newPassword) {
        Connection connection;
        PreparedStatement preparedStatement;
//            try {
//                connection=connectionPool.takeConnection();
//                //preparedStatement= (PreparedStatement) connection.createStatement(CHANGE_PASSWORD_QUERY);//
//
//            } catch (ConnectionPoolException | SQLException e) {
//                e.printStackTrace();
//            }
        return false;
    }

   /* @Override
    public User getRegistrationData(int userId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = (PreparedStatement) connection.createStatement();
            resultSet = preparedStatement.executeQuery(GET_REGISTRATION_DATA_QUERY);
            User user = new User();
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setEmail(resultSet.getString("email"));
            user.setAddress(resultSet.getString("address"));
            user.setRoleId(resultSet.getInt("role_id"));
            return user;
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection, preparedStatement, resultSet);
        }
    }*/

    /*private List<Role> getUserRole(int roleId, Connection connection) {
        List<Role> roleList = new ArrayList<>();
        try (Statement statement = connection.createStatement())
    }*/
}
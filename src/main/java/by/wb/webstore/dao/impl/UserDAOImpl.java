package by.wb.webstore.dao.impl;

import by.wb.webstore.bean.User;
import by.wb.webstore.dao.DAOException;
import by.wb.webstore.dao.UserDAO;
import by.wb.webstore.dao.impl.connectionpool.ConnectionPool;
import by.wb.webstore.dao.impl.connectionpool.ConnectionPoolException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String SIGN_IN_QUERY = "SELECT * FROM users WHERE  email=? AND password=?";
    private static final String DELETE_QUERY="DELETE * FROM users WHERE id=? AND password=?";
    private static final String CHANGE_PASSWORD_QUERY="UPDATE users SET password=? WHERE password=? AND id=?";

    @Override
    public boolean signIn(String email, String password) throws ConnectionPoolException, DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = (PreparedStatement) connection.createStatement();
            resultSet = preparedStatement.executeQuery(SIGN_IN_QUERY);
            if (!resultSet.next()) {
                return false;
            }
            User user = new User();
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setAddress(resultSet.getString("address"));
            user.setRoleId(resultSet.getInt("role_id"));
            return true;
        } catch (SQLException e) {
            throw new DAOException("Incorrect email or password");
        } finally {

        }
    }

    @Override
    public boolean checkEmailAccessibility(String email) {

        String query="SELECT email FROM users WHERE email=?";
        return false;
    }

    @Override
    public boolean registration(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User usr;
        try {
            String query="INSERT INTO users(name,surname,email,password,address,role_id) VALUES(?,?,?,?,?,?)";
            connection=connectionPool.takeConnection();
            usr=new User();
            preparedStatement= (PreparedStatement) connection.createStatement();
            resultSet=preparedStatement.executeQuery(query);
            usr.setName(resultSet.getString("name"));
            usr.setSurname(resultSet.getString("surname"));
            usr.setEmail(resultSet.getString("email"));
            usr.setAddress(resultSet.getString("address"));
            usr.setRoleId(resultSet.getInt("role_id"));
            return true;
        } catch (ConnectionPoolException | SQLException e) {
            System.out.println(e);
        } finally {
            if (resultSet != null) {
                connectionPool.closeConnection(connection,preparedStatement,resultSet);
            }
        }
        return false;
    }

    @Override
    public boolean deleteUser(int userId, String password) {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            connection=connectionPool.takeConnection();
            preparedStatement= (PreparedStatement) connection.createStatement();
            resultSet=preparedStatement.executeQuery(DELETE_QUERY);

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
}
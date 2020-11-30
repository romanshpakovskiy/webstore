package by.wb.webstore.dao.impl;

import by.wb.webstore.bean.Category;
import by.wb.webstore.dao.CategoryDAO;
import by.wb.webstore.dao.DAOException;
import by.wb.webstore.dao.impl.connectionpool.ConnectionPool;
import by.wb.webstore.dao.impl.connectionpool.ConnectionPoolException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String GET_CATEGORIES_QUERY = "SELECT * FROM categories";
    private static final String GET_CATEGORY_QUERY = "SELECT * FROM categories WHERE id=?";

    @Override
    public void addCategory(Category category) {

    }

    @Override
    public void deleteCategory(Category category) {

    }

    @Override
    public Category getCategory(int categoryId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(GET_CATEGORY_QUERY);
            preparedStatement.setInt(1, categoryId);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                return null;
            }

            return new Category(categoryId, resultSet.getString("name"));
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public List<Category> getCategories() throws DAOException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_CATEGORIES_QUERY);
            List<Category> categoriesList = new ArrayList<>();
            while (resultSet.next()) {
                categoriesList.add(new Category(resultSet.getInt("id"),
                        resultSet.getString("name")));
            }
            return categoriesList;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException("Getting categories error", e);
        } finally {
            if (resultSet != null) {
                connectionPool.closeConnection(connection, statement, resultSet);
            }
        }
    }
}
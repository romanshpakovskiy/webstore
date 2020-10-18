package by.wb.webstore.dao.impl;

import by.wb.webstore.bean.Category;
import by.wb.webstore.dao.CategoryDAO;
import by.wb.webstore.dao.DAOException;
import by.wb.webstore.dao.connectionpool.ConnectionPool;
import by.wb.webstore.dao.connectionpool.ConnectionPoolException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String GET_CATEGORIES="SELECT * FROM categories";

    @Override
    public void addCategory(Category category) {

    }

    @Override
    public void deleteCategory(Category category) {

    }

    @Override
    public List<Category> getCategories() throws DAOException, SQLException {
        Connection connection = null;
        Statement statement=null;
        ResultSet resultSet=null;
        try{
            connection=connectionPool.takeConnection();
            statement= connection.createStatement();
            resultSet=statement.executeQuery(GET_CATEGORIES);
            List<Category> categoriesList=new ArrayList<>();
            if(!resultSet.next())
                return null;
            categoriesList.add(new Category(resultSet.getInt("id"),
                    resultSet.getString("name")));
            return categoriesList;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException("Getting categories error");
        } finally {
            if (resultSet!=null) {
                connectionPool.closeConnection(connection, statement, resultSet);
            }
        }
    }
}

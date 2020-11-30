package by.wb.webstore.dao.impl;

import by.wb.webstore.bean.Product;
import by.wb.webstore.dao.DAOException;
import by.wb.webstore.dao.ProductDAO;
import by.wb.webstore.dao.impl.connectionpool.ConnectionPool;
import by.wb.webstore.dao.impl.connectionpool.ConnectionPoolException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    public static final String ADD_PRODUCT_QUERY = "INSERT INTO products(id,name,price,category_id,count,specification) VALUES(?,?,?,?,?,?)";
    public static final String GET_PROD_QUERY = "SELECT * FROM products WHERE id=?";
    private static final String GET_PROD_BY_CATEGORY_QUERY = "SELECT * FROM products WHERE category_id=?";
    private static final String GET_PRODUCTS_QUERY = "SELECT * FROM products";

    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public boolean addProductsInBasket(Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(long idProduct) {
        return false;
    }

    @Override
    public boolean deleteProductFromBasket(int productId, int userId) {
        return false;
    }

    @Override
    public Product getProduct(int productId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(GET_PROD_QUERY);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                return null;
            }

            return new Product(productId, resultSet.getString("name"), resultSet.getDouble("price"),
                    resultSet.getInt("categoryId"), resultSet.getInt("count"), resultSet.getString("specification"));
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public List<Product> getProductsByCategory(int categoryId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(GET_PROD_BY_CATEGORY_QUERY);

            preparedStatement.setInt(1, categoryId);

            resultSet = preparedStatement.executeQuery();

            List<Product> productList = new ArrayList<>();

            while (resultSet.next())
                productList.add(new Product(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getDouble("price"), categoryId, resultSet.getInt("count"),
                        resultSet.getString("specification")));

            return productList;
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException("Getting products exception");
        } finally {
            connectionPool.closeConnection(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public List<Product> getProducts() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(GET_PRODUCTS_QUERY);
            resultSet = preparedStatement.executeQuery();

            List<Product> productList = new ArrayList<>();

            while (resultSet.next())
                productList.add(new Product(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getDouble("price"), resultSet.getInt("category_id"),
                        resultSet.getInt("count"), resultSet.getString("specification")));

            return productList;
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException("Getting products exception");
        } finally {
            connectionPool.closeConnection(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public List<Product> getProductsFromBasket(int userId) {
        return null;
    }
}
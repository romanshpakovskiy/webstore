package by.wb.webstore.dao.impl;

import by.wb.webstore.bean.BasketAttributes;
import by.wb.webstore.bean.Product;
import by.wb.webstore.dao.DAOException;
import by.wb.webstore.dao.ProductDAO;
import by.wb.webstore.dao.impl.connectionpool.ConnectionPool;
import by.wb.webstore.dao.impl.connectionpool.ConnectionPoolException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ProductDAOImpl implements ProductDAO {
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    public static final String GET_PROD_QUERY = "SELECT * FROM products WHERE id=?";
    private static final String GET_PROD_BY_CATEGORY_QUERY = "SELECT * FROM products WHERE category_id=?";
    private static final String GET_PRODUCTS_QUERY = "SELECT * FROM products";
    private static final String ADD_PRODUCT_IN_BASKET_QUERY = "INSERT INTO baskets (user_id, product_id, count) VALUES (?,?,?)";
    private static final String GET_PRODUCTS_FROM_BASKET_QUERY = "SELECT id, name, price, baskets.count, specification, baskets " +
            "FROM products JOIN baskets ON products.id=baskets.products_id WHERE baskets.user_id=?";

    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public boolean addProductsInBasket(int userId, int productId, int count) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(ADD_PRODUCT_IN_BASKET_QUERY);

            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, productId);
            preparedStatement.setInt(3, count);

            return preparedStatement.executeUpdate() != 0;
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection, preparedStatement);
        }
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

            preparedStatement.setInt(1, productId);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                return null;
            }

            return new Product(productId, resultSet.getString("name"), resultSet.getDouble("price"),
                    resultSet.getInt("category_id"), resultSet.getInt("count"), resultSet.getString("specification"));
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
                        resultSet.getInt("count"),
                        resultSet.getString("specification")));
            return productList;
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException("Getting products exception");
        } finally {
            connectionPool.closeConnection(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public List<BasketAttributes> getProductsFromBasket(int userId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rS = null;
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(GET_PRODUCTS_FROM_BASKET_QUERY);
            preparedStatement.setInt(1, userId);
            rS = preparedStatement.executeQuery();

            List<BasketAttributes> prodAttrList = new ArrayList<>();

            while (rS.next()) {
                prodAttrList.add(new BasketAttributes(rS.getInt("id"), rS.getString("name"),
                        rS.getDouble("price"), rS.getInt("count"), rS.getString("specification")));
            }
            return prodAttrList;
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException("Getting products exception");
        } finally {
            connectionPool.closeConnection(connection, preparedStatement, rS);
        }
    }
}
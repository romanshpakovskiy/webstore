package by.wb.webstore.dao.impl;

import by.wb.webstore.bean.Product;
import by.wb.webstore.dao.ProductDAO;
import by.wb.webstore.dao.factoryDAO.connectionpool.ConnectionPool;
import by.wb.webstore.dao.factoryDAO.connectionpool.ConnectionPoolException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    public static final String ADD_PRODUCT_QUERY = "INSERT INTO products(id,name,price,category_id,count,specification) VALUES(?,?,?,?,?,?)";
    public static final String ADD_PRODUCT_IN_BASKET_QUERY = "INSERT INTO basket(user_id,product_id)";

    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public boolean addProductsInBasket(Product product) {
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(ADD_PRODUCT_IN_BASKET_QUERY);
        } catch (ConnectionPoolException | SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean deleteProduct(long idProduct) {
        return false;
    }

    @Override
    public boolean delete(Product product) {
        return false;
    }

    @Override
    public boolean deleteProductFromBasket(int productId, int userId) {
        return false;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public List<Product> getProductsByCategory(int categoryId) {
        return null;
    }

    @Override
    public List<Product> getProductsById() {
        return null;
    }

    @Override
    public List<Product> getProductsFromBasket(int userId) {
        return null;
    }
}
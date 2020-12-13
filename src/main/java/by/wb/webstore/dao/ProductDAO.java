package by.wb.webstore.dao;

import by.wb.webstore.bean.BasketAttributes;
import by.wb.webstore.bean.Product;

import java.util.List;
import java.util.Map;

public interface ProductDAO {
    boolean addProduct(Product product) throws DAOException;

    boolean addProductsInBasket(int userId, int productId, int count) throws DAOException;

    boolean deleteProduct(long idProduct) throws DAOException;

    boolean deleteProductFromBasket(int productId, int userId) throws DAOException;

    Product getProduct(int productId) throws DAOException;

    List<Product> getProductsByCategory(int categoryId) throws DAOException;

    List<Product> getProducts() throws DAOException;

    List<BasketAttributes> getProductsFromBasket(int userId) throws DAOException;
}

package by.wb.webstore.dao;

import by.wb.webstore.bean.Product;

import java.util.List;

public interface ProductDAO {
    boolean addProduct(Product product) throws DAOException;

    boolean addProductsInBasket(Product product) throws DAOException;

    boolean deleteProduct(long idProduct) throws DAOException;

    boolean deleteProductFromBasket(int productId, int userId) throws DAOException;

    Product getProduct(int productId) throws DAOException;

    List<Product> getProductsByCategory(int categoryId) throws DAOException;

    List<Product> getProducts() throws DAOException;

    List<Product> getProductsFromBasket(int userId) throws DAOException;
}

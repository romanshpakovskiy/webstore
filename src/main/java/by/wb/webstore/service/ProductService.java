package by.wb.webstore.service;

import by.wb.webstore.bean.BasketAttributes;
import by.wb.webstore.bean.Product;

import java.util.List;

public interface ProductService {
    boolean addProduct(Product product);

    boolean addProductsInBasket(int userId, String productId, String count) throws ServiceException;

    boolean deleteProduct(long idProduct);

    boolean deleteProductFromBasket(int productId, int userId);

    Product getProduct(String productId) throws ServiceException;

    List<Product> getProductsByCategory(String categoryId) throws ServiceException;

    List<Product> getProducts() throws ServiceException;

    List<BasketAttributes> getProductsFromBasket(String userId) throws ServiceException;
}

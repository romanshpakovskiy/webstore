package by.wb.webstore.service;

import by.wb.webstore.bean.Product;

import java.util.List;

public interface ProductService {
    boolean addProduct(Product product);

    boolean addProductsInBasket(Product product);

    boolean deleteProduct(long idProduct);

    boolean deleteProductFromBasket(int productId, int userId);

    List<Product> getProductsByCategory(String categoryId) throws ServiceException;

    List<Product> getProducts(String productId) throws ServiceException;

    List<Product> getProductsFromBasket(int userId);
}

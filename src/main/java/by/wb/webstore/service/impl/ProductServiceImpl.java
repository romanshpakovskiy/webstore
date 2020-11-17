package by.wb.webstore.service.impl;

import by.wb.webstore.bean.Product;
import by.wb.webstore.dao.DAOException;
import by.wb.webstore.dao.ProductDAO;
import by.wb.webstore.dao.factoryDAO.DAOFactory;
import by.wb.webstore.service.ProductService;
import by.wb.webstore.service.ServiceException;
import by.wb.webstore.service.Validator;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDAO productDAO = DAOFactory.INSTANCE.getProductDAO();
    Validator validator = new Validator();

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
    public List<Product> getProductsByCategory(String categoryId) throws ServiceException {
        if (!validator.checkCategoryValidation(categoryId))
            throw new ServiceException("Category id = " + categoryId);
        try {
            return productDAO.getProductsByCategory(Integer.parseInt(categoryId));
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Product> getProducts(String productId) throws ServiceException {
        if (!validator.checkProductValidation(productId))
            throw new ServiceException("Product id = " + productId);
        try {
            return productDAO.getProducts(Integer.parseInt(productId));
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Product> getProductsFromBasket(int userId) {
        return null;
    }
}

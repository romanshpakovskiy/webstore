package by.wb.webstore.dao.factoryDAO;

import by.wb.webstore.dao.CategoryDAO;
import by.wb.webstore.dao.ProductDAO;
import by.wb.webstore.dao.UserDAO;
import by.wb.webstore.dao.impl.CategoryDAOImpl;
import by.wb.webstore.dao.impl.ProductDAOImpl;
import by.wb.webstore.dao.impl.UserDAOImpl;

public enum DAOFactory {
    INSTANCE;

    private final UserDAO userDAO=new UserDAOImpl();
    private final ProductDAO productDAO=new ProductDAOImpl();
    private final CategoryDAO categoryDAO=new CategoryDAOImpl();

    public UserDAO getUserDAO(){
        return userDAO;
    }

    public ProductDAO getProductDAO(){
        return productDAO;
    }

    public CategoryDAO getCategoryDAO(){
        return categoryDAO;
    }
}

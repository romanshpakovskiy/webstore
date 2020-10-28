package by.wb.webstore.service.impl;

import by.wb.webstore.bean.Category;
import by.wb.webstore.dao.CategoryDAO;
import by.wb.webstore.dao.DAOException;
import by.wb.webstore.dao.connectionpool.ConnectionPoolException;
import by.wb.webstore.dao.factoryDAO.DAOFactory;
import by.wb.webstore.service.CategoryService;

import javax.xml.rpc.ServiceException;
import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryDAO categoryDAO= DAOFactory.INSTANCE.getCategoryDAO();

    @Override
    public List<Category> getCategories() throws ServiceException {
        try {
            return categoryDAO.getCategories();
        } catch (DAOException | ConnectionPoolException | SQLException e) {
            throw new ServiceException(e);
        }
    }
}

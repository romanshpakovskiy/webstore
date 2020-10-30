package by.wb.webstore.service.impl;

import by.wb.webstore.bean.Category;
import by.wb.webstore.dao.CategoryDAO;
import by.wb.webstore.dao.DAOException;
import by.wb.webstore.dao.factoryDAO.DAOFactory;
import by.wb.webstore.service.CategoryService;
import by.wb.webstore.service.ServiceException;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryDAO categoryDAO = DAOFactory.INSTANCE.getCategoryDAO();

    @Override
    public List<Category> getCategories() throws ServiceException {
        try {
            return categoryDAO.getCategories();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}

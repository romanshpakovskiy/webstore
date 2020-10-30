package by.wb.webstore.dao;

import by.wb.webstore.bean.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDAO {
    void addCategory(Category category) throws DAOException;

    void deleteCategory(Category category) throws DAOException;

    List<Category> getCategories() throws DAOException;
}
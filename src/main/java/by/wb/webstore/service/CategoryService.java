package by.wb.webstore.service;

import by.wb.webstore.bean.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories() throws ServiceException;
}

package by.wb.webstore.service;

import by.wb.webstore.bean.Category;

import javax.xml.rpc.ServiceException;
import java.util.List;

public interface CategoryService {
    List<Category> getCategories() throws ServiceException;
}

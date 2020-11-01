package by.wb.webstore.controller;

import by.wb.webstore.dao.impl.connectionpool.ConnectionPool;
import by.wb.webstore.dao.impl.connectionpool.ConnectionPoolException;
import by.wb.webstore.service.CategoryService;
import by.wb.webstore.service.ServiceException;
import by.wb.webstore.service.ServiceFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class DBConPoolListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public DBConPoolListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionPool.getInstance().initPoolData();
            CategoryService categoryService = ServiceFactory.INSTANCE.getCategoryService();
            sce.getServletContext().setAttribute("categories", categoryService.getCategories());
        } catch (ConnectionPoolException | ServiceException e) {
            throw new DBConPoolListenerRuntimeException(e);
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        ConnectionPool.getInstance().dispose();
    }
}

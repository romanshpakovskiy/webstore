package by.wb.webstore.controller.command.commandImpl;

import by.wb.webstore.bean.Category;
import by.wb.webstore.controller.command.Command;
import by.wb.webstore.service.CategoryService;
import by.wb.webstore.service.ServiceException;
import by.wb.webstore.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetCategoryCommand implements Command {
    private static final String CATEGORY_ATTR = "category";
    private static final String CATEGORY_ID_PARAM = "category_id";

    private static final String CATALOG_PATH="WEB-INF/jsp/catalogPage.jsp";
    private static final String ERROR_PAGE_PATH = "WEB-INF/jsp/errorPage.jsp";

    CategoryService categoryService = ServiceFactory.INSTANCE.getCategoryService();

    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServiceException, IOException, ServletException {
        Category category = categoryService.getCategory(httpServletRequest.getParameter(CATEGORY_ID_PARAM));
        if (category == null) {
            httpServletRequest.getRequestDispatcher(ERROR_PAGE_PATH).forward(httpServletRequest, httpServletResponse);
        } else {
            httpServletRequest.setAttribute(CATEGORY_ATTR, category);
            httpServletRequest.getRequestDispatcher(CATALOG_PATH).forward(httpServletRequest,httpServletResponse);
        }
    }
}

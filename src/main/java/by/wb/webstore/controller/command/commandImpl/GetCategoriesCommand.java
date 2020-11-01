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
import java.util.List;

public class GetCategoriesCommand implements Command {
    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServiceException {
        CategoryService categoryService = ServiceFactory.INSTANCE.getCategoryService();
        try {
            List<Category> categories = categoryService.getCategories();
            httpServletRequest.setAttribute("categories", categories);
            httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest, httpServletResponse);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}

package by.wb.webstore.controller.command.impl;

import by.wb.webstore.controller.CommandController;
import by.wb.webstore.controller.ControllerException;
import by.wb.webstore.service.impl.CategoryService;
import by.wb.webstore.service.impl.ServiceException;
import by.wb.webstore.service.impl.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetCategoriesCommand implements CommandController {
    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ControllerException {
        CategoryService categoryService = ServiceFactory.INSTANCE.getCategoryService();
        try {
            httpServletRequest.setAttribute("categories", categoryService.getCategories());
            httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest, httpServletResponse);
        } catch (ServletException | IOException | ServiceException e) {
            throw new ControllerException(e);
        }
    }
}

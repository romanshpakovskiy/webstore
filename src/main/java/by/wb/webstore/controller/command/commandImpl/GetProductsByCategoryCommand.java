package by.wb.webstore.controller.command.commandImpl;

import by.wb.webstore.bean.Product;
import by.wb.webstore.controller.command.Command;
import by.wb.webstore.service.ProductService;
import by.wb.webstore.service.ServiceException;
import by.wb.webstore.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetProductsByCategoryCommand implements Command {
    private static final String CATEGORY_ID_PARAM = "category_id";
    private static final String SORTED_PROD_ATTR = "products";
    private static final String ERROR_PAGE_PATH = "WEB-INF/jsp/errorPage.jsp";
    private static final String CATALOG_PAGE_PATH = "WEB-INF/jsp/catalogPage.jsp";

    ProductService productService = ServiceFactory.INSTANCE.getProductService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            List<Product> productList = productService.getProductsByCategory(request.getParameter(CATEGORY_ID_PARAM));
            if (productList == null) {
                request.getRequestDispatcher(ERROR_PAGE_PATH).forward(request, response);
            } else {
                request.setAttribute(SORTED_PROD_ATTR, productList);
                request.getRequestDispatcher(CATALOG_PAGE_PATH).forward(request, response);
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}

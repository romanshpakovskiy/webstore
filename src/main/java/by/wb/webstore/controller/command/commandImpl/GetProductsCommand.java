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

public class GetProductsCommand implements Command {
    private static final String PRODUCTS_ATTR = "products";

    private static final String CATALOG_PATH = "WEB-INF/jsp/catalogPage.jsp";
    private static final String ERROR_PAGE_PATH = "WEB-INF/jsp/errorPage.jsp";

    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServiceException, IOException, ServletException {
        ProductService productService = ServiceFactory.INSTANCE.getProductService();
        List<Product> products = productService.getProducts();
        if (products == null) {
            httpServletRequest.getRequestDispatcher(ERROR_PAGE_PATH).forward(httpServletRequest, httpServletResponse);
        } else {
            httpServletRequest.setAttribute(PRODUCTS_ATTR, products);
            httpServletRequest.getRequestDispatcher(CATALOG_PATH).forward(httpServletRequest, httpServletResponse);
        }
    }
}

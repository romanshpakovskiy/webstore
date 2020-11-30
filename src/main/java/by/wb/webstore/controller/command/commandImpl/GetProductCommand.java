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

public class GetProductCommand implements Command {
    private static final String PROD_ID_PARAM = "product_id";
    private static final String ERROR_PAGE_PATH = "WEB-INF/jsp/errorPage.jsp";
    private static final String PROD_ATTR = "product";
    private static final String PROD_PAGE_PATH = "WEB-INF/jsp/productPage.jsp";

    ProductService productService = ServiceFactory.INSTANCE.getProductService();

    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServiceException, IOException, ServletException {
        Product product = productService.getProduct(httpServletRequest.getParameter(PROD_ID_PARAM));
        if (product == null) {
            httpServletRequest.getRequestDispatcher(ERROR_PAGE_PATH).forward(httpServletRequest, httpServletResponse);
        } else {
            httpServletRequest.setAttribute(PROD_ATTR, product);
            httpServletRequest.getRequestDispatcher(PROD_PAGE_PATH).forward(httpServletRequest, httpServletResponse);
        }
    }
}

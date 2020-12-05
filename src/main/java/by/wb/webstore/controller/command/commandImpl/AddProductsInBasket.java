package by.wb.webstore.controller.command.commandImpl;

import by.wb.webstore.controller.command.Command;
import by.wb.webstore.service.ProductService;
import by.wb.webstore.service.ServiceException;
import by.wb.webstore.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddProductsInBasket implements Command {
//    private static final String USER_PARAM = "user_id";
    private static final String PRODUCT_ID_PARAM = "product_id";
    private static final String PRODUCTS_COUNT_PARAM = "count";
    private static final String ERROR_PAGE_PATH = "WEB-INF/jsp/errorPage.jsp";
    private static final int DEFAULT_USER_ID_PARAM = 1;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, ServletException, IOException {
        ProductService productService = ServiceFactory.INSTANCE.getProductService();

        boolean isAdded = productService.addProductsInBasket(DEFAULT_USER_ID_PARAM,
                request.getParameter(PRODUCT_ID_PARAM), request.getParameter(PRODUCTS_COUNT_PARAM));
//        after adding sessions to the project request.getParameter(USER_PARAM)

        if (!isAdded) {
            request.getRequestDispatcher(ERROR_PAGE_PATH).forward(request, response);
        } else {
            request.getRequestDispatcher("catalogPage.jsp").forward(request, response);
        }
    }
}

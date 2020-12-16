package by.wb.webstore.controller.command.commandImpl;

import by.wb.webstore.bean.User;
import by.wb.webstore.controller.command.Command;
import by.wb.webstore.service.ProductService;
import by.wb.webstore.service.ServiceException;
import by.wb.webstore.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddProductsInBasket implements Command {
    private static final String PRODUCT_ID_PARAM = "product_id";
    private static final String PRODUCTS_COUNT_PARAM = "count";
    private static final String PROD_CATEGORY_PARAM = "category_id";
    private static final String USER_ATTR = "user";
    private static final String ERROR_PAGE_PATH = "WEB-INF/jsp/errorPage.jsp";
    private static final String CATALOG_PAGE_PATH = "WEB-INF/jsp/catalogPage.jsp";
    private static final String SIGN_IN_PAGE_PATH = "/signIn";
    private static final int DAY = 3600 * 24;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, ServletException, IOException {
        ProductService productService = ServiceFactory.INSTANCE.getProductService();

        String count = request.getParameter(PRODUCTS_COUNT_PARAM);
        String product_id = request.getParameter(PRODUCT_ID_PARAM);
        User user = (User) request.getSession().getAttribute(USER_ATTR);

        if (user == null) {
            String prodCategory = request.getParameter(PROD_CATEGORY_PARAM);
            addCookies(response, count, product_id, prodCategory);
            response.sendRedirect(request.getContextPath() + SIGN_IN_PAGE_PATH);
        } else {
            boolean isAdded = productService.addProductsInBasket(user.getId(), product_id, count);

            if (!isAdded) {
                request.getRequestDispatcher(ERROR_PAGE_PATH).forward(request, response);
            } else {
                request.getRequestDispatcher(CATALOG_PAGE_PATH).forward(request, response);
            }
        }
    }

    private void addCookies(HttpServletResponse response, String count, String product_id, String prodCategory) {
        Cookie countCookie = new Cookie("count", count);
        Cookie prodIdCookie = new Cookie("prod_id", product_id);
        Cookie categoryIdCookie = new Cookie("category_id", prodCategory);
        prodIdCookie.setMaxAge(DAY);
        prodIdCookie.setMaxAge(DAY);
        countCookie.setMaxAge(DAY);
        response.addCookie(countCookie);
        response.addCookie(prodIdCookie);
        response.addCookie(categoryIdCookie);
    }
}
package by.wb.webstore.controller.command.commandImpl;

import by.wb.webstore.bean.BasketAttributes;
import by.wb.webstore.controller.command.Command;
import by.wb.webstore.service.ProductService;
import by.wb.webstore.service.ServiceException;
import by.wb.webstore.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoToBasketCommand implements Command {
    private static final String USER_ID_PARAM = "user_id";
    private static final String BASKET_PROD_ATTR = "basket_product";
    private static final String BASKET_PATH = "WEB-INF/jsp/basket.jsp";
    private static final String ERROR_PAGE_PATH = "WEB-INF/jsp/errorPage.jsp";

    ProductService productService = ServiceFactory.INSTANCE.getProductService();

    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServiceException, IOException, ServletException {
        List<BasketAttributes> basketAttrsList = productService.getProductsFromBasket(httpServletRequest.getParameter(USER_ID_PARAM));

        if (basketAttrsList.isEmpty())
            httpServletRequest.getRequestDispatcher(ERROR_PAGE_PATH).forward(httpServletRequest,httpServletResponse);
        else {
            httpServletRequest.setAttribute(BASKET_PROD_ATTR, basketAttrsList);
            httpServletRequest.getRequestDispatcher(BASKET_PATH).forward(httpServletRequest, httpServletResponse);
        }
    }
}

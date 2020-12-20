package by.wb.webstore.controller.command.commandImpl;

import by.wb.webstore.bean.User;
import by.wb.webstore.controller.command.Command;
import by.wb.webstore.service.ServiceException;
import by.wb.webstore.service.ServiceFactory;
import by.wb.webstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AutoSignInCommand implements Command {
    private static final String EMAIL_PARAM = "email";
    private static final String PSW_PARAM = "password";
    private static final String USER_SESSION_ATTR = "user";

    private static final String CATALOG_PAGE_PATH = "WEB-INF/jsp/catalogPage.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, IOException, ServletException {
        String email = null;
        String password = null;
        for (Cookie cookie : request.getCookies()) {
            String cookieName = cookie.getName();
            String cookieValue = cookie.getValue();
            if (cookieName.equals(EMAIL_PARAM)) {
                email = cookieValue;
            } else if (cookieName.equals(PSW_PARAM)) {
                password = cookieValue;
            }
        }

        UserService userService = ServiceFactory.INSTANCE.getUserService();
        User user = userService.signIn(email, password);

        if (user == null) {
            request.getRequestDispatcher(CATALOG_PAGE_PATH).forward(request, response);
        } else {
            HttpSession session = request.getSession(true);
            session.setAttribute(USER_SESSION_ATTR, user);
            request.getRequestDispatcher(request.getContextPath()).forward(request, response);
        }
    }
}

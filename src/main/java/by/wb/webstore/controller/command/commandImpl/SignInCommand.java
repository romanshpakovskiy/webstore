package by.wb.webstore.controller.command.commandImpl;

import by.wb.webstore.bean.User;
import by.wb.webstore.controller.command.Command;
import by.wb.webstore.service.ServiceException;
import by.wb.webstore.service.ServiceFactory;
import by.wb.webstore.service.UserService;
import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SignInCommand implements Command {
    private static final String EMAIL_PARAM = "email";
    private static final String PSW_PARAM = "password";
    private static final String USER_ATTR = "user";
    private static final String TAKEN_PARAMETER_ERROR = "/signIn?error_message=error";
    private static final String CATALOG_PAGE_PATH = "WEB-INF/jsp/catalogPage.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserService userService = ServiceFactory.INSTANCE.getUserService();
        try {
            User user = userService.signIn(request.getParameter(EMAIL_PARAM),
                    request.getParameter(PSW_PARAM));
            if (user == null) {
                response.sendRedirect(request.getContextPath() + TAKEN_PARAMETER_ERROR);
            } else {
                HttpSession session = request.getSession(true);
                session.setAttribute(USER_ATTR, user);
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        switch (cookie.getName()) {
                            case "prod_id" -> request.setAttribute("prod_id", cookie);
                            case "count" -> request.setAttribute("count", cookie);
                            case "category_id" -> request.setAttribute("category_id", cookie);
                        }
                    }
                    request.getRequestDispatcher(CATALOG_PAGE_PATH).forward(request,response);
                }
                response.sendRedirect(request.getContextPath());
            }
        } catch (ServiceException | ServletException e) {
            response.sendRedirect(request.getContextPath() + TAKEN_PARAMETER_ERROR);
        }
    }
}

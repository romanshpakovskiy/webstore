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
    private static final String USER_SESSION_ATTR = "user";
    private static final String TAKEN_PARAMETER_ERROR = "/signIn?error_message=error";
    private static final String CATALOG_PAGE_PATH = "WEB-INF/jsp/catalogPage.jsp";
    private static final int DAY = 3600 * 24;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserService userService = ServiceFactory.INSTANCE.getUserService();
        try {
            String email = request.getParameter(EMAIL_PARAM);
            String password = request.getParameter(PSW_PARAM);
            User user = userService.signIn(email, password);
            if (user == null) {
                response.sendRedirect(request.getContextPath() + TAKEN_PARAMETER_ERROR);
            } else {
                addCookie(response, EMAIL_PARAM, user.getEmail(), DAY);
                addCookie(response, PSW_PARAM, user.getPassword(), DAY);
                HttpSession session = request.getSession(true);
                session.setAttribute(USER_SESSION_ATTR, user);
                response.sendRedirect(request.getContextPath());
            }
        } catch (ServiceException e) {
             response.sendRedirect(request.getContextPath() + TAKEN_PARAMETER_ERROR);
        }
    }

    private void addCookie(HttpServletResponse response, String cookieName, String cookieValue, int duration) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(duration);
        response.addCookie(cookie);
    }
}

package by.wb.webstore.controller.command.commandImpl;

import by.wb.webstore.controller.command.Command;
import by.wb.webstore.service.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignOutCommand implements Command {
    private static final String EMAIL_PARAM = "email";
    private static final String PSW_PARAM = "password";
    private static final String USER_ATTR = "user";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, IOException, ServletException {
        deleteCookie(response, EMAIL_PARAM);
        deleteCookie(response, PSW_PARAM);

        HttpSession session = request.getSession();
        session.removeAttribute(USER_ATTR);
        request.getRequestDispatcher(request.getContextPath()).forward(request,response);
    }

    private void deleteCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}

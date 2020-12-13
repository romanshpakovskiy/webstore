package by.wb.webstore.controller.command.commandImpl;

import by.wb.webstore.bean.User;
import by.wb.webstore.controller.command.Command;
import by.wb.webstore.service.ServiceException;
import by.wb.webstore.service.ServiceFactory;
import by.wb.webstore.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegistrationCommand implements Command {
    UserService userService = ServiceFactory.INSTANCE.getUserService();

    private static final String USER_NAME_PARAM = "name";
    private static final String USER_SURNAME_PARAM = "surname";
    private static final String USER_EMAIL_PARAM = "email";
    private static final String USER_PASSWORD_PARAM = "password";
    private static final String USER_ADDRESS_PARAM = "address";
    private static final int USER_DEFAULT_ROLE_ID = 1;
    private static final String USER_ATTR = "user";
    private static final String EXISTING_USER_ERROR = "/registration?error_message=existing";
    private static final String ERROR_PAGE_URL = "WEB_INF/jsp/errorPage.jsp";

    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        UserService userService = ServiceFactory.INSTANCE.getUserService();
        User regUser = getRegistrationData(httpServletRequest);
        try {
            User user = userService.registration(regUser);
            if (user != null) {
                HttpSession session = httpServletRequest.getSession(true);
                session.setAttribute(USER_ATTR, user);
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath());
            } else httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + ERROR_PAGE_URL);
        } catch (ServiceException e) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + ERROR_PAGE_URL);
        }
    }

    private User getRegistrationData(HttpServletRequest request) {
        User user = new User();
        user.setName(request.getParameter(USER_NAME_PARAM));
        user.setSurname(request.getParameter(USER_SURNAME_PARAM));
        user.setEmail(request.getParameter(USER_EMAIL_PARAM));
        user.setPassword(request.getParameter(USER_PASSWORD_PARAM));
        user.setAddress(request.getParameter(USER_ADDRESS_PARAM));
        user.setRoleId(USER_DEFAULT_ROLE_ID);
        return user;
    }
}

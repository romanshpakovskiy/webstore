package by.wb.webstore.controller.command.commandImpl;

import by.wb.webstore.bean.User;
import by.wb.webstore.controller.command.Command;
import by.wb.webstore.service.ServiceException;
import by.wb.webstore.service.ServiceFactory;
import by.wb.webstore.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetRegistrationDataCommand implements Command {
    private static final String MAIN_PAGE_URL = "WEB-INF/index.jsp";
    private static final String USER_NAME_PARAM = "name";
    private static final String USER_SURNAME_PARAM = "surname";
    private static final String USER_EMAIL_PARAM = "email";
    private static final String USER_PASSWORD_PARAM = "password";
    private static final String USER_ADDRESS_PARAM = "address";

    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServiceException, IOException, ServletException {
        UserService userService = ServiceFactory.INSTANCE.getUserService();
        User regUser = getRegistrationData(httpServletRequest);
        httpServletRequest.setAttribute("reg_data", regUser);
        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher(MAIN_PAGE_URL);
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }

    private User getRegistrationData(HttpServletRequest request) {
        User user = new User();
        user.setName(request.getParameter(USER_NAME_PARAM));
        user.setSurname(request.getParameter(USER_SURNAME_PARAM));
        user.setEmail(request.getParameter(USER_EMAIL_PARAM));
        user.setPassword(request.getParameter(USER_PASSWORD_PARAM));
        user.setAddress(request.getParameter(USER_ADDRESS_PARAM));
        return user;
    }
}

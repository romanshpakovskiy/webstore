package by.wb.webstore.controller.command.commandImpl;

import by.wb.webstore.bean.User;
import by.wb.webstore.controller.command.Command;
import by.wb.webstore.service.ServiceException;
import by.wb.webstore.service.ServiceFactory;
import by.wb.webstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInCommand implements Command {
    private static final String EMAIL_PARAM = "email";
    private static final String PSW_PARAM = "password";
    private static final String TAKEN_PARAMETER_ERROR = "/signIn?error_message=error";
    private static final String MAIN_PAGE_URL = "index.jsp";

    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        UserService userService = ServiceFactory.INSTANCE.getUserService();
        try {
            User user = userService.signIn(httpServletRequest.getParameter(EMAIL_PARAM),
                    httpServletRequest.getParameter(PSW_PARAM));
            if (user == null) {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + TAKEN_PARAMETER_ERROR);
            } else {
                httpServletRequest.getRequestDispatcher(MAIN_PAGE_URL).forward(httpServletRequest, httpServletResponse);
            }
        } catch (ServiceException e) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + TAKEN_PARAMETER_ERROR);
        }
    }
}

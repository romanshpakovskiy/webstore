package by.wb.webstore.controller.command.commandImpl;

import by.wb.webstore.bean.User;
import by.wb.webstore.controller.command.Command;
import by.wb.webstore.service.ServiceException;
import by.wb.webstore.service.ServiceFactory;
import by.wb.webstore.service.UserService;
import com.mysql.cj.Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignInCommand implements Command {
    private static final String EMAIL_PARAM = "email";
    private static final String PSW_PARAM = "password";
    private static final String TAKEN_PARAMETER_ERROR = "/signIn?error_message=error";
    private static final String USER_ATTR = "user";

    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        UserService userService = ServiceFactory.INSTANCE.getUserService();
        try {
            User user = userService.signIn(httpServletRequest.getParameter(EMAIL_PARAM),
                    httpServletRequest.getParameter(PSW_PARAM));
            if (user == null) {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + TAKEN_PARAMETER_ERROR);
            } else {
                HttpSession session = httpServletRequest.getSession(true);
                session.setAttribute(USER_ATTR, user);
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath());
            }
        } catch (ServiceException e) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + TAKEN_PARAMETER_ERROR);
        }
    }
}

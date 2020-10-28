package by.wb.webstore.controller.command.commandImpl;

import by.wb.webstore.controller.ControllerException;
import by.wb.webstore.controller.command.Command;
import by.wb.webstore.service.ServiceException;
import by.wb.webstore.service.ServiceFactory;
import by.wb.webstore.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignInCommand implements Command {
    private static final String EMAIL_PARAM="email";
    private static final String PSW_PARAM="password";
    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ControllerException {
        UserService userService = ServiceFactory.INSTANCE.getUserService();
        try {
            boolean isSignedIn = userService.signIn(httpServletRequest.getParameter(EMAIL_PARAM),
                    httpServletRequest.getParameter(PSW_PARAM));
        } catch (ServiceException e) {
//            httpServletResponse.sendRedirect(httpServletRequest.getContextPath());
        }
    }
}

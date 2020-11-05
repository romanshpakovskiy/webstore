package by.wb.webstore.controller.command.commandImpl;

import by.wb.webstore.bean.User;
import by.wb.webstore.controller.command.Command;
import by.wb.webstore.service.ServiceFactory;
import by.wb.webstore.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationCommand implements Command {
    UserService userService = ServiceFactory.INSTANCE.getUserService();

    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        User user = userService.registration()
    }
}

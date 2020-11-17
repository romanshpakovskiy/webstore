package by.wb.webstore.controller.command.commandImpl;

import by.wb.webstore.controller.command.Command;
import by.wb.webstore.service.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetProductsCommand implements Command {
    @Override
    public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServiceException, IOException, ServletException {

    }
}

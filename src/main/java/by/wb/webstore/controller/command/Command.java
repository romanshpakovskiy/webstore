package by.wb.webstore.controller.command;

import by.wb.webstore.controller.DBConPoolListenerRuntimeException;
import by.wb.webstore.service.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServiceException, IOException, ServletException;
}

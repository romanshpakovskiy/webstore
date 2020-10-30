package by.wb.webstore.controller.command;

import by.wb.webstore.controller.ControllerException;
import by.wb.webstore.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ControllerException, ServiceException;
}

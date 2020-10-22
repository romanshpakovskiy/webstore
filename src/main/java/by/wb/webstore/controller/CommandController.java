package by.wb.webstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandController {
    void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ControllerException;
}

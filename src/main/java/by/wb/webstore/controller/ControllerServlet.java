package by.wb.webstore.controller;

import by.wb.webstore.controller.command.Command;
import by.wb.webstore.service.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controller", value = "/controller")
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = -6150705617105535528L;

    private static final String COMMAND_PARAM = "command";

    private final CommandProvider commandProvider = new CommandProvider();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        Command commandController = commandProvider.getCommand(request.getParameter(COMMAND_PARAM));
        try {
            commandController.execute(request, response);
        } catch (DBConPoolListenerRuntimeException | ServiceException | IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Command commandController = commandProvider.getCommand(request.getParameter(COMMAND_PARAM));
        try {
            commandController.execute(request, response);
        } catch (DBConPoolListenerRuntimeException | ServiceException | IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}

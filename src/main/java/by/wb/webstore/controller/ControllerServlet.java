package by.wb.webstore.controller;

import by.wb.webstore.controller.command.Command;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controller", value = "/controller")
public class ControllerServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = -6150705617105535528L;

    private static final String COMMAND_PARAM = "command";

    CommandProvider commandProvider = new CommandProvider();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        Command commandController = commandProvider.getCommand(request.getParameter(COMMAND_PARAM));
        try {
            commandController.execute(request, response);
        } catch (ControllerException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Command commandController = commandProvider.getCommand(request.getParameter(COMMAND_PARAM));
        try {
            commandController.execute(request, response);
        } catch (ControllerException e) {
            e.printStackTrace();
        }
    }
}

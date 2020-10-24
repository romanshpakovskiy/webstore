package by.wb.webstore.controller;

@javax.servlet.annotation.WebServlet(name = "Controller", value = "/controller")
public class ControllerServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = -6150705617105535528L;
    private static final String COMMAND_PARAM = "command";
    CommandProvider commandProvider = new CommandProvider();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
        CommandController commandController = commandProvider.getCommand(request.getParameter(COMMAND_PARAM));
        try {
            commandController.execute(request, response);
        } catch (ControllerException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {

    }
}

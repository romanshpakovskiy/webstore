package by.wb.webstore.controller;

import by.wb.webstore.controller.command.Command;
import by.wb.webstore.controller.command.CommandName;
import by.wb.webstore.controller.command.commandImpl.GetCategoriesCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> commandMap = new HashMap<>();

    CommandProvider() {
        commandMap.put(CommandName.GET_CATEGORIES, new GetCategoriesCommand());
    }

    Command getCommand(String name) {
        Command commandController;
        CommandName commandName;
        commandName = CommandName.valueOf(name.toUpperCase());
        commandController = commandMap.get(commandName);
        return commandController;
    }
}

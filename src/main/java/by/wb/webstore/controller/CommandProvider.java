package by.wb.webstore.controller;

import by.wb.webstore.controller.command.Command;
import by.wb.webstore.controller.command.CommandName;
import by.wb.webstore.controller.command.commandImpl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> commandMap = new HashMap<>();

    CommandProvider() {
        commandMap.put(CommandName.GET_CATEGORY,new GetCategoryCommand());
        commandMap.put(CommandName.GET_CATEGORIES, new GetCategoriesCommand());
        commandMap.put(CommandName.SIGN_IN, new SignInCommand());
        commandMap.put(CommandName.REGISTRATION, new RegistrationCommand());
        commandMap.put(CommandName.GET_PRODUCT,new GetProductCommand());
        commandMap.put(CommandName.GET_PRODUCTS_BY_CATEGORY, new GetProductsByCategoryCommand());
        commandMap.put(CommandName.GET_PRODUCTS, new GetProductsCommand());
    }

    Command getCommand(String name) {
        Command commandController;
        CommandName commandName;
        commandName = CommandName.valueOf(name.toUpperCase());
        commandController = commandMap.get(commandName);
        return commandController;
    }
}

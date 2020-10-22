package by.wb.webstore.controller;

import by.wb.webstore.controller.commands.GetCategoriesCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<Command, CommandController> commandMap=new HashMap<>();

    CommandProvider(){
        commandMap.put(Command.GET_CATEGORIES, new GetCategoriesCommand());
    }

    CommandController getCommand(String name){
        CommandController commandController;
        Command command;
        command=Command.valueOf(name.toUpperCase());
        commandController=commandMap.get(command);
        return commandController;
    }
}

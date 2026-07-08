package com.github.MakarK05.WFSuperLigaBot.command;


import com.github.MakarK05.WFSuperLigaBot.service.SendBotMessageService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CommandContainer {
    private final Map<String, Command> commandMap;
    private final UnknowCommand unknowCommand;

    public CommandContainer(
            SendBotMessageService sendBotMessageService
    ){
        this.commandMap = Map.ofEntries(
                Map.entry(CommandName.START.getCommandName(), new StartCommand(sendBotMessageService)),
                Map.entry(CommandName.HELP.getCommandName(), new HelpCommand(sendBotMessageService)),
                Map.entry(CommandName.NOT_COMMAND.getCommandName(), new NoCommand(sendBotMessageService))
        );
        unknowCommand = new UnknowCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier){
        return commandMap.getOrDefault(commandIdentifier, unknowCommand);
    }
}

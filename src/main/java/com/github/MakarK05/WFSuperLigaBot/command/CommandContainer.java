package com.github.MakarK05.WFSuperLigaBot.command;


import com.github.MakarK05.WFSuperLigaBot.service.SendBotMessageService;
import com.github.MakarK05.WFSuperLigaBot.service.TelegramUserService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CommandContainer {
    private final Map<String, Command> commandMap;
    private final UnknowCommand unknowCommand;

    public CommandContainer(
            SendBotMessageService sendBotMessageService,
            TelegramUserService telegramUserService
    ){
        this.commandMap = Map.ofEntries(
                Map.entry(CommandName.START.getCommandName(), new StartCommand(sendBotMessageService, telegramUserService)),
                Map.entry(CommandName.STOP.getCommandName(), new StopCommand(sendBotMessageService, telegramUserService)),
                Map.entry(CommandName.HELP.getCommandName(), new HelpCommand(sendBotMessageService)),
                Map.entry(CommandName.NOT_COMMAND.getCommandName(), new NoCommand(sendBotMessageService)),
                Map.entry(CommandName.STAT.getCommandName(), new StatCommand(sendBotMessageService, telegramUserService))
        );
        unknowCommand = new UnknowCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier){
        return commandMap.getOrDefault(commandIdentifier, unknowCommand);
    }
}

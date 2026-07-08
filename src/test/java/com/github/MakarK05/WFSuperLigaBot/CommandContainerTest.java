package com.github.MakarK05.WFSuperLigaBot;

import com.github.MakarK05.WFSuperLigaBot.command.Command;
import com.github.MakarK05.WFSuperLigaBot.command.CommandContainer;
import com.github.MakarK05.WFSuperLigaBot.command.CommandName;
import com.github.MakarK05.WFSuperLigaBot.command.UnknowCommand;
import com.github.MakarK05.WFSuperLigaBot.service.SendBotMessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@DisplayName("Unit-level testing for CommandContainer")
public class CommandContainerTest {

    CommandContainer commandContainer;
    SendBotMessageService sendBotMessageService;

    @BeforeEach
    public void init(){
        sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        commandContainer = new CommandContainer(sendBotMessageService);

    }

    @Test
    public void shouldGetAllExistingCommands(){
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = commandContainer.retrieveCommand(commandName.getCommandName());
                    Assertions.assertNotEquals(UnknowCommand.class, command.getClass());
                });
    }

    @Test
    public void shouldReturnUnknownCommand(){
        String unknownCommand = "/testCommand";

        var command = commandContainer.retrieveCommand(unknownCommand);
        Assertions.assertEquals(UnknowCommand.class, command.getClass());
    }
}

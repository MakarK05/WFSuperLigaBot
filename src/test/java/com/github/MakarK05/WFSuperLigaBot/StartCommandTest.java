package com.github.MakarK05.WFSuperLigaBot;

import com.github.MakarK05.WFSuperLigaBot.command.Command;
import com.github.MakarK05.WFSuperLigaBot.command.CommandName;
import com.github.MakarK05.WFSuperLigaBot.command.StartCommand;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit-level testing of StartCommand")
public class StartCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return CommandName.START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return StartCommand.START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService);
    }
}

package com.github.MakarK05.WFSuperLigaBot;

import com.github.MakarK05.WFSuperLigaBot.command.Command;
import com.github.MakarK05.WFSuperLigaBot.command.CommandName;
import com.github.MakarK05.WFSuperLigaBot.command.NoCommand;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit-level testing of NoCommand")
public class NoCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return CommandName.NOT_COMMAND.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NoCommand.NOT_COMMAND;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}

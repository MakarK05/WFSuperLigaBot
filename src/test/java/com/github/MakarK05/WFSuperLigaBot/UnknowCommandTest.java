package com.github.MakarK05.WFSuperLigaBot;

import com.github.MakarK05.WFSuperLigaBot.command.Command;
import com.github.MakarK05.WFSuperLigaBot.command.CommandName;
import com.github.MakarK05.WFSuperLigaBot.command.UnknowCommand;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit-level testing of UnknowCommand")
public class UnknowCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return "/unknowCommandTest";
    }

    @Override
    String getCommandMessage() {
        return UnknowCommand.UNKNOW_COMMAND_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknowCommand(sendBotMessageService);
    }
}

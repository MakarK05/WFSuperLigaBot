package com.github.MakarK05.WFSuperLigaBot;

import com.github.MakarK05.WFSuperLigaBot.command.Command;
import com.github.MakarK05.WFSuperLigaBot.command.CommandName;
import com.github.MakarK05.WFSuperLigaBot.command.HelpCommand;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit-level testing for HelpCommand")
public class HelpCommandTest extends AbstractCommandTest{


    @Override
    String getCommandName() {
        return CommandName.HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HelpCommand.HELP_COMMAND_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}

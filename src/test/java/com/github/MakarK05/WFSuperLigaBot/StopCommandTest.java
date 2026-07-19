package com.github.MakarK05.WFSuperLigaBot;

import com.github.MakarK05.WFSuperLigaBot.command.Command;
import com.github.MakarK05.WFSuperLigaBot.command.CommandName;
import com.github.MakarK05.WFSuperLigaBot.command.StopCommand;

public class StopCommandTest  extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return CommandName.STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return StopCommand.STOP_COMMAND_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService, telegramUserService);
    }
}

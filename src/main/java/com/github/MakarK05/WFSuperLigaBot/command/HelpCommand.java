package com.github.MakarK05.WFSuperLigaBot.command;

import com.github.MakarK05.WFSuperLigaBot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HelpCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    public static final  String HELP_COMMAND_MESSAGE = String.format(
            "Список доступных команд:\n\n" +
                    "%s - начать работу с ботом\n" +
                    "%s - список всех команд\n" +
                    "%s - статистика использования бота\n" +
                    "%s - деактивация всех подписок",
            CommandName.START.getCommandName(),
            CommandName.HELP.getCommandName(),
            CommandName.STAT.getCommandName(),
            CommandName.STOP.getCommandName()
    );

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId(), HELP_COMMAND_MESSAGE);
    }
}

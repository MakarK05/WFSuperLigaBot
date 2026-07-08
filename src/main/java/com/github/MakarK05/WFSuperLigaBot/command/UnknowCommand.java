package com.github.MakarK05.WFSuperLigaBot.command;

import com.github.MakarK05.WFSuperLigaBot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UnknowCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    public static final String UNKNOW_COMMAND_MESSAGE = "Я не знаю такую команду.\n" +
            "Введите /help, чтобы увидеть доступные команды";

    public UnknowCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId(), UNKNOW_COMMAND_MESSAGE);
    }
}

package com.github.MakarK05.WFSuperLigaBot.command;

import com.github.MakarK05.WFSuperLigaBot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;


public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    public static final String START_MESSAGE = "Привет, это бот Женской Суперлиги по футболу!";

    public StartCommand(
            SendBotMessageService sendBotMessageService
    ){
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update){


        sendBotMessageService.sendMessage(update.getMessage().getChatId(),START_MESSAGE);
    }

}

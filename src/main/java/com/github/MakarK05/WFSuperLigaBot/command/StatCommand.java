package com.github.MakarK05.WFSuperLigaBot.command;

import com.github.MakarK05.WFSuperLigaBot.service.SendBotMessageService;
import com.github.MakarK05.WFSuperLigaBot.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StatCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public final static String STAT_MESSAGE = "Super Liga bot использует %d человек.";

    public StatCommand(
            SendBotMessageService sendBotMessageService,
            TelegramUserService telegramUserService
    ){
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        int activeUserCount =  telegramUserService.retrieveAllActiveUser().size();
        sendBotMessageService.sendMessage(update.getMessage().getChatId(), String.format(STAT_MESSAGE, activeUserCount));
    }
}

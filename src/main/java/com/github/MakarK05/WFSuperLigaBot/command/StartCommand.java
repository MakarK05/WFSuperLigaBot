package com.github.MakarK05.WFSuperLigaBot.command;

import com.github.MakarK05.WFSuperLigaBot.repository.entity.TelegramUser;
import com.github.MakarK05.WFSuperLigaBot.service.SendBotMessageService;
import com.github.MakarK05.WFSuperLigaBot.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;


public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public static final String START_MESSAGE = "Привет, это бот Женской Суперлиги по футболу!";

    public StartCommand(
            SendBotMessageService sendBotMessageService,
            TelegramUserService telegramUserService
    ){
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update){

        String chatId = String.valueOf(update.getMessage().getChatId());

        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                telegramUser ->{
                    telegramUser.setActive(true);
                    telegramUserService.save(telegramUser);
                },
                () -> {
                    TelegramUser telegramUser = new TelegramUser();
                    telegramUser.setChatId(chatId);
                    telegramUser.setActive(true);
                    telegramUserService.save(telegramUser);
                }
        );

        sendBotMessageService.sendMessage(update.getMessage().getChatId(),START_MESSAGE);
    }

}

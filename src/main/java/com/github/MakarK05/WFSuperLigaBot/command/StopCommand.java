package com.github.MakarK05.WFSuperLigaBot.command;

import com.github.MakarK05.WFSuperLigaBot.service.SendBotMessageService;
import com.github.MakarK05.WFSuperLigaBot.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public static final String STOP_COMMAND_MESSAGE = "Деактивировал все ваши подписки";

    public StopCommand(
            SendBotMessageService sendBotMessageService,
            TelegramUserService telegramUserService
    ){
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {

        Long chatId = update.getMessage().getChatId();

        telegramUserService.findByChatId(chatId.toString()).ifPresent(
                telegramUser -> {
                    telegramUser.setActive(false);
                    telegramUserService.save(telegramUser);
                }
        );

        sendBotMessageService.sendMessage(chatId, STOP_COMMAND_MESSAGE);
    }
}

package com.github.MakarK05.WFSuperLigaBot.command;

import com.github.MakarK05.WFSuperLigaBot.service.SendBotMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Component
public class UpdateConsumer implements LongPollingSingleThreadUpdateConsumer {

    private final TelegramClient telegramClient;
    private final SendBotMessageService sendBotMessage;

    public UpdateConsumer(@Value("${bot.token}") String BOT_TOKEN,
                          SendBotMessageService sendBotMessage
    ){
        this.telegramClient = new OkHttpTelegramClient(BOT_TOKEN);
        this.sendBotMessage = sendBotMessage;
    }

    @Override
    public void consume(Update update) {

        var chatId = update.getMessage().getChatId();
        var getMessage = update.getMessage().getText();
        final String START_MESSAGE = "Привет, это бот Женской Суперлиги по футболу!";

        sendBotMessage.sendMessage(telegramClient, chatId, getMessage);

    }
}

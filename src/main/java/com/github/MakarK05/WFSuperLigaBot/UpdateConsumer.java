package com.github.MakarK05.WFSuperLigaBot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Component
public class UpdateConsumer implements LongPollingSingleThreadUpdateConsumer {

    public UpdateConsumer(@Value("${bot.token}") String BOT_TOKEN) {
        this.telegramClient = new OkHttpTelegramClient(BOT_TOKEN);
    }

    private final TelegramClient telegramClient;


    @Override
    public void consume(Update update) {
        var chatId = update.getMessage().getChatId();
        var getMessage = update.getMessage().getText();

        SendMessage sendMessage = SendMessage.builder()
                .text(getMessage)
                .chatId(chatId)
                .build();

        try {
            telegramClient.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}

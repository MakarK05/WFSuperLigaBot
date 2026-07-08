package com.github.MakarK05.WFSuperLigaBot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Service
public class SendBotMessageImpl implements SendBotMessageService {

    private final TelegramClient telegramClient;

    public SendBotMessageImpl(TelegramClient telegramClient) {
        this.telegramClient = telegramClient;
    }

    @Override
    public void sendMessage(
                            Long chatId,
                            String message
    ){
        SendMessage sendMessage = SendMessage.builder()
                .text(message)
                .chatId(chatId)
                .build();

        try {
            telegramClient.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}

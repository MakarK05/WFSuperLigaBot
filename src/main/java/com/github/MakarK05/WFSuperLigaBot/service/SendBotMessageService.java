package com.github.MakarK05.WFSuperLigaBot.service;

import org.springframework.beans.factory.annotation.Value;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.generics.TelegramClient;

/**
 * Service for sending message via tg bot
 */

public interface SendBotMessageService {

    void sendMessage(Long chatId, String message);
}

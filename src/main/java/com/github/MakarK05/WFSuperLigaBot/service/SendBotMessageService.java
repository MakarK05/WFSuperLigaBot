package com.github.MakarK05.WFSuperLigaBot.service;

import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.generics.TelegramClient;

/**
 * Service for sending message via tg bot
 */

public interface SendBotMessageService {
    void sendMessage(TelegramClient telegramClient, Long chatId, String message);
}

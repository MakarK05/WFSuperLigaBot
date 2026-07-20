package com.github.MakarK05.WFSuperLigaBot.service;

import com.github.MakarK05.WFSuperLigaBot.repository.entity.TelegramUser;

import java.util.List;
import java.util.Optional;

public interface TelegramUserService {

    void save(TelegramUser telegramUser);
    List<TelegramUser> retrieveAllActiveUser();
    Optional<TelegramUser> findByChatId(String chatId);
}

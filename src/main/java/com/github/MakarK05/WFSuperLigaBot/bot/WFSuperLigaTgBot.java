package com.github.MakarK05.WFSuperLigaBot.bot;

import com.github.MakarK05.WFSuperLigaBot.command.UpdateConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot;

@Component
public class WFSuperLigaTgBot implements SpringLongPollingBot {

    @Value("${bot.token}")
    private String BOT_TOKEN;

    private final UpdateConsumer updateConsumer;

    public WFSuperLigaTgBot(UpdateConsumer updateConsumer) {
        this.updateConsumer = updateConsumer;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public LongPollingUpdateConsumer getUpdatesConsumer() {
        return updateConsumer;
    }
}

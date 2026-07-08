package com.github.MakarK05.WFSuperLigaBot.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Configuration
public class WFSuperLigaTgBotConfig {

    @Bean
    public TelegramClient telegramClient(
            @Value("${bot.token}") String BOT_TOKEN
    ){
        return new OkHttpTelegramClient(BOT_TOKEN);
    }
}

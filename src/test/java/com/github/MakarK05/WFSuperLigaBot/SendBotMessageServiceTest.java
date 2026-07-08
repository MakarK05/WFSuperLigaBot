package com.github.MakarK05.WFSuperLigaBot;

import com.github.MakarK05.WFSuperLigaBot.service.SendBotMessageImpl;
import com.github.MakarK05.WFSuperLigaBot.service.SendBotMessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private TelegramClient telegramClient;

    @BeforeEach
    public void init(){
        telegramClient = Mockito.mock(TelegramClient.class);
        sendBotMessageService = new SendBotMessageImpl(telegramClient);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        Long chatId = 1L;
        String message= "test_message";

        SendMessage sendMessage = SendMessage.builder()
                .text(message)
                .chatId(chatId)
                .build();

        sendBotMessageService.sendMessage(chatId, message);

        Mockito.verify(telegramClient).execute(sendMessage);
    }
}

package com.github.MakarK05.WFSuperLigaBot;

import com.github.MakarK05.WFSuperLigaBot.command.Command;
import com.github.MakarK05.WFSuperLigaBot.service.SendBotMessageImpl;
import com.github.MakarK05.WFSuperLigaBot.service.SendBotMessageService;
import com.github.MakarK05.WFSuperLigaBot.service.TelegramUserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

abstract class AbstractCommandTest {

    protected TelegramClient telegramClient = Mockito.mock(TelegramClient.class);
    protected SendBotMessageService sendBotMessageService = new SendBotMessageImpl(telegramClient);
    protected TelegramUserService telegramUserService = Mockito.mock(TelegramUserService.class);

    abstract String getCommandName();
    abstract String getCommandMessage();
    abstract Command getCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        Long chatId = 12345L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage(chatId.toString(), getCommandMessage());

        //when
        getCommand().execute(update);

        //then
        Mockito.verify(telegramClient).execute(sendMessage);
    }


}
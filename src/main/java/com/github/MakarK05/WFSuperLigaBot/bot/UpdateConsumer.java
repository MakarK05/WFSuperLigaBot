package com.github.MakarK05.WFSuperLigaBot.bot;


import com.github.MakarK05.WFSuperLigaBot.command.CommandContainer;
import com.github.MakarK05.WFSuperLigaBot.command.CommandName;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.Locale;


@Component
public class UpdateConsumer implements LongPollingSingleThreadUpdateConsumer {

    private final CommandContainer commandContainer;
    private final String COMMAND_PREFIX = "/";

    public UpdateConsumer(
            CommandContainer commandContainer
    ){
        this.commandContainer = commandContainer;
    }

    @Override
    public void consume(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()){
            String message = update.getMessage().getText().strip();
            if(message.startsWith(COMMAND_PREFIX)){
                String commandIdentifier = message.toLowerCase(Locale.ROOT);
                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            }else{
                commandContainer.retrieveCommand(CommandName.NOT_COMMAND.getCommandName()).execute(update);
            }
        }
    }
}

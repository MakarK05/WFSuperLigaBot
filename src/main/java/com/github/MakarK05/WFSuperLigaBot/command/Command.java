package com.github.MakarK05.WFSuperLigaBot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Command interface for handling telegram-bots commands.
 */

public interface Command {
    void execute (Update update);
}

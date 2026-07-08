package com.github.MakarK05.WFSuperLigaBot.command;

/**
 * Enumeration for command's
 */

public enum CommandName {
    START("/start"),
    HELP("/help"),
    NOT_COMMAND("notCommand");

    private final String commandName;

    CommandName(String commandName){
        this.commandName = commandName;
    }

    public String getCommandName(){
        return commandName;
    }
}

package com.github.MakarK05.WFSuperLigaBot.command;

/**
 * Enumeration for command's
 */

public enum CommandName {
    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    NOT_COMMAND("notCommand"),
    STAT("/stat");

    private final String commandName;

    CommandName(String commandName){
        this.commandName = commandName;
    }

    public String getCommandName(){
        return commandName;
    }
}

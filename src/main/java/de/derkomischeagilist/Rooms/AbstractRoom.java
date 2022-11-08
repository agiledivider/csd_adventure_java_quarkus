package de.derkomischeagilist.Rooms;

public abstract class AbstractRoom implements Room {
    @Override
    public String handleCommand(String command) {
        return "Invalid Command! <br />" +
                "Please enter 'help' to get a list of available commands.";
    }
}

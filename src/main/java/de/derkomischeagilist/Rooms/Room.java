package de.derkomischeagilist.Rooms;

public interface Room {

    String getDescription();

    String getDetailedDescription();

    String handleCommand(String command);

    String getHelp();
}

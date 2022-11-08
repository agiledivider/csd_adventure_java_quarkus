package de.derkomischeagilist.Rooms;

public class TeamOffice extends AbstractRoom {
    @Override
    public String getDescription() {
        return "This is a very stinky room. Smells like real work. \n" +
                "Your smart but smelly Teammates greet you in the usual manner: 'Hey, you moron! ;)'";
    }

    @Override
    public String getDetailedDescription() {
        return "You see many flip charts, sticky notes and other things on the walls.";
    }

    @Override
    public String handleCommand(String command) {

        return super.handleCommand(command);
    }

    @Override
    public String getHelp() {
        return "Try to 'look around' or 'use door to hallway'. Might help.";
    }
}

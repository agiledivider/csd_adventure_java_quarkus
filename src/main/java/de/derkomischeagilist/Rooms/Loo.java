package de.derkomischeagilist.Rooms;

public class Loo extends AbstractRoom {

    public String getDescription() {
        return "You wake up on the loo. You have no idea where or who you are.";
    }

    public String getDetailedDescription() {
        return "You see a pretty dirty door, with some nasty jokes on it. Next to you is some toilet paper, a coin and a few magazines."
          + "<br/>"
          + "In your pocket you find a card that says you are a certified scrum developer";
    }

    public String handleCommand(String command){
        switch(command) {
            case "look at magazines":
                return "You see a very much used Micky Mouse magazine, a very old and unusable playboy and what seems to be a scrum guide 2009 in mint condition.";
            case "go through door":

            default:
                return
                   "you wake up on the Loo"
                   + "\n"
                   + super.handleCommand(command);
        }

    }

    public String getHelp() {
        return "Try to 'look around', 'look at magazines' (better get your gloves) or just 'go through door' to escape the smell.";
    }
}

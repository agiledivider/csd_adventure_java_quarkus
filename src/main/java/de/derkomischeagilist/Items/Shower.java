package de.derkomischeagilist.Items;

public class Shower {

    private String condition;
    public static final String CONDITION_NEW = "new";
    public static final String CONDITION_USED = "used, but okayish";
    public static final String CONDITION_DEFECT = "defect";
    private boolean turnedOn;

    public Shower(String condition) {
        this.condition = condition;
        this.turnedOn = false;
    }

    public Shower() {
        this.condition = CONDITION_NEW;
        this.turnedOn = false;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void turnOn() {
        this.turnedOn = true;
    }

    public void turnOff() {
        this.turnedOn = false;
    }

    public boolean isTurnedOn() {
        return turnedOn;
    }

    public boolean isTurnedOff() {
        return !this.turnedOn;
    }
}

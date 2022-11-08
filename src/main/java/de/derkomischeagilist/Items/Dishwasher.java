package de.derkomischeagilist.Items;

import org.jboss.resteasy.util.DateUtil;

import java.util.Calendar;
import java.util.Date;

public class Dishwasher {

    String brand;
    String model;
    Date dateOfPurchase;
    Date dateWhenWarrantyEnds;

    Integer maxNumberOfPlates = 12;
    Integer currentNumberOfCleanPlatesLoaded = 0;
    Integer currentNumberOfDirtyPlatesLoaded = 0;

    Integer maxNumberOfCups = 12;
    Integer currentNumberOfCleanCupsLoaded = 0;
    Integer currentNumberOfDirtyCupsLoaded = 0;

    Integer maxNumberOfForks = 12;
    Integer currentNumberOfCleanForksLoaded = 0;
    Integer currentNumberOfDirtyForksLoaded = 0;

    Integer maxNumberOfKnives = 12;
    Integer currentNumberOfCleanKnivesLoaded = 0;
    Integer currentNumberOfDirtyKnivesLoaded = 0;

    Integer maxNumberOfSpoons = 12;
    Integer currentNumberOfCleanSpoonsLoaded = 0;
    Integer currentNumberOfDirtySpoonsLoaded = 0;

    Integer maxNumberOfTeaspoons = 12;
    Integer currentNumberOfCleanTeaspoonsLoaded = 0;
    Integer currentNumberOfDirtyTeaspoonsLoaded = 0;

    public Integer getMaxNumberOfPlates() {
        return maxNumberOfPlates;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getCurrentNumberOfCleanKnivesLoaded() {
        return currentNumberOfCleanKnivesLoaded;
    }

    public Integer loadDirtyKnives(Integer numberOfDirtyKnives) {
        currentNumberOfDirtyKnivesLoaded += numberOfDirtyKnives;
        return currentNumberOfDirtyKnivesLoaded;
    }

    public Boolean couldLoadCutlery(Cutlery cutlery) {
        return (this.currentNumberOfDirtyKnivesLoaded += cutlery.theTotalAmountOfKnivesThatAreInTheKitchenDisregardingTheirState) <= this.maxNumberOfKnives;
    }

    public Dishwasher() {
        this.brand = "ACME";
        this.model = "Superswoosh 9000XR";
        this.dateOfPurchase = new Date();

        // always add 180 days of warranty
        Calendar c = Calendar.getInstance();
        c.setTime(this.dateOfPurchase);
        c.add(Calendar.DATE, 180);
        this.dateWhenWarrantyEnds = c.getTime();
    }

    public void startCleaningAllLoadedDirtyPlatesAndCupsAndForksAndKnivesAndSpoonsAndTeaspoons() {
        this.currentNumberOfCleanPlatesLoaded = this.currentNumberOfDirtyPlatesLoaded;
        this.currentNumberOfDirtyPlatesLoaded = 0;

        this.currentNumberOfCleanCupsLoaded = this.currentNumberOfDirtyCupsLoaded;
        this.currentNumberOfDirtyCupsLoaded = 0;

        this.currentNumberOfCleanForksLoaded = this.currentNumberOfDirtyForksLoaded;
        this.currentNumberOfDirtyForksLoaded = 0;

        this.currentNumberOfCleanKnivesLoaded = this.currentNumberOfDirtyKnivesLoaded;
        this.currentNumberOfDirtyKnivesLoaded = 0;

        this.currentNumberOfCleanSpoonsLoaded = this.currentNumberOfDirtySpoonsLoaded;
        this.currentNumberOfDirtySpoonsLoaded = 0;

        this.currentNumberOfCleanTeaspoonsLoaded = this.currentNumberOfDirtyTeaspoonsLoaded;
        this.currentNumberOfDirtyTeaspoonsLoaded = 0;
    }
}

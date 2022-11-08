package de.derkomischeagilist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AdventureTest {

    private Adventure adventure;

    @BeforeEach
    void setUp() {
        adventure = new Adventure();
    }

    @Test
    void currentTimeLooksGood() {
        assertThat("timestamp", TimeService.currentTime("Europe/Berlin"), greaterThan(-1));
    }

    @Test
    void AdventureStartsOnTheLoo() {
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
    }


    @Test
    void LookingAroundInTheLooThenICanSeeMagazines() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("look around");
        //Then i can see magazines
        assertThat(actual, containsStringIgnoringCase("magazines"));
    }

    @Test
    void LookingAroundInTheLooThenIWillFindScrumDeveloperCard() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("look around");
        //Then i can see magazines
        assertThat(actual, containsStringIgnoringCase("certified scrum developer"));
        assertThat(actual, containsStringIgnoringCase("card"));
    }

    @Test
    void LookingAtMagazinesInTheLooThenICanSeeAScrumGuide() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("look at magazines");
        //Then i can see magazines
        assertThat(actual, containsStringIgnoringCase("scrum guide"));
    }

    @Test
    void LookingAtMagazinesInTheLooThenICanSeeAUsedMickyMouseMagazine() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("look at magazines");
        //Then i can see magazines
        assertThat(actual, containsStringIgnoringCase("used micky mouse magazine"));
    }

    @Test
    void EnteringAnInvalidCommandResultsInHelpfulResponse() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("Do something stupid");
        //Then i can see magazines
        assertThat(actual, containsStringIgnoringCase("invalid command"));
        assertThat(actual, containsStringIgnoringCase("please enter 'help' to get a list of available commands"));
    }

    @Test
    void EnteringAnInvalidCommandStillIncludesPreviousResponse() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("Do something stupid");
        //Then i can see magazines
        assertThat(actual, containsStringIgnoringCase("you wake up on the Loo"));
    }

    @Test
    void GoingThroughDoorInTheLooThenICanSeeTheWashRoom() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When I go into the wash room
        String actual = adventure.tell("go through door");
        //Then i can see the wash room
        assertThat(actual, containsStringIgnoringCase("wash room"));
    }

    @Test
    void LookingAroundInTheWashRoomThenIWillFindDoorAndSink() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When I go into the wash room
        adventure.tell("go through door");
        //When I look around
        String actual = adventure.tell("look around");
        //Then i can see a sink and a door
        assertThat(actual, containsStringIgnoringCase("nasty sink"));
    }

    @Test
    void GoingThroughDoorInTheTeamRoomThenIAmGreetedByMyTeammates() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When I go into the Team Office
        String actual = adventure.tell("use door to team office");
        //Then i am greeted by my teammates
        assertThat(actual, containsStringIgnoringCase("Hey, you moron! ;)"));
    }

    @Test
    void GoingThroughDoorInTheTeamRoomThenMyTeammatesAreSmartAndSmelly() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When I go into the Team Office
        String actual = adventure.tell("use door to team office");
        //Then my teammates are smart
        assertThat(actual, containsStringIgnoringCase("smart"));
        //Then my teammates are smelly
        assertThat(actual, containsStringIgnoringCase("smelly"));
    }

    @Test
    void commandsAreCaseInsensitive() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When I go into the Team Office
        String actual = adventure.tell("uSe DoOr tO tEaM oFfIcE");
        //Then the command leads me to the team room
        assertThat(actual, not(containsStringIgnoringCase("invalid command")));
    }

    @Test
    void lookAroundShowsDodOnTheDoor() {
        //given I am on the washroom
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        adventure.currentRoom = adventure.washroom;
        //When I look around
        String actual = adventure.tell("look around");
        //Then I find the DoD
        assertThat(actual, containsStringIgnoringCase("you notice a dod on the door"));
    }

    @Test
    void readDodShowsDodDetails() {
        //given I am on the washroom
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        adventure.currentRoom = adventure.washroom;
        //When I read the DoD
        String actual = adventure.tell("read dod");
        //Then I find the DoD
        assertThat(actual, containsStringIgnoringCase("hands washed"));
        assertThat(actual, containsStringIgnoringCase("paper towels in bin"));
        assertThat(actual, containsStringIgnoringCase("toilet flushed"));
    }

}

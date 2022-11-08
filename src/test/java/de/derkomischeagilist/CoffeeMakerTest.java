package de.derkomischeagilist;

import de.derkomischeagilist.Items.CoffeeMaker;
import org.junit.jupiter.api.Test;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class CoffeeMakerTest {
    private CoffeeMaker coffeeMaker;

    @Test
    void testCoffeCanNotBeMadeWithoutPower() {
        coffeeMaker = new CoffeeMaker();
        assertThat( coffeeMaker.makeCoffee(), is(false));
        assertThat( coffeeMaker.whatsWrong(), containsString("There is no power connected"));
    }

    @Test
    void testCoffeCanNotBeMadeWithoutCoffeeBeans() {
        coffeeMaker = new CoffeeMaker();
        coffeeMaker.connectPower();
        assertThat( coffeeMaker.makeCoffee(), is(false));
        assertThat( coffeeMaker.whatsWrong(), containsString("There are no coffee beans in the machine"));
    }
    @Test
    void testCoffeCanNotBeMadeWithoutCup() {
        coffeeMaker = new CoffeeMaker();
        coffeeMaker.connectPower();
        coffeeMaker.addCoffeeBeans();
        assertThat( coffeeMaker.makeCoffee(), is(false));
        assertThat( coffeeMaker.whatsWrong(), containsString("There is no cup the machine"));
    }

    @Test
    void testCoffeCanNotBeMadeWithoutWater() {
        coffeeMaker = new CoffeeMaker();
        coffeeMaker.connectPower();
        coffeeMaker.addCoffeeBeans();
        coffeeMaker.putCupIn();
        assertThat( coffeeMaker.makeCoffee(), is(false));
        assertThat( coffeeMaker.whatsWrong(), containsString("There is no water in the machine"));
    }

    @Test
    void testCoffeCanBeMade() {
        coffeeMaker = new CoffeeMaker();
        coffeeMaker.connectPower();
        coffeeMaker.addCoffeeBeans();
        coffeeMaker.putCupIn();
        coffeeMaker.addWater();
        assertThat( coffeeMaker.makeCoffee(), is(true));
    }

    @Test
    void testCommandHandlerAddBeans() {
        coffeeMaker = new CoffeeMaker();
        assertThat(coffeeMaker.handle("add beans"), containsStringIgnoringCase("beans have been added"));
    }

    @Test
    void testCommandHandlerAddWater() {
        coffeeMaker = new CoffeeMaker();
        assertThat(coffeeMaker.handle("add water"), containsStringIgnoringCase("water has been added"));
    }

    @Test
    void testCommandListerFindsCommands() {
        coffeeMaker = new CoffeeMaker();
        assertThat(coffeeMaker.listCommands(), hasItem("add beans"));
    }
}

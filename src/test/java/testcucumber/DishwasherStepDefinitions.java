package testcucumber;

import de.derkomischeagilist.Items.Cutlery;
import de.derkomischeagilist.Items.Dishwasher;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DishwasherStepDefinitions {

    Dishwasher dishwasher;
    Integer lastIntegerResult;
    String lastStringResult;

    @Given("I have a new dishwasher.")
    public void i_have_a_new_dishwasher() {
        this.dishwasher = new Dishwasher();

        assertThat(this.dishwasher, instanceOf(Dishwasher.class));
    }

    @When("I check the maximum plate load count.")
    public void i_check_the_maximum_plate_load_count() {
        i_have_a_new_dishwasher();

        this.lastIntegerResult = this.dishwasher.getMaxNumberOfPlates();
    }

    @Then("I am told {int}.")
    public void i_am_told(Integer int1) {
        assertThat(this.lastIntegerResult, equalTo(int1));
    }

    @When("I read the make plate.")
    public void i_read_the_make_plate() {
        this.lastStringResult = this.dishwasher.getBrand();
    }

    @Then("I am told {string}.")
    public void i_am_told(String string) {
        assertThat(this.lastStringResult, equalTo(string));
    }

    @When("I read the model plate.")
    public void i_read_the_model_plate() {
        this.lastStringResult = this.dishwasher.getModel();
    }

    @When("I load {int} dirty knives.")
    public void i_load_dirty_knives(Integer int1) {
        Integer n = this.dishwasher.loadDirtyKnives(int1);

        assertThat(n, equalTo(int1));
    }

    @When("Start the cleaning.")
    public void start_the_cleaning() {
        this.dishwasher.startCleaningAllLoadedDirtyPlatesAndCupsAndForksAndKnivesAndSpoonsAndTeaspoons();
    }

    @Then("I get {int} clean knives.")
    public void i_get_clean_knives(Integer int1) {
        Integer n = this.dishwasher.getCurrentNumberOfCleanKnivesLoaded();

        assertThat(n, equalTo(int1));
    }

    @Then("I could {int} dirty knives.")
    public void i_could_dirty_knives(Integer int1) {
        Cutlery c = new Cutlery(int1);

        Boolean b = this.dishwasher.couldLoadCutlery(c);

        assertThat(b, equalTo(true));
    }

}

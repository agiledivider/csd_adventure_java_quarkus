package testcucumber;

import de.derkomischeagilist.Items.Dishwasher;
import de.derkomischeagilist.Items.Shower;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

public class ShowerStepDefinitions {

    private Shower shower;
    private String showerCondition;

    @Given("I got a shower")
    public void i_got_a_shower() {
        this.shower = new Shower();

        assertThat(this.shower, instanceOf(Shower.class));
    }

    @When("I check the condition")
    public void i_check_the_condition() {
        this.showerCondition = this.shower.getCondition();
    }

    @Then("I should see that the shower is new")
    public void i_should_see_that_the_shower_is_new() {
        assertThat(this.showerCondition, equalTo(Shower.CONDITION_NEW));
    }

    @Given("I got a shower from a friend")
    public void i_got_a_shower_from_a_friend() {
        this.shower = new Shower(Shower.CONDITION_USED);
    }

    @Then("I should see that the shower is used")
    public void i_should_see_that_the_shower_is_used() {
        assertThat(this.showerCondition, equalTo(Shower.CONDITION_USED));
    }

    @Given("I bought a shower at the flea market")
    public void i_bought_a_shower_at_the_flea_market() {
        this.shower = new Shower(Shower.CONDITION_DEFECT);
    }

    @Then("I should realize that the shower is broken")
    public void i_should_realize_that_the_shower_is_broken() {
        assertThat(this.showerCondition, equalTo(Shower.CONDITION_DEFECT));
    }
}

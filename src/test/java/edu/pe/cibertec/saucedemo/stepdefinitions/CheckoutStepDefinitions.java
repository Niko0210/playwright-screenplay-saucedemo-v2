package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.tasks.CompleteCheckout;
import edu.pe.cibertec.saucedemo.tasks.VerifySummary;
import edu.pe.cibertec.saucedemo.questions.TheCheckout;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class CheckoutStepDefinitions {
    @And("she proceeds to checkout with first name {string}, last name {string} and postal code {string}")
    public void sheProceedsToCheckout(String firstName, String lastName, String postalCode) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompleteCheckout.withData(firstName, lastName, postalCode)
        );
    }

    @And("she verifies the order summary shows item total {string}")
    public void sheVerifiesOrderSummary(String total) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerifySummary.totalIs(total)
        );
    }

    @And("she completes the order")
    public void sheCompletesTheOrder() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompleteCheckout.finish()
        );
    }

    @Then("she should see the confirmation message {string}")
    public void sheShouldSeeConfirmationMessage(String message) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheCheckout.confirmationMessage(), equalTo(message))
        );
    }

    @And("the checkout form should remain visible")
    public void checkoutFormShouldRemainVisible() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheCheckout.formIsVisible(), is(true))
        );
    }

    @Then("she should see the checkout error message {string}")
    public void sheShouldSeeCheckoutErrorMessage(String message) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheCheckout.errorMessage(), equalTo(message))
        );
    }
}

package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;
import net.serenitybdd.screenplay.actors.OnStage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class VerifySummary {
    public static Performable totalIs(String expectedTotal) {
        return Task.where("{0} verifies order summary total",
                actor -> {
                    String actualTotal = Text.of(
                            Target.the("Item total")
                                    .locatedBy(CheckoutPage.ITEM_TOTAL)
                    ).answeredBy(actor);
                    actualTotal = actualTotal.replace("Item total: ", "").trim();
                    assertThat(actualTotal, equalTo(expectedTotal));
                }
        );
    }
}

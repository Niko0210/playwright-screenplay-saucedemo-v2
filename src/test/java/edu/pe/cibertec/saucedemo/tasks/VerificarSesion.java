package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CartPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;
import net.serenitybdd.screenplay.playwright.interactions.Click;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VerificarSesion {
    public static Performable goToCart() {
        return Task.where("{0} goes to cart",
                Click.on(
                        Target.the("Cart")
                                .locatedBy(CartPage.CART_LINK)
                )
        );
    }

    public static Performable backToInventory() {
        return Task.where("{0} returns to inventory",
                actor -> actor.abilityTo(BrowseTheWebWithPlaywright.class)
                        .getCurrentPage()
                        .goBack()
        );
    }

    public static Performable verifySession() {
        return Task.where("{0} verifies session",
                actor -> {
                    var page = actor.abilityTo(BrowseTheWebWithPlaywright.class)
                            .getCurrentPage();
                    assertThat(
                            page.locator("[data-test='title']")
                    ).isVisible();
                    assertThat(
                            page.locator("[data-test='title']")
                    ).containsText("Products");
                }
        );
    }

    public static Performable pageLoadGreaterThan(int milliseconds) {
        return Task.where("{0} verifies page load",
                actor -> {
                    actor.abilityTo(BrowseTheWebWithPlaywright.class)
                            .getCurrentPage()
                            .waitForLoadState();
                }
        );
    }
}

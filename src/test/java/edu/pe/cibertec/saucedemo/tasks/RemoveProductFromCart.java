package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CartPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

public class RemoveProductFromCart {
    public static Performable named(String product){
        return Task.where("{0} removes product " + product,
                Click.on(
                        Target.the("Remove " + product)
                                .locatedBy(CartPage.REMOVE_BUTTON(product))
                )
        );
    }
}

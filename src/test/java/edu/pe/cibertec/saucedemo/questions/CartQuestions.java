package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.CartPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;
import net.serenitybdd.screenplay.playwright.questions.Visibility;

public class CartQuestions {
    public static Question<String> counter(){
        return Text.of(
                Target.the("Cart Counter")
                        .locatedBy(CartPage.CART_BADGE)
        );
    }
    public static Question<Boolean> contains(String product){
        return Visibility.of(
                Target.the(product)
                        .locatedBy(CartPage.PRODUCT_IN_CART(product))
        );
    }
}

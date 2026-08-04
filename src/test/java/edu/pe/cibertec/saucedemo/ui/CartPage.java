package edu.pe.cibertec.saucedemo.ui;

public class CartPage {
    public static final String CART_BADGE = "[data-test='shopping-cart-badge']";
    public static final String CART_LINK = "[data-test='shopping-cart-link']";
    public static String ADD_TO_CART_BUTTON(String product){
        return "//div[text()='" + product + "']/ancestor::div[@class='inventory_item']//button";
    }
    public static String REMOVE_BUTTON(String product){
        return "//div[text()='" + product + "']/ancestor::div[@class='inventory_item']//button[contains(text(),'Remove')]";
    }
    public static String PRODUCT_IN_CART(String product){
        return "//div[@class='cart_item']//div[@data-test='inventory-item-name' and text()='" + product + "']";
    }
}

package io.cucumber.skeleton.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Product {
    private final WebElement webElement;
    private static final By TITLE = By.className("item-name");
    private static final By TITLE_IN_BASKET = By.xpath("mat-cell[contains(@class,'mat-column-product')]");

    private static final By BUTTON = By.cssSelector("button[aria-label=\"Add to Basket\"]");

    public Product(WebElement webElement) {

        this.webElement = webElement;
    }
    public String getProductTitle() {
        return webElement.findElement(TITLE).getText();
    }
    public String getProductInBasketTitle() {
        return webElement.findElement(TITLE_IN_BASKET).getText();
    }

    public void addToBasket() {
         webElement.findElement(BUTTON).click();
    }

}

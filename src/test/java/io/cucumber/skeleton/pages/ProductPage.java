package io.cucumber.skeleton.pages;

import io.cucumber.skeleton.model.Product;
import io.cucumber.skeleton.utils.BaseFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ProductPage {
    private final BaseFunctions baseFunctions;
    private final List<Product> products;

    private static final By SEARCH_QUERY = By.id("searchQuery");
    private static final By ITEM_SEARCH = By.cssSelector("input[id=\"mat-input-0\"]");
    private static final By PRODUCT_ITEM = By.tagName("mat-card");
    private static final By OPEN_BASKET = By.cssSelector("button[aria-label=\"Show the shopping cart\"]");

    public ProductPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
        this.products = baseFunctions.getElements(PRODUCT_ITEM).stream()
                .map(e -> new Product(e)).collect(Collectors.toList());
    }

    public void itemSearch(String text) {
        baseFunctions.clickElement(SEARCH_QUERY);
        baseFunctions.getElement(ITEM_SEARCH).sendKeys(text + Keys.ENTER);
    }

    public void addProductToBasket(String name) {
        products.stream()
                .filter(p -> p.getProductTitle().contains(name))
                .findFirst().ifPresent(p -> p.addToBasket());
    }

    public void openBasket() {
        baseFunctions.clickElement(OPEN_BASKET);
    }
}

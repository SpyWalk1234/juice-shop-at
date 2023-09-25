package io.cucumber.skeleton.pages;

import io.cucumber.skeleton.model.Product;
import io.cucumber.skeleton.utils.BaseFunctions;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class BasketPage {
    private final BaseFunctions baseFunctions;
    private final List<Product> products;

    private static final By BASKET_PRODUCT = By.tagName("mat-row");

    public BasketPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
        try {
            Thread.sleep(5000);//TODO: Replace by Selenium Waits. (At the moment, Waits does not work as expected.)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.products = baseFunctions.getElements(BASKET_PRODUCT).stream()
                .map(e -> new Product(e)).collect(Collectors.toList());
    }

    public boolean productIsPresent(String productName) {
        return products.stream().anyMatch(product -> product.getProductInBasketTitle().toLowerCase().contains(productName.toLowerCase()));
    }
}

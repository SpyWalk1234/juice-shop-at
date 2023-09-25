package io.cucumber.skeleton.pages;

import io.cucumber.skeleton.model.User;
import io.cucumber.skeleton.utils.BaseFunctions;
import org.openqa.selenium.By;

public class LoginPage {
    private final BaseFunctions baseFunctions;

    public LoginPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }
    private static final String LINK_TEXT = "Not yet a customer?";//constant
    private static final By EMAIL_INPUT = By.id("email");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("loginButton");

    public void clickNewCustomerLink() {
        baseFunctions.clickElement(By.linkText(LINK_TEXT));
    }
    public void enterLoginCredentials(User user) {
        baseFunctions.getElement(EMAIL_INPUT).sendKeys(user.getEmail());
        baseFunctions.getElement(PASSWORD_INPUT).sendKeys(user.getPassword());
    }

    public void clickLoginButton() {
        baseFunctions.clickElement(LOGIN_BUTTON);
    }

}

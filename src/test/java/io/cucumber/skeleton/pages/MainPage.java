package io.cucumber.skeleton.pages;

import io.cucumber.skeleton.utils.BaseFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class MainPage {
    private final BaseFunctions baseFunctions;

    public MainPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    private static final String MAIN_PAGE_URL = "http://demo.owasp-juice.shop/#/";//constant
    private static final By CLOSE_POPUP_BUTTON = By.cssSelector("button[aria-label=\"Close Welcome Banner\"]");
    private static final String ACCOUNT_BUTTON_ID = "navbarAccount";
    private static final String LOGIN_BUTTON_ID = "navbarLoginButton";
    private static final By SIDE_MENU = By.cssSelector("button[aria-label=\"Open Sidenav\"]");
    private static final By COMPLAINT_MENU = By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav/div/sidenav/mat-nav-list/a[2]/span/span[3]");

    public void open() {
        baseFunctions.goToUrl(MAIN_PAGE_URL);
    }

    public void closePopup() {
        try {
            Thread.sleep(5000); //TODO: Replace by Selenium Waits. (At the moment, Waits does not work as expected.)
            baseFunctions.clickElement(CLOSE_POPUP_BUTTON);
            System.out.println("Popup closed");
        } catch (NoSuchElementException | InterruptedException ex) {
            System.out.println("No popup");
        }
    }

    public void goToLogin() {
        baseFunctions.clickElement(By.id(ACCOUNT_BUTTON_ID));
        baseFunctions.clickElement(By.id(LOGIN_BUTTON_ID));
    }

    public void sideMenu() {
        baseFunctions.clickElement(SIDE_MENU);
        baseFunctions.clickElement(COMPLAINT_MENU);
    }
}

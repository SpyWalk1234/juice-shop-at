package io.cucumber.skeleton;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.skeleton.model.User;
import io.cucumber.skeleton.pages.*;
import io.cucumber.skeleton.utils.BaseFunctions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {

    private final BaseFunctions baseFunctions = new BaseFunctions();

    @After
    public void tearDown() {
        baseFunctions.closeBrowser();
    }


    @Given("Open Juiceshop main page on web version")
    public void iOpenJuiceShopUrl() {
        MainPage mainPage = new MainPage(baseFunctions);
        mainPage.open();
        mainPage.closePopup();
    }

    @And("I go to Login Page")
    public void iGoToLoginPage() {
        MainPage mainPage= new MainPage(baseFunctions);
        mainPage.goToLogin();
    }

    @And("I go to Registration Page")
    public void iGoToRegistrationPage() {
        LoginPage loginPage = new LoginPage(baseFunctions);
        loginPage.clickNewCustomerLink();
    }

    @And("I register a new user")
    public void iRegisterNewUser() {
        RegistrationPage registrationPage = new RegistrationPage(baseFunctions);
        User user = new User();
        registrationPage.registerUser(user);
    }

    @And("I login to the juice shop")
    public void iLoginToTheJuiceShop() {
        User user = baseFunctions.getLoginUser();
        LoginPage loginPage = new LoginPage(baseFunctions);
        loginPage.enterLoginCredentials(user);
        loginPage.clickLoginButton();
    }

    @And("I open Complaint page")
    public void iOpenSideMenu() {
        MainPage mainPage = new MainPage(baseFunctions);
        mainPage.sideMenu();
    }

    @Then("I see accept message {string}")
    public void iSeeAcceptMessage(String message)  {
        ComplaintPage complaintPage = new ComplaintPage(baseFunctions);
        try {
            Thread.sleep(5000);//TODO: Replace by Selenium Waits. (At the moment, Waits does not work as expected.)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actual = complaintPage.getConfirmationMessage();
        assertTrue(actual.toLowerCase().contains(message.toLowerCase()));
    }

    @And("I enter complain message {string}")
    public void iEnterComplaintMessage(String text) {
        ComplaintPage complaintPage = new ComplaintPage(baseFunctions);
        complaintPage.enterComplain(text);
    }

    @And("I register a new predefined user")
    public void iRegisterNewPredefinedUser() {
        RegistrationPage registrationPage = new RegistrationPage(baseFunctions);
        User user = baseFunctions.getLoginUser();
        registrationPage.registerUser(user);
    }

    @Then("I see error message {string}")
    public void iSeeErrorMessage(String message) {
        RegistrationPage registrationPage = new RegistrationPage(baseFunctions);
        try {
            Thread.sleep(5000);//TODO: Replace by Selenium Waits. (At the moment, Waits does not work as expected.)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actual = registrationPage.getErrorMessage();
        assertEquals(message, actual);
    }

    @And("I search for a {string} product")
    public void iSearchForAnItem(String text) {
        ProductPage productPage = new ProductPage(baseFunctions);
        productPage.itemSearch(text);
    }

    @And("I add {string} to basket")
    public void iAddItemToBasket(String product) {
        baseFunctions.moveToElement();
        ProductPage productPage = new ProductPage(baseFunctions);
        productPage.addProductToBasket(product);
    }

    @And("I open the basket")
    public void iOpenTheBasket() {
        ProductPage productPage = new ProductPage(baseFunctions);
        productPage.openBasket();
    }

    @And("I see {string} in the basket")
    public void iSeeProductInBasket(String product) {
        BasketPage basketPage = new BasketPage(baseFunctions);
        boolean actual = basketPage.productIsPresent(product);
        assertTrue(actual);
    }
}

package io.cucumber.skeleton.pages;

import io.cucumber.skeleton.model.User;
import io.cucumber.skeleton.utils.BaseFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class RegistrationPage {
    private final BaseFunctions baseFunctions;

    public RegistrationPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    private static final By EMAIL = By.id("emailControl");
    private static final By PASSWORD = By.id("passwordControl");
    private static final By REPEAT_PASSWORD = By.id("repeatPasswordControl");
    private static final By TOGGLE = By.xpath("//mat-slide-toggle[contains(@id,'mat-slide-toggle')]");
    private static final By SECURITY_QUESTION = By.name("securityQuestion");
    private static final By SECURITY_QUESTION_OPTIONS = By.tagName("mat-option");
    private static final By SECURITY_ANSWER = By.id("securityAnswerControl");
    private static final By REGISTER_BUTTON = By.id("registerButton");
    private static final By ERROR_MESSAGE = By.className("error");

    private void selectRandomSecurityQuestion() {
        List<WebElement> securityQuestions = baseFunctions.getElements(SECURITY_QUESTION_OPTIONS);
        int randomNumber = new Random().nextInt(securityQuestions.size());
        securityQuestions.get(randomNumber).click();
        try {
            Thread.sleep(5000);//TODO: Replace by Selenium Waits. (At the moment, Waits does not work as expected.)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void registerUser(User user) {
        baseFunctions.getElement(EMAIL).sendKeys(user.getEmail());
        baseFunctions.getElement(PASSWORD).sendKeys(user.getPassword());
        baseFunctions.getElement(REPEAT_PASSWORD).sendKeys(user.repeatPassword());
        baseFunctions.clickElement(TOGGLE);
        baseFunctions.clickElement(SECURITY_QUESTION);
        selectRandomSecurityQuestion();
        baseFunctions.getElement(SECURITY_ANSWER).sendKeys("Lucky Number Slevin");
        baseFunctions.clickElement(REGISTER_BUTTON);
    }

    public String getErrorMessage() {
       return baseFunctions.getElement(ERROR_MESSAGE).getText();
    }
}

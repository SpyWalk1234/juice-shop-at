package io.cucumber.skeleton.pages;

import io.cucumber.skeleton.utils.BaseFunctions;
import org.openqa.selenium.By;

public class ComplaintPage {
    private final BaseFunctions baseFunctions;

    public ComplaintPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }
    private static final By COMPLAINT_MESSAGE = By.id("complaintMessage");
    private static final By SUBMIT_BUTTON = By.id("submitButton");
    private static final By CONFIRMATION_MESSAGE = By.className("confirmation");

    public void enterComplain(String text) {
        baseFunctions.getElement(COMPLAINT_MESSAGE).sendKeys(text);
        baseFunctions.clickElement(SUBMIT_BUTTON);
    }

    public String getConfirmationMessage() {
        try {
            Thread.sleep(5000);//TODO: Replace by Selenium Waits. (At the moment, Waits does not work as expected.)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return baseFunctions.getElement(CONFIRMATION_MESSAGE).getText();
    }
}

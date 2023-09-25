package io.cucumber.skeleton.utils;

import io.cucumber.skeleton.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseFunctions {
    private WebDriver driver;
    private static Properties prop = new Properties();
    private static InputStream input = null;



    public BaseFunctions() {
        this.driver = initializeDriver();

        this.driver.manage().window().maximize();

        ((JavascriptExecutor) this.driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void goToUrl(String url) {
        driver.get(url);
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public WebElement getElement(By locator) {
        //LOGGER.info("Receiving web element");
        return driver.findElement(locator);
    }

    public void closeBrowser () {
        //LOGGER.info("Receiving web element");
       driver.close();
    }

    public List<WebElement> getElements(By locator) {
        //LOGGER.info("Receiving web element");
        return driver.findElements(locator);
    }

    public void clickElement(By locator)  {
        try {
            Thread.sleep(5000); //TODO: Replace by Selenium Waits. (At the moment, Waits does not work as expected.)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        getElement(locator).click();
    }


    private static RemoteWebDriver initializeDriver() {
        String browser = getBrowser();

        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", prop.getProperty("path.to.driver"));
                return new FirefoxDriver();
            case "chrome":
                System.setProperty("webdriver.chrome.driver", prop.getProperty("path.to.driver"));
                return new ChromeDriver();
            default:
                throw new RuntimeException("Invalid browser name");
        }
    }

    private static String getBrowser() {
        String browser = "";
        try {
            InputStream input = BaseFunctions.class.getClassLoader().getResourceAsStream("test.properties");
            prop.load(input);
            browser = prop.getProperty("browser.name");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return browser;
    }

    public User getLoginUser() {
        String login = prop.getProperty("login");
        String password = prop.getProperty("password");
        return new User(login, password);
    }

    public void moveToElement() {
        WebElement element = driver.findElement(By.className("mat-paginator-icon"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }
}

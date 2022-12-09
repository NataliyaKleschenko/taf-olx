package by.itacademy.kleschenko.ui.pages;

import by.itacademy.kleschenko.ui.driver.WebDriverSingleton;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private static final long WAIT_FOR_ELEMENT = 6;
    protected WebDriver driver;
    private static final String URL = "https://www.olx.pl/";

    public BasePage() {
        this.driver = WebDriverSingleton.getDriver();
    }

    public void openPage() {
        driver.navigate().to(URL);
    }

    protected WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    protected void clickOnElement(By locator) {
        driver.findElement(locator).click();
    }

    protected void clickOnElementWithPause(By locator) {
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(locator);
        builder.pause(Duration.ofSeconds(2)).click(element).perform();
    }

    protected void sendTextToForm(By locator, String input) {
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(locator);
        element.clear();
        builder.sendKeys(element, input).build().perform();
    }

    protected String getTextFromWebElement(By locator) {
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.presenceOfElementLocated(locator)));
        return element.getText();
    }
    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
}

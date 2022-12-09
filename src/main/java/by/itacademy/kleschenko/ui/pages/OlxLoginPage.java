package by.itacademy.kleschenko.ui.pages;

import by.itacademy.kleschenko.ui.util.Waiter;
import by.itacademy.kleschenko.user.CorrectUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OlxLoginPage extends BasePage {
    private final By TWOJE_KONTO_LOCATOR = By.id("topLoginLink");
    private final By COOKIE_LOCATOR = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    private final By EMAIL_LOCATOR = By.xpath("//input[@class=' css-1c0rtj6']");
    private final By PASSWORD_LOCATOR = By.xpath("//input[@class='css-1q8s32c']");
    private final By SUBMIT_LOCATOR = By.xpath("//button[@class='css-ohaivz-BaseStyles']");
    // text
    private final By TEXT_FROM_TWOJE_KONTO_LOCATOR = By.xpath("//div[@class='css-1g5leiq']");  ////*[@id='root']/header/div/div/div[2]/div[2]/div/div
    private final By TEXT_FROM_EMAIL_ERROR_LOCATOR = By.xpath("//p[@data-testid='textField-error-message']");
    private final By TEXT_FROM_PASSWORD_ERROR_LOCATOR = By.xpath("//p[@data-testid='password-error-message']");
    private final By TEXT_FROM_ERROR_MESSAGE_LOCATOR = By.xpath("//p[@class='css-rdovvl']");
    private final By CLOSE_SECURITY_BUTTON = By.xpath("//button[@aria-label='Close']");
    //error message
    private final String ERROR_LOGIN_MESSAGE = "Wpisz swój e-mail";
    private final String ERROR_PASSWORD_MESSAGE = "Wpisz hasło";
    private final String NOT_REGISTERED_USER = "Nieprawidłowy login lub hasło";
    private final String TOO_SHORT_PASSWORD = "Masz pewność co do hasła? Jest zbyt krótkie.";
    private final String ERROR_LOGIN_MESSAGE_INVALID_LOGIN = "To nie wygląda jak adres mailowy...";
    private final String ERROR_MESSAGE = "Ups! Coś poszło nie tak...";

    public OlxLoginPage() {
        super();
    }

    public void clickOnTwojeKonto() {
        clickOnElement(TWOJE_KONTO_LOCATOR);
    }

    public void clickToCloseCookie() {
        WebElement cookie = driver.findElement(COOKIE_LOCATOR);
        waitElementIsVisible(cookie).click();
    }

    public void clickToCloseSecurityButton() {
        WebElement security = driver.findElement(CLOSE_SECURITY_BUTTON);
        waitElementIsVisible(security).click();
    }

    public void typeInputEmail(String input) {
        sendTextToForm(EMAIL_LOCATOR, input);
    }

    public void typeInputPassword(String input) {
        sendTextToForm(PASSWORD_LOCATOR, input);
    }

    public void clickOnSubmitButton() {
        clickOnElement(SUBMIT_LOCATOR);
    }

    public String getTextFromEmailErrorLocator() {
        return getTextFromWebElement(TEXT_FROM_EMAIL_ERROR_LOCATOR);
    }

    public String getTextFromPasswordErrorLocator() {
        return getTextFromWebElement(TEXT_FROM_PASSWORD_ERROR_LOCATOR);
    }

    public String getTextFromErrorMessageLocator() {
        return getTextFromWebElement(TEXT_FROM_ERROR_MESSAGE_LOCATOR);
    }

    public String getTextFromTwojeKontoLocator() {
        return driver.findElement(TEXT_FROM_TWOJE_KONTO_LOCATOR).getAttribute("innerHTML");
    }

    public boolean isEmptyEmailAndPasswordFields() {
        if (ERROR_LOGIN_MESSAGE.equals(getTextFromEmailErrorLocator()) && ERROR_PASSWORD_MESSAGE.equals(getTextFromPasswordErrorLocator()))
            return true;
        return false;
    }

    public boolean isValidEmailAndInvalidPassword() {
        if (ERROR_PASSWORD_MESSAGE.equals(getTextFromPasswordErrorLocator()) || TOO_SHORT_PASSWORD.equals(getTextFromPasswordErrorLocator()) || NOT_REGISTERED_USER.equals(getTextFromPasswordErrorLocator()))
            return true;
        return false;
    }

    public boolean isEmptyEmailAndValidPassword() {
        if (ERROR_LOGIN_MESSAGE.equals(getTextFromEmailErrorLocator()) || ERROR_LOGIN_MESSAGE_INVALID_LOGIN.equals(getTextFromEmailErrorLocator()))
            return true;
        return false;
    }

    public boolean isNotRegisteredUser() {
        if (NOT_REGISTERED_USER.equals(getTextFromErrorMessageLocator()) || ERROR_MESSAGE.equals(getTextFromErrorMessageLocator()))
            return true;
        return false;
    }

    public boolean isRegisteredUser() {
        Waiter.unwelcomeWait();
        String userEmailFromElement = getTextFromTwojeKontoLocator().substring(0, 9);
        Waiter.unwelcomeWait();
        System.out.println(userEmailFromElement);
        String userActualEmail = CorrectUser.EMAIL.substring(0, 9);
        if (userEmailFromElement.equals(userActualEmail))
            return true;
        return false;
    }
}

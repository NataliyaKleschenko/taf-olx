package by.itacademy.kleschenko.ui.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OlxModaPage extends BasePage {
    private final By MODA_LOCATOR = By.xpath("//*[@id='searchmain-container']/div[2]/div/div[1]/div[6]/div/a/span[1]"); // клик
    private final By STRELKA_LOCATOR = By.xpath("//div[@class='subcategories-title']//a[@href='https://www.olx.pl/moda/']"); // клик
    private final By CENA_LOCATOR = By.xpath("//p[contains(text(),'Cena')]"); //текст
    private final By PLEC_LOCATOR = By.xpath("//p[contains(text(),'Płeć')]"); //тескт,клик
    private final By PLEC_ARROW_SELECTOR = By.cssSelector("div:nth-child(4) > div > div > div > div > svg"); //клик
    private final By MESKIE = By.xpath("//p[contains(text(),'Męskie')]"); //текст
    private final By DAMSKIE = By.xpath("//p[contains(text(),'Damskie')]"); //текст
    private final By STAN_LOCATOR = By.xpath("//p[contains(text(),'Stan')]"); //текст
    private final By STAN_ARROW_SELECTOR = By.cssSelector("div:nth-child(3) > div > div > div> div > svg"); //клик
    private final By UZYWANE = By.xpath("//p[contains(text(),'Używane')]"); //текст
    private final By NOWE = By.xpath("//p[contains(text(),'Nowe')]"); //текст
    private final By POZOSTALE = By.xpath("//p[contains(text(),'Pozostałe')]"); //текст
    private final By SEARCH = By.id("search"); //send
    private final By CENA_OD = By.xpath("//input[@name='range-from-input']");// //input[@name='range-from-input'] 42
    private final By CENA_DO = By.xpath("//input[@name='range-to-input']");// //input[@name='range-to-input'] 44
    private final By NOWE_CHECKBOX = By.xpath("//form/div[3]/div[1]/div/div[3]/div/div/div[2]/div/div[3]/label/input");
    private final By WOMEN_CHECKBOX = By.xpath("//div/div[2]/div/div[3]/label/input");
    private final By SZUKAJ = By.className("css-angxe8-BaseStyles"); //click
    private final By RESULT_LIST = By.xpath("//a[@class='css-rc5s2u']");
    private final By RESULT_STRING = By.xpath("//div[@data-testid='total-count']"); //количество найденных совпадений, не 0!!!! //h3[@class='css-pqvw3x-Text eu5v0x0']
    public static final String CENA = "Cena";
    public static final String STAN = "Stan";
    public static final String PLEC = "Płeć";
    public static final String UŻYWANE = "Używane";
    public static final String NOWEE = "Nowe";
    public static final String POZOSTAŁE = "Pozostałe";
    public static final String MAN = "Męskie";
    public static final String WOMAN = "Damskie";

    public void clickOnModaLocator() {
        clickOnElementWithPause(MODA_LOCATOR);
    }

    public void clickOnStrelkaLocator() {
        clickOnElementWithPause(STRELKA_LOCATOR);
    }

    public void clickOnPlecLocator() {
        clickOnElementWithPause(PLEC_ARROW_SELECTOR);
    }

    public void clickOnStanLocator() {
        clickOnElementWithPause(STAN_ARROW_SELECTOR);
    }

    public void clickToSearchButton() {
        clickOnElementWithPause(SZUKAJ);
    }

    public void clickToCheckboxStan() {
        clickOnElement(NOWE_CHECKBOX);
    }

    public void clickToPlecCheckbox() {
        clickOnElement(WOMEN_CHECKBOX);
    }

    public void typeStringToInputForm(String input) {
        sendTextToForm(SEARCH, input);
        clickOnElement(SEARCH);
    }

    public void typeSizeFromToInputForm(String input) {
        sendTextToForm(CENA_OD, input);


    }

    public void typeSizeToToInputForm(String input) {
        sendTextToForm(CENA_DO, input);
    }

    public String getTextFromCenaLocator() {
        return getTextFromWebElement(CENA_LOCATOR);
    }

    public String getTextFromPlecLocator() {
        return getTextFromWebElement(PLEC_LOCATOR);
    }

    public String getTextFromMeskieLocator() {
        return getTextFromWebElement(MESKIE);
    }

    public String getTextFromDamskieLocator() {
        return getTextFromWebElement(DAMSKIE);
    }

    public String getTextFromStanLocator() {
        return getTextFromWebElement(STAN_LOCATOR);
    }

    public String getTextFromUzywaneLocator() {
        return getTextFromWebElement(UZYWANE);
    }

    public String getTextFromNoweLocator() {
        return getTextFromWebElement(NOWE);
    }

    public String getTextFromPozostaleLocator() {
        return getTextFromWebElement(POZOSTALE);
    }

    public boolean getResult() {
        List<WebElement> resultElement = driver.findElements(RESULT_LIST);
        for (WebElement elements : resultElement) {
            System.out.println(elements);
            String s = elements.getText();
            String result = "adidas";
            if (StringUtils.containsIgnoreCase(s, result))
                return true;
        }
        return false;
    }
}
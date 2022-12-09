package by.itacademy.kleschenko.ui.steps;

import by.itacademy.kleschenko.ui.pages.OlxModaPage;
import by.itacademy.kleschenko.ui.util.Waiter;

public class OlxModaSteps extends OlxModaPage {
    public void clickOnModaSelectorAndCheckTextInHeader() {
        clickOnModaLocator();
        clickOnStrelkaLocator();
        Waiter.unwelcomeWait();
    }

    public void clickOnModaSelectorAndCheckTextInDropDownStan() {
        clickOnModaLocator();
        clickOnStrelkaLocator();
        Waiter.unwelcomeWait();
        clickOnStanLocator();
        Waiter.unwelcomeWait();
    }

    public void clickOnModaSelectorAndCheckTextInDropDownPlec() {
        clickOnModaLocator();
        clickOnStrelkaLocator();
        Waiter.unwelcomeWait();
        clickOnPlecLocator();
        Waiter.unwelcomeWait();
    }

    public void clickOnModaSelectorAndTypeTextInInputForm(String input, String sizeFrom, String sizeTo) {
        clickOnModaLocator();
        clickOnStrelkaLocator();
        Waiter.unwelcomeWait();
        typeStringToInputForm(input);
        Waiter.unwelcomeWait();
        typeSizeFromToInputForm(sizeFrom);
        Waiter.unwelcomeWait();
        typeSizeToToInputForm(sizeTo);
        Waiter.unwelcomeWait();
        clickOnStanLocator();
        Waiter.unwelcomeWait();
        clickToCheckboxStan();
        Waiter.unwelcomeWait();
        clickOnPlecLocator();
        Waiter.unwelcomeWait();
        clickToPlecCheckbox();
        Waiter.unwelcomeWait();
        clickToSearchButton();
        Waiter.unwelcomeWait();
    }
}

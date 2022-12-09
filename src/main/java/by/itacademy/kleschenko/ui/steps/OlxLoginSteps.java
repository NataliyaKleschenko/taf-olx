package by.itacademy.kleschenko.ui.steps;

import by.itacademy.kleschenko.ui.pages.OlxLoginPage;
import by.itacademy.kleschenko.user.User;

public class OlxLoginSteps extends OlxLoginPage {
    public void loginIn(User user) {
        openPage();
        clickOnTwojeKonto();
        typeInputEmail(user.getEmail());
        typeInputPassword(user.getPassword());
        clickOnSubmitButton();
    }
}

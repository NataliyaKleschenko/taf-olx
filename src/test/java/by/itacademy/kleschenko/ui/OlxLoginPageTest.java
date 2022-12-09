package by.itacademy.kleschenko.ui;

import by.itacademy.kleschenko.ui.pages.OlxLoginPage;
import by.itacademy.kleschenko.ui.steps.OlxLoginSteps;
import by.itacademy.kleschenko.user.RandomUser;
import by.itacademy.kleschenko.user.CorrectUser;
import by.itacademy.kleschenko.user.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OlxLoginPageTest extends BaseTest {
    OlxLoginPage page = new OlxLoginPage();
    @BeforeClass
    public void closeCookie() {
        page.openPage();
        page.clickToCloseCookie();
    }
    @Test//(priority = 0)
    public void testLoginFormWithEmptyFields() {
        OlxLoginSteps steps = new OlxLoginSteps();
        steps.loginIn(new User("", ""));

        Assert.assertTrue(page.isEmptyEmailAndPasswordFields());
    }

    @Test//(priority = 1)
    public void testLoginFormWithValidEmailAndEmptyPassword() {
        OlxLoginSteps steps = new OlxLoginSteps();
        steps.loginIn(new User(CorrectUser.EMAIL, ""));

        Assert.assertTrue(page.isValidEmailAndInvalidPassword());
    }

    @Test//(priority = 2)
    public void testLoginFormWithEmptyEmailAndValidPassword() {
        OlxLoginSteps steps = new OlxLoginSteps();
        steps.loginIn(new User("", CorrectUser.PASSWORD));

        Assert.assertTrue(page.isEmptyEmailAndValidPassword());
    }

    @Test//(priority = 3)
    public void testLoginFormWithInvalidEmailAndValidPassword() {
        OlxLoginSteps steps = new OlxLoginSteps();
        steps.loginIn(new User(CorrectUser.EMAIL.substring(0,4), CorrectUser.PASSWORD));

        Assert.assertTrue(page.isEmptyEmailAndValidPassword());

    }

    @Test//(priority = 4)
    public void testLoginFormWithValidEmailAndTooShortPassword() {
        OlxLoginSteps steps = new OlxLoginSteps();
        steps.loginIn(new User(CorrectUser.EMAIL, CorrectUser.PASSWORD.substring(0,4)));

        Assert.assertTrue(page.isValidEmailAndInvalidPassword());
    }

    @Test//(priority = 5)
    public void testLoginFormWithNotRegisteredUser() {
        OlxLoginSteps steps = new OlxLoginSteps();
        steps.loginIn(new User(RandomUser.createRandomUser().getEmail(), RandomUser.createRandomUser().getPassword()));

        Assert.assertTrue(page.isNotRegisteredUser());
    }


    @Test(priority = 6)
    public void testLoginFormWithValidData() { // Ups! Coś poszło nie tak...
        OlxLoginSteps steps = new OlxLoginSteps();
        steps.loginIn(CorrectUser.getCorrectUser());
        //page.clickToCloseSecurityButton();

        Assert.assertTrue(page.isRegisteredUser());
    }
}

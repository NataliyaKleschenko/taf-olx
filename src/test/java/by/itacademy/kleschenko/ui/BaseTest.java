package by.itacademy.kleschenko.ui;

import by.itacademy.kleschenko.ui.driver.WebDriverSingleton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class BaseTest {
    @AfterTest
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }
}

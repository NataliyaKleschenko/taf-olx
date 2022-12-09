package by.itacademy.kleschenko.ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverSingleton {
    private static WebDriver driver;
    private static final long IMPLICITLY_WAIT = 10;

    private WebDriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage()
                    .window()
                    .maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT));
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}

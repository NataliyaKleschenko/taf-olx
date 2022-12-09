package by.itacademy.kleschenko.ui;

import by.itacademy.kleschenko.ui.pages.OlxLoginPage;
import by.itacademy.kleschenko.ui.pages.OlxModaPage;
import by.itacademy.kleschenko.ui.steps.OlxModaSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OlxModaPageTest extends BaseTest {
    OlxModaPage page = new OlxModaPage();
    OlxLoginPage page1 = new OlxLoginPage(); // !!!!!!!!!!!!!

    @BeforeClass
    public void closeCookie() {
        page.openPage();
        page1.clickToCloseCookie();
    }

    @Test
    public void testClickOnModaSelectorAndCheckTextInHeader() {
        OlxModaSteps step = new OlxModaSteps();
        step.clickOnModaSelectorAndCheckTextInHeader();

        Assert.assertEquals(page.getTextFromCenaLocator(), OlxModaPage.CENA);
        Assert.assertEquals(page.getTextFromStanLocator(), OlxModaPage.STAN);
        Assert.assertEquals(page.getTextFromPlecLocator(), OlxModaPage.PLEC);
    }

    @Test
    public void testClickOnModaSelectorAndCheckTextInDropDownStan() {
        OlxModaSteps step = new OlxModaSteps();
        step.clickOnModaSelectorAndCheckTextInDropDownStan();

        Assert.assertEquals(page.getTextFromUzywaneLocator(), OlxModaPage.UŻYWANE);
        Assert.assertEquals(page.getTextFromNoweLocator(), OlxModaPage.NOWEE);
        Assert.assertEquals(page.getTextFromPozostaleLocator(), OlxModaPage.POZOSTAŁE);
    }
    @Test
    public void testClickOnModaSelectorAndCheckTextInDropDownPlec() {
        OlxModaSteps step = new OlxModaSteps();
        step.clickOnModaSelectorAndCheckTextInDropDownPlec();

        Assert.assertEquals(page.getTextFromMeskieLocator(),OlxModaPage.MAN);
        Assert.assertEquals(page.getTextFromDamskieLocator(),OlxModaPage.WOMAN);
    }
    @Test
    public void testClickOnModaSelectorAndTypeTextInInputForm(){
        String input = "adidas";
        String sizeFrom = "42";
        String sizeTo = "44";
        OlxModaSteps step = new OlxModaSteps();

        step.clickOnModaSelectorAndTypeTextInInputForm(input,sizeFrom,sizeTo);
    }
    @Test
    public void testGetResult() {
        testClickOnModaSelectorAndTypeTextInInputForm();

        Assert.assertTrue(page.getResult());
    }
}

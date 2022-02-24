package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import static com.codeborne.selenide.Selenide.open;

public class SuccessRegistrationTest {

    StellarburgerMainPage mainPage = new StellarburgerMainPage();
    LoginPage loginPage = new LoginPage();
    RegistrationPage registrationPage = new RegistrationPage();

    @Before
    public void testBefore() {
        mainPage = open("https://stellarburgers.nomoreparties.site/", StellarburgerMainPage.class);
        loginPage = open("https://stellarburgers.nomoreparties.site/", LoginPage.class);
        registrationPage = open("https://stellarburgers.nomoreparties.site/", RegistrationPage.class);

    }

    @Test
    public void testSuccsessReistrationUser() {
        mainPage.clickProfileInMainPage();
        loginPage.goToRegistrationPage();
        registrationPage.successRegistration();
        String actual = $(byXpath(".//h2[contains(text(),'Вход')]")).getText();
        String expected = "Вход";
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void wrongReistrationUser() {
        mainPage.clickProfileInMainPage();
        loginPage.goToRegistrationPage();
        registrationPage.wrongRegistration();
        String actual = $(byXpath(".//*[contains(text(),'Некорректный пароль')]")).getText();
        String expected = "Некорректный пароль";
        Assert.assertEquals(expected,actual);

    }

}

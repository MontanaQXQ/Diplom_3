package site.nomoreparties.stellarburgers.YandexTests;


import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.LoginPage;
import site.nomoreparties.stellarburgers.RegistrationPage;
import site.nomoreparties.stellarburgers.StellarburgerMainPage;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationYandexTest {

    StellarburgerMainPage mainPage = new StellarburgerMainPage();
    LoginPage loginPage = new LoginPage();
    RegistrationPage registrationPage = new RegistrationPage();

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        mainPage = open("https://stellarburgers.nomoreparties.site/", StellarburgerMainPage.class);
        loginPage = open("https://stellarburgers.nomoreparties.site/", LoginPage.class);
        registrationPage = open("https://stellarburgers.nomoreparties.site/", RegistrationPage.class);

    }

    @After
    public void tearDown(){
        webdriver().driver().close();
    }
    @DisplayName("Кейс Проверь Успешную регистрацию.")
    @Test
    public void testSuccsessReistrationUser()  {
        mainPage.clickPersonalProfileInMainPage();
        loginPage.goToRegistrationPage();
        registrationPage.successRegistration();
        String actual = $(byXpath(".//h2[contains(text(),'Вход')]")).getText();
        String expected = "Вход";
        Assert.assertEquals(expected,actual);


    }
    @DisplayName("Кейс Проверь Ошибку для некорректного пароля. Минимальный пароль — шесть символов.")
    @Test
    public void wrongReistrationUser() {
        mainPage.clickPersonalProfileInMainPage();
        loginPage.goToRegistrationPage();
        registrationPage.wrongRegistrationYandex();
        String actual = $(byXpath(".//*[contains(text(),'Некорректный пароль')]")).getText();
        String expected = "Некорректный пароль";
        Assert.assertEquals(expected,actual);


    }

}

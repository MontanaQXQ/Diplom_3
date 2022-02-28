package site.nomoreparties.stellarburgers.ChromeTests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.LoginPage;
import site.nomoreparties.stellarburgers.RegistrationPage;
import site.nomoreparties.stellarburgers.StellarburgerMainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;


public class RegistrationTest {

    StellarburgerMainPage mainPage = new StellarburgerMainPage();
    LoginPage loginPage = new LoginPage();
    RegistrationPage registrationPage = new RegistrationPage();

    @Before
    public void setUp() {
        mainPage = open("https://stellarburgers.nomoreparties.site/", StellarburgerMainPage.class);
        loginPage = open("https://stellarburgers.nomoreparties.site/", LoginPage.class);
        registrationPage = open("https://stellarburgers.nomoreparties.site/", RegistrationPage.class);

    }

    @After
    public void tearDown() {
        webdriver().driver().close();

    }

    @DisplayName("Кейс Проверь Успешную регистрацию.")
    @Test
    public void testSuccsessReistrationUser() {
        mainPage.clickPersonalProfileInMainPage();
        loginPage.goToRegistrationPage();
        registrationPage.successRegistration();
        String actual = loginPage.headTextLoginGetText();
        String expected = "Вход";
        Assert.assertEquals("Ошибка. Текст не совпадает с ожидаемым", expected, actual);

    }

    @DisplayName("Кейс Проверь Ошибку для некорректного пароля. Минимальный пароль — шесть символов.")
    @Test
    public void wrongReistrationUser() {
        mainPage.clickPersonalProfileInMainPage();
        loginPage.goToRegistrationPage();
        registrationPage.wrongRegistration();
        String actual = registrationPage.wrongPasswordMessageGetText();
        String expected = "Некорректный пароль";
        Assert.assertEquals("Ошибка. Отсутствует exeption message - (Некорректный пароль)", expected, actual);

    }

}
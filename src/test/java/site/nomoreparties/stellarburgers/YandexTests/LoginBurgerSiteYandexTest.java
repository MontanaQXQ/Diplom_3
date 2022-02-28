package site.nomoreparties.stellarburgers.YandexTests;


import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.ForgotPasswordPage;
import site.nomoreparties.stellarburgers.LoginPage;
import site.nomoreparties.stellarburgers.RegistrationPage;
import site.nomoreparties.stellarburgers.StellarburgerMainPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;


public class LoginBurgerSiteYandexTest {

    public String userEmail;
    public String userPassword;
    UserOperations userOperations = new UserOperations();
    StellarburgerMainPage mainPage = new StellarburgerMainPage();
    LoginPage loginPage = new LoginPage();
    RegistrationPage registrationPage = new RegistrationPage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        mainPage = open("https://stellarburgers.nomoreparties.site/", StellarburgerMainPage.class);
        loginPage = open("https://stellarburgers.nomoreparties.site/", LoginPage.class);
        registrationPage = open("https://stellarburgers.nomoreparties.site/", RegistrationPage.class);
        forgotPasswordPage = open("https://stellarburgers.nomoreparties.site/", ForgotPasswordPage.class);


        Map<String, String> userData = userOperations.register();
        userEmail = userData.get("email");
        userPassword = userData.get("password");
    }

    @After
    public void tearDown() {
        userOperations.delete();
        webdriver().driver().close();

    }

    @DisplayName("Кейс Проверь вход по кнопке «Войти в аккаунт» на главной.")
    @Test
    public void testEnterAccountButton() {
        mainPage.clickEnterAccountButtonInMainPage();
        loginPage.successLogin(userEmail, userPassword);
        String actual = mainPage.createOrderButtonGetText();
        String expected = "Оформить заказ";
        Assert.assertEquals("Ошибка. Текст не совпадает с ожидаемым", expected, actual);
    }

    @DisplayName("Кейс Проверь вход через кнопку «Личный кабинет»")
    @Test
    public void testEnterPersonalProfileButton() {
        mainPage.clickPersonalProfileInMainPage();
        loginPage.successLogin(userEmail, userPassword);
        String actual = mainPage.createOrderButtonGetText();
        String expected = "Оформить заказ";
        Assert.assertEquals("Ошибка. Текст не совпадает с ожидаемым", expected, actual);
    }

    @DisplayName("Кейс Проверь вход через кнопку в форме регистрации")
    @Test
    public void testEnterButtonInRegistraionPage() {
        mainPage.clickPersonalProfileInMainPage();
        loginPage.goToRegistrationPage();
        registrationPage.clickEnterButton();
        loginPage.successLogin(userEmail, userPassword);
        String actual = mainPage.createOrderButtonGetText();
        String expected = "Оформить заказ";
        Assert.assertEquals("Ошибка. Текст не совпадает с ожидаемым", expected, actual);
    }

    @DisplayName("Кейс Проверь вход через кнопку в форме восстановления пароля")
    @Test
    public void testEnterButtonForgotPasswordPage() {
        mainPage.clickPersonalProfileInMainPage();
        loginPage.clickForgotPasswordButton();
        forgotPasswordPage.clickEnterButton();
        loginPage.successLogin(userEmail, userPassword);
        String actual = mainPage.createOrderButtonGetText();
        String expected = "Оформить заказ";
        Assert.assertEquals("Ошибка. Текст не совпадает с ожидаемым", expected, actual);
    }

}

package site.nomoreparties.stellarburgers.ChromeTests;
import com.UserOperations;

import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.qameta.allure.junit4.DisplayName;
import site.nomoreparties.stellarburgers.AccountProfilePage;
import site.nomoreparties.stellarburgers.LoginPage;
import site.nomoreparties.stellarburgers.StellarburgerMainPage;


import java.util.Map;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class AuthUserPersonalProfileTest {

    UserOperations userOperations = new UserOperations();
    StellarburgerMainPage mainPage = new StellarburgerMainPage();
    LoginPage loginPage = new LoginPage();
    AccountProfilePage accountProfilePage = new AccountProfilePage();

    public String userEmail;
    public String userPassword;

    @Before
    public void setUp() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        mainPage = open("https://stellarburgers.nomoreparties.site/", StellarburgerMainPage.class);
        loginPage = open("https://stellarburgers.nomoreparties.site/", LoginPage.class);
        accountProfilePage = open("https://stellarburgers.nomoreparties.site/", AccountProfilePage.class);

        Map<String, String> userData = userOperations.register();
        userEmail = userData.get("email");
        userPassword = userData.get("password");
    }

    @After
    public void tearDown(){
        userOperations.delete();
        webdriver().driver().close();

    }
    @DisplayName("Кейс Проверь переход по клику на «Личный кабинет»")
    @Test
    public void  testEnterPersonalProfile() {
        mainPage.clickEnterAccountButtonInMainPage();
        loginPage.successLogin(userEmail,userPassword);
        mainPage.clickPersonalProfileInMainPage();
        String actual = $(byXpath("//*[contains(text(),'Выход')]")).getText();
        String expected = "Выход";
        Assert.assertEquals(expected,actual);
    }
    @DisplayName("Кейс Проверь переход по клику на «Конструктор».")
    @Test
    public void  testGoToConstructorFromPersonalProfile() {
        mainPage.clickEnterAccountButtonInMainPage();
        loginPage.successLogin(userEmail,userPassword);
        mainPage.clickPersonalProfileInMainPage();
        mainPage.clickConstructorButton();
        String actual = $(byXpath("//*[contains(text(),'Соберите бургер')]")).getText();
        String expected = "Соберите бургер";
        Assert.assertEquals(expected,actual);
    }

    @DisplayName("Кейс Проверь переход по клику на логотип Stellar Burgers.")
    @Test
    public void  testGoToMainPageIfClicLogoFromPersonalProfile() {
        mainPage.clickEnterAccountButtonInMainPage();
        loginPage.successLogin(userEmail,userPassword);
        mainPage.clickPersonalProfileInMainPage();
        mainPage.clickStellarBurgersButton();
        String actual = $(byXpath("//*[contains(text(),'Соберите бургер')]")).getText();
        String expected = "Соберите бургер";
        Assert.assertEquals(expected,actual);
    }

    @DisplayName("Кейс Проверь выход по кнопке «Выйти» в личном кабинете.")
    @Test
    public void  testExitFromPersonalProfile() {
        mainPage.clickEnterAccountButtonInMainPage();
        loginPage.successLogin(userEmail,userPassword);
        mainPage.clickPersonalProfileInMainPage();
        accountProfilePage.clickExitButton();
        String actual = $(byXpath("//*[contains(text(),'Вход')]")).getText();
        String expected = "Вход";
        Assert.assertEquals(expected,actual);
    }

}

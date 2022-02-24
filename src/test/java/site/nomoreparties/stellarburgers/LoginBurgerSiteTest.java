package site.nomoreparties.stellarburgers;


import com.UserOperations;
import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import java.util.Map;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class LoginBurgerSiteTest {

    UserOperations userOperations = new UserOperations();
    StellarburgerMainPage mainPage = new StellarburgerMainPage();
    LoginPage loginPage = new LoginPage();
    RegistrationPage registrationPage = new RegistrationPage();
    ForgotPasswordPage forgotPasswordPage =new ForgotPasswordPage();

    public String userEmail;
    public String userPassword;


    @Before
    public void setUp() {
        Configuration.holdBrowserOpen = true;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        mainPage = open("https://stellarburgers.nomoreparties.site/", StellarburgerMainPage.class);
        loginPage = open("https://stellarburgers.nomoreparties.site/", LoginPage.class);
        registrationPage = open("https://stellarburgers.nomoreparties.site/", RegistrationPage.class);
        forgotPasswordPage = open("https://stellarburgers.nomoreparties.site/", ForgotPasswordPage.class);


        Map<String, String> userData = userOperations.register();
        userEmail = userData.get("email");
        userPassword = userData.get("password");
    }

    @Test
    public void  testEnterAccountButton() {
        mainPage.clickEnterAccountButtonInMainPage();
        loginPage.successLogin(userEmail,userPassword);
        String actual = $(byXpath("//*[contains(text(),'Оформить заказ')]")).getText();
        String expected = "Оформить заказ";
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void  testEnterPersonalProfileButton() {
        mainPage.clickPersonalProfileInMainPage();
        loginPage.successLogin(userEmail,userPassword);
        String actual = $(byXpath("//*[contains(text(),'Оформить заказ')]")).getText();
        String expected = "Оформить заказ";
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void  testEnterButtonInRegistraionPage() {
        mainPage.clickPersonalProfileInMainPage();
        loginPage.goToRegistrationPage();
        registrationPage.clickEnterButton();
        loginPage.successLogin(userEmail,userPassword);
        String actual = $(byXpath("//*[contains(text(),'Оформить заказ')]")).getText();
        String expected = "Оформить заказ";
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void  testEnterButtonForgotPasswordPage() {
        mainPage.clickPersonalProfileInMainPage();
        loginPage.clickForgotPasswordButton();
        forgotPasswordPage.clickEnterButton();
        loginPage.successLogin(userEmail,userPassword);
        String actual = $(byXpath("//*[contains(text(),'Оформить заказ')]")).getText();
        String expected = "Оформить заказ";
        Assert.assertEquals(expected,actual);
    }




    @After
    public void tearDown(){
        userOperations.delete();

    }

}

package site.nomoreparties.stellarburgers.ChromeTests;

import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.StellarburgerMainPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;

public class ConstructorTest {

    public String userEmail;
    public String userPassword;
    UserOperations userOperations = new UserOperations();
    StellarburgerMainPage mainPage = new StellarburgerMainPage();

    @Before
    public void setUp() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        mainPage = open("https://stellarburgers.nomoreparties.site/", StellarburgerMainPage.class);

        Map<String, String> userData = userOperations.register();
        userEmail = userData.get("email");
        userPassword = userData.get("password");
    }

    @After
    public void tearDown() {
        userOperations.delete();
        webdriver().driver().close();
    }

    @DisplayName("Кейс Проверь, что работают переходы к разделам:«Соусы»")
    @Test
    public void testClickSauceInConstructor() {
        mainPage.clickSauce();
        String actual = mainPage.sauceHeadGetText();
        String expected = "Соусы";
        Assert.assertEquals("Ошибка. Текст не совпадает с ожидаемым", expected, actual);
    }

    @DisplayName("Кейс Проверь, что работают переходы к разделам:«Булки»")
    @Test
    public void testClickBunInConstructor() {
        mainPage.clickSauce();
        mainPage.clickBun();
        String actual = mainPage.bunHeadGetText();
        String expected = "Булки";
        Assert.assertEquals("Ошибка. Текст не совпадает с ожидаемым", expected, actual);
    }

    @DisplayName("Кейс Проверь, что работают переходы к разделам:«Начинки»")
    @Test
    public void testClickFillingInConstructor() {
        mainPage.clickFilling();
        String actual = mainPage.fillingHeadGetText();
        String expected = "Начинки";
        Assert.assertEquals("Ошибка. Текст не совпадает с ожидаемым", expected, actual);
    }

}
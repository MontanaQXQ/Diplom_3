package site.nomoreparties.stellarburgers.YandexTests;

import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.StellarburgerMainPage;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;

public class ConstructorYandexTest {

    UserOperations userOperations = new UserOperations();
    StellarburgerMainPage mainPage = new StellarburgerMainPage();
    public String userEmail;
    public String userPassword;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        mainPage = open("https://stellarburgers.nomoreparties.site/", StellarburgerMainPage.class);

        Map<String, String> userData = userOperations.register();
        userEmail = userData.get("email");
        userPassword = userData.get("password");
    }

    @After
    public void tearDown(){
        userOperations.delete();
        webdriver().driver().close();
    }
    @DisplayName("Кейс Проверь, что работают переходы к разделам:«Соусы»")
    @Test
    public void  testClickSauceInConstructor() {
        mainPage.clickSauce();
    }

    @DisplayName("Кейс Проверь, что работают переходы к разделам:«Булки»")
    @Test
    public void  testClickBunInConstructor() throws InterruptedException {
        mainPage.clickSauce();
        TimeUnit.SECONDS.sleep(5);
        mainPage.clickBun();
    }

    @DisplayName("Кейс Проверь, что работают переходы к разделам:«Начинки»")
    @Test
    public void  testClickFillingInConstructor() {
        mainPage.clickFilling();
    }


}

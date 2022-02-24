package site.nomoreparties.stellarburgers;

import com.UserOperations;
import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import java.util.Map;
import static com.codeborne.selenide.Selenide.*;

import java.util.concurrent.TimeUnit;

public class ConstructorTest {

    UserOperations userOperations = new UserOperations();
    StellarburgerMainPage mainPage = new StellarburgerMainPage();
    public String userEmail;
    public String userPassword;

    @Before
    public void setUp() {
        Configuration.holdBrowserOpen = true;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        mainPage = open("https://stellarburgers.nomoreparties.site/", StellarburgerMainPage.class);

        Map<String, String> userData = userOperations.register();
        userEmail = userData.get("email");
        userPassword = userData.get("password");
    }

    @After
    public void tearDown(){
        userOperations.delete();
    }

    @Test
    public void  testClickSauceInConstructor() {
        mainPage.clickSauce();
    }

    @Test
    public void  testClickBunInConstructor() throws InterruptedException {
        mainPage.clickSauce();
        TimeUnit.SECONDS.sleep(5);
        mainPage.clickBun();
    }

    @Test
    public void  testClickFillingInConstructor() {
        mainPage.clickFilling();
    }


}

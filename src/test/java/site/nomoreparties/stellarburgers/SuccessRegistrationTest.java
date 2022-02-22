package site.nomoreparties.stellarburgers;

import com.UserOperations;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class SuccessRegistrationTest {

   // UserOperations userOperations = new UserOperations();
  //  public String userEmail;
  //  public String userPassword;

    StellarburgerMainPage mainPage = new StellarburgerMainPage();
    LoginPage loginPage = new LoginPage();

    @Before
    public void testBefore() {
        Configuration.holdBrowserOpen = true;
        mainPage = open("https://stellarburgers.nomoreparties.site/", StellarburgerMainPage.class);
        loginPage = open("https://stellarburgers.nomoreparties.site/", LoginPage.class);

//        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
//        Map<String, String> userData = userOperations.register();
//        userEmail = userData.get("email");
//        userPassword = userData.get("password");

    }

    @Test
    public void testOrderingScooterFirstStep() {
        mainPage.clickProfileInMainPage();
        loginPage.check();
    }


//    @After
//    public void CreateUserE(){
//        userOperations.delete();
//
//    }

}

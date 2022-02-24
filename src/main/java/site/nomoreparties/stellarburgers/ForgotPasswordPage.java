package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ForgotPasswordPage {

    //Локатор кнопки войти , которая переводит на страницу логин
    @FindBy(how = How.XPATH,using = ".//a[@href='/login']")
    private SelenideElement enterLoginPage;

    //Локатор слова Восстановление пароля в заголовке
    @FindBy(how = How.XPATH,using = ".//h2[contains(text(),'Восстановление пароля')]")
    private SelenideElement headTextForgotPassword;


    public  void clickEnterButton(){
        headTextForgotPassword.shouldBe(exist);
        enterLoginPage.shouldBe(visible).click();


    }
}

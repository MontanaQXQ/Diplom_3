package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    //В
    @FindBy(how = How.XPATH,using = ".//input[@type='text']")
    private SelenideElement EmailPlaceHolder;

    @FindBy(how = How.XPATH,using = ".//a[@href='/register']")
    private SelenideElement enterRegistrationPage;

    @FindBy(how = How.XPATH,using = ".//h2[contains(text(),'Вход')]")
    private SelenideElement headTextEnter;


    public void check()  {
        headTextEnter.shouldBe(exist);
        enterRegistrationPage.click();//Работает
    }
}

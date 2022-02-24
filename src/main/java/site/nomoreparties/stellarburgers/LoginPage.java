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

    //окатор поля ввода Email
    @FindBy(how = How.XPATH,using = ".//input[@type='text']")
    private SelenideElement emailPlaceHolder;

    //Локатор поля ввода пароля
    @FindBy(how = How.XPATH,using = ".//input[@type='password']")
    private SelenideElement passwordPlaceHolder;

    //Локатор кнопки Зарегесрироваться
    @FindBy(how = How.XPATH,using = ".//a[@href='/register']")
    private SelenideElement enterRegistrationPage;

    //Локатор слова Вход в заголовке
    @FindBy(how = How.XPATH,using = ".//h2[contains(text(),'Вход')]")
    private SelenideElement headTextLogin;

    //для кейса Регистрация пользователя
    public void goToRegistrationPage()  {
        headTextLogin.shouldBe(exist);
        enterRegistrationPage.click();//Работает
    }
}

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

    //Локатор кнопки "Войти"
    @FindBy(how = How.XPATH,using = "//*[contains(text(),'Войти')]")
    private SelenideElement enterAccountButton;

    //для кейса Регистрация пользователя
    public void goToRegistrationPage()  {
        headTextLogin.shouldBe(exist);
        enterRegistrationPage.click();//Работает
    }

    //Метод заполнения Email
    public void setEmail(String email){
        emailPlaceHolder.setValue(email);
    }

    //Метод заполнения Пароля
    public void setPassword(String password){
        passwordPlaceHolder.setValue(password);
    }

    public void enterAccount(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    public void successLogin(String email, String password){
        headTextLogin.shouldBe(exist);
        enterAccount(email,password);
        enterAccountButton.click();
    }
}

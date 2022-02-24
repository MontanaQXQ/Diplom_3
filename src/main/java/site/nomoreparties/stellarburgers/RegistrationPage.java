package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Locale;

import static com.codeborne.selenide.Condition.*;

public class RegistrationPage {

    //Локатор поля ввода Name
    @FindBy(how = How.XPATH,using = ".//input[@name='name']")
    private SelenideElement namelPlaceHolder;

    //Локатор поля ввода Email
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement emailPlaceHolder;

    //Локатор поля ввода Пароля
    @FindBy(how = How.XPATH, using = ".//input[@type='password']")
    private SelenideElement passwordPlaceHolder;

    //Локатор слова Регистрация
    @FindBy(how = How.XPATH,using = ".//h2[contains(text(),'Регистрация')]")
    private SelenideElement headTextRegistration;

    //Локатор кнопки Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//*[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registrButton;

    //Локатор ошибки Некорректный пароль
    @FindBy(how = How.XPATH, using = ".//*[contains(text(),'Некорректный пароль')]")
    private SelenideElement wrongPasswordMessage;

    //Метод заполнения Имени
    public void setName(String name){
        namelPlaceHolder.setValue(name);
    }

    //Метод заполнения Email
    public void setEmail(String email){
        emailPlaceHolder.setValue(email);
    }

    //Метод заполнения Пароля
    public void setPassword(String password){
        passwordPlaceHolder.setValue(password);

    }

    public void correctFillingRegistrationForm() {
        setName(RandomStringUtils.randomAlphabetic(6).toLowerCase(Locale.ROOT));
        setEmail(RandomStringUtils.randomAlphabetic(6).toLowerCase(Locale.ROOT) + "@yandex.ru");
        setPassword(RandomStringUtils.random(6,true,true));
    }

    public void inCorrectFillingRegistrationForm() {
        setName(RandomStringUtils.randomAlphabetic(6).toLowerCase(Locale.ROOT));
        setEmail(RandomStringUtils.randomAlphabetic(6).toLowerCase(Locale.ROOT) + "@yandex.ru");
        setPassword(RandomStringUtils.random(5,true,true));
    }

    public void successRegistration(){
        headTextRegistration.shouldBe(exist);
        correctFillingRegistrationForm();
        registrButton.click();


    }

    public void wrongRegistration(){
        headTextRegistration.shouldBe(exist);
        inCorrectFillingRegistrationForm();
        registrButton.click();
        wrongPasswordMessage.shouldBe(exist);


    }


}
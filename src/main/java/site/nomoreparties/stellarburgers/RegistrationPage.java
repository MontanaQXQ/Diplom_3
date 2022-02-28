package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Locale;

import static com.codeborne.selenide.Condition.visible;

public class RegistrationPage {


    String chord = Keys.chord(Keys.CONTROL, "a");
    //Локатор поля ввода Name
    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement namelPlaceHolder;
    //Локатор поля ввода Email
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement emailPlaceHolder;
    //Локатор поля ввода Пароля
    @FindBy(how = How.XPATH, using = ".//input[@type='password']")
    private SelenideElement passwordPlaceHolder;
    //Локатор слова Регистрация
    @FindBy(how = How.XPATH, using = ".//h2[contains(text(),'Регистрация')]")
    private SelenideElement headTextRegistration;
    //Локатор кнопки Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//*[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registrButton;
    //Локатор ошибки Некорректный пароль
    @FindBy(how = How.XPATH, using = ".//*[contains(text(),'Некорректный пароль')]")
    private SelenideElement wrongPasswordMessage;
    //Локатор кнопки войти , которая переводит на страницу логин
    @FindBy(how = How.XPATH, using = ".//a[@href='/login']")
    private SelenideElement enterLoginPage;

    //Метод заполнения Имени
    public void setName(String name) {
        namelPlaceHolder.setValue(name);
    }

    //Метод заполнения Email
    public void setEmail(String email) {
        emailPlaceHolder.setValue(email);
    }

    //Метод заполнения Пароля
    public void setPassword(String password) {
        passwordPlaceHolder.setValue(password);

    }

    @Step("Метод  корректного заполнения формы регистрации.")
    public void correctFillingRegistrationForm() {
        setName(RandomStringUtils.randomAlphabetic(6).toLowerCase(Locale.ROOT));
        setEmail(RandomStringUtils.randomAlphabetic(6).toLowerCase(Locale.ROOT) + "@yandex.ru");
        setPassword(RandomStringUtils.random(6, true, true));
    }

    @Step("Метод  некорректного заполнения формы регистрации , длинна пароля меньше положенного.")
    public void inCorrectFillingRegistrationForm() {
        setName(RandomStringUtils.randomAlphabetic(6).toLowerCase(Locale.ROOT));
        setEmail(RandomStringUtils.randomAlphabetic(6).toLowerCase(Locale.ROOT) + "@yandex.ru");
        setPassword(RandomStringUtils.random(5, true, true));
    }

    @Step("Метод  упешной регистрации пользовател.")
    public void successRegistration() {
        correctFillingRegistrationForm();
        registrButton.shouldBe(visible).click();


    }

    @Step("Метод  неправильнйо регистрации с возникающей ошибкой Некорректный пароль.")
    public void wrongRegistration() {
        inCorrectFillingRegistrationForm();
        registrButton.shouldBe(visible).click();
    }

    @Step("Метод  получения текста ошибки (Некорректный пароль).")
    public String wrongPasswordMessageGetText() {
        return wrongPasswordMessage.getText();
    }


    //Методы для Яндекс браузера.
    //Яндекс браузер сохраняет пароль и Почтовый адрес и вставляет их автоматически как только открывается форма регистрации
    //Для этого я создал такой костыльный вариант, что бы удалять автоподставления яндекса в плэйсхолдерах
    //Я не знаю как отключить эту настройку в запускаемом yandexdriver браузере

    @Step("Метод  нажатия кнопки войти на странице регистрации.")
    public void clickEnterButton() {
        enterLoginPage.shouldBe(visible).click();
    }

    @Step("Метод некорректного заполнения формы регистрации для Yandex.Browser , длинна пароля меньше положенного.")
    public void inCorrectFillingRegistrationFormYandex() {
        namelPlaceHolder.sendKeys(chord, Keys.BACK_SPACE);
        setName(RandomStringUtils.randomAlphabetic(6).toLowerCase(Locale.ROOT));
        emailPlaceHolder.sendKeys(chord, Keys.BACK_SPACE);
        setEmail(RandomStringUtils.randomAlphabetic(6).toLowerCase(Locale.ROOT) + "@yandex.ru");
        passwordPlaceHolder.sendKeys(chord, Keys.BACK_SPACE);
        setPassword(RandomStringUtils.random(5, true, true));
    }

    @Step("Метод  метод неправильнйо регистрации в Yandex.Browser с возникающей ошибкой Некорректный пароль.")
    public void wrongRegistrationYandex() {
        inCorrectFillingRegistrationFormYandex();
        registrButton.shouldBe(visible).click();
    }

}
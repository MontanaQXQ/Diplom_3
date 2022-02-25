package site.nomoreparties.stellarburgers;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.*;
import io.qameta.allure.Step;



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

    //Локатор кнопки Зарегесрироваться
    @FindBy(how = How.XPATH,using = ".//a[@href='/forgot-password']")
    private SelenideElement enterForgotPasswordPage;




    public void setEmail(String email){
        emailPlaceHolder.setValue(email);
    }


    public void setPassword(String password){
        passwordPlaceHolder.setValue(password);
    }

    @Step("Метод перехода на страницу Регистрации")
    public void goToRegistrationPage()  {
        headTextLogin.shouldBe(exist);
        enterRegistrationPage.click();
    }

    @Step("Метод заполнения формы на странице Логин.")
    public void enterAccount(String email, String password) {
        setEmail(email);
        setPassword(password);
    }
    @Step("Метод  Успешного входа в Личный кабинет Пользователя.")
    public void successLogin(String email, String password){
        headTextLogin.shouldBe(exist);
        enterAccount(email,password);
        enterAccountButton.click();
    }

    @Step("Метод  клика на кнопку Восстановить пароль.")
    public void clickForgotPasswordButton(){
        headTextLogin.shouldBe(exist);
        enterForgotPasswordPage.shouldBe(visible).click();
    }

}

package site.nomoreparties.stellarburgers;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;


public class ForgotPasswordPage {

    //Локатор кнопки войти , которая переводит на страницу логин
    @FindBy(how = How.XPATH, using = ".//a[@href='/login']")
    private SelenideElement enterLoginPage;

    //Локатор слова Восстановление пароля в заголовке
    @FindBy(how = How.XPATH, using = ".//h2[contains(text(),'Восстановление пароля')]")
    private SelenideElement headTextForgotPassword;

    @Step("Метод клика по кнопке Войти на странице Восстановления Пароля")
    public void clickEnterButton() {
        enterLoginPage.shouldBe(visible).click();
    }
}

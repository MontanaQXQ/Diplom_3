package site.nomoreparties.stellarburgers;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class AccountProfilePage {

    //Локатор кнопки Выход в Личном кабинете
    @FindBy(how = How.XPATH, using = ".//*[contains(text(),'Выход')]")
    private SelenideElement exittButton;

    @Step("Метод клика по кнопке Выход в личном кабинете")
    public void clickExitButton() {
        exittButton.shouldBe(visible).click();
    }

    @Step("Метод получения текста локатора кнопки - (Выход) в личном кабинете")
    public String exitButtonGetText() {
        return exittButton.getText();
    }
}
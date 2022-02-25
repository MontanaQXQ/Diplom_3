package site.nomoreparties.stellarburgers;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.*;
import io.qameta.allure.Step;

public class AccountProfilePage {

    //Локатор кнопки Выход в Личном кабинете
    @FindBy(how = How.XPATH, using = ".//*[contains(text(),'Выход')]")
    private SelenideElement exittButton;

    @Step("Метод клика по кнопке Выход в личном кабинете")
    public void clickExitButton(){
        exittButton.shouldBe(visible).click();
    }
}
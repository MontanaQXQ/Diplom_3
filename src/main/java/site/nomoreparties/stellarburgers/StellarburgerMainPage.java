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

public class StellarburgerMainPage {

    //Локатор кнопки "Личный Кабинет"
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Личный Кабинет')]")
    private SelenideElement enterLoginPagePersonalProfile;

    //Локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Войти в аккаунт')]")
    private SelenideElement enterLoginPageEnterButton;

    //Локатор кнопки "Оформить заказ"
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Оформить заказ')]")
    private SelenideElement createOrderButton;




    public void clickProfileInMainPage() {
        enterLoginPagePersonalProfile.shouldBe(visible).click();
    }
    public void clickEnterAccountButtonInMainPage() {
        enterLoginPageEnterButton.shouldBe(visible).click();
    }
}

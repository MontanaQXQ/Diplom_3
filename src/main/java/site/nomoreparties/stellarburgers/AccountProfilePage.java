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

public class AccountProfilePage {

    //Локатор кнопки Выход в Личном кабинете
    @FindBy(how = How.XPATH, using = ".//*[contains(text(),'Выход')]")
    private SelenideElement exittButton;

    public void clickExitButton(){
        exittButton.shouldBe(visible).click();
    }
}

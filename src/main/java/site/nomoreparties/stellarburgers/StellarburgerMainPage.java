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

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Личный Кабинет')]")
    private SelenideElement enterLoginPage;

    public void clickProfileInMainPage() {
        enterLoginPage.shouldBe(visible).click();

    }
}

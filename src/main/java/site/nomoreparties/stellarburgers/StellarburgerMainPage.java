package site.nomoreparties.stellarburgers;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.*;

public class StellarburgerMainPage {

    //Локатор кнопки "Личный Кабинет"
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Личный Кабинет')]")
    private SelenideElement enterLoginPagePersonalProfile;

    //Локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Войти в аккаунт')]")
    private SelenideElement enterLoginPageEnterAccountButton;

    //Локатор кнопки "Оформить заказ"
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Оформить заказ')]")
    private SelenideElement createOrderButton;

    //Локатор кнопки "Конструктор"
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Конструктор')]")
    private SelenideElement constructorButton;

    //локатор кнопки булки
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Булки')]")
    private SelenideElement bunButton;

    //локатор кнопки соусы
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Соусы')]")
    private SelenideElement sauceButton;

    //локатор кнопки Начинки
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Начинки')]")
    private SelenideElement fillingButton;

    //Локатор Заголовка раздела Булки
    @FindBy(how = How.XPATH, using = ".//h2[contains(text(),'Булки')]")
    private SelenideElement headTextBun;

    //Локатор Заголовка раздела Соусы
    @FindBy(how = How.XPATH, using = ".//h2[contains(text(),'Соусы')]")
    private SelenideElement headTextSauce;

    //Локатор Заголовка раздела Соусы
    @FindBy(how = How.XPATH, using = ".//h2[contains(text(),'Начинки')]")
    private SelenideElement headTextFilling;

    // Логотип Stellar Burgers
    @FindBy (how = How.XPATH, using = "//*[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement stellarBurgersButton;








    @Step("Метод  клика по кнопке Личный кабинет.")
    public void clickPersonalProfileInMainPage() {
        enterLoginPagePersonalProfile.shouldBe(exist);
        enterLoginPagePersonalProfile.shouldBe(visible).click();
    }
    @Step("Метод  клика по кнопке Войти в Аккаунт.")
    public void clickEnterAccountButtonInMainPage() {
        enterLoginPageEnterAccountButton.shouldBe(visible).click();
    }

    @Step("Метод клика по кнопке Конструктор.")
    public void clickConstructorButton() {
        constructorButton.shouldBe(visible).click();
    }

    @Step("Метод клика по логотипу Stellar Burgers.")
    public void clickStellarBurgersButton() {
        constructorButton.shouldBe(visible).click();
    }

    @Step("Методклика по кнопке Соусы.")
    public void clickSauce() {
        sauceButton.shouldBe(visible).click();
        headTextSauce.shouldBe(visible);
    }

    @Step("Методклика по кнопке Булки.")
    public void clickBun() {
        bunButton.shouldBe(visible).click();
        headTextBun.shouldBe(visible);
    }

    @Step("Методклика по кнопке Начинки.")
    public void clickFilling() {
        fillingButton.shouldBe(visible).click();
        headTextFilling.shouldBe(visible);
    }

}


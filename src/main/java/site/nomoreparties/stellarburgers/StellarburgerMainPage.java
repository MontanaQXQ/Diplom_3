package site.nomoreparties.stellarburgers;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

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
    @FindBy(how = How.XPATH, using = "//*[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement stellarBurgersButton;

    // Логотип Stellar Burgers
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Соберите бургер')]")
    private SelenideElement headLogoConstructBurger;


    @Step("Метод  клика по кнопке Личный кабинет.")
    public void clickPersonalProfileInMainPage() {
        enterLoginPagePersonalProfile.shouldBe(visible).click();
    }

    @Step("Метод  клика по кнопке Войти в Аккаунт.")
    public void clickEnterAccountButtonInMainPage() {
        enterLoginPageEnterAccountButton.shouldBe(visible).click();
    }

    @Step("Метод клика по кнопке Конструктор.")
    public void clickConstructorButton() {
        constructorButton.shouldHave(exist).click();
    }

    @Step("Метод клика по логотипу Stellar Burgers.")
    public void clickStellarBurgersButton() {
        constructorButton.shouldHave(exist).click();
    }

    @Step("Методклика по кнопке Соусы.")
    public void clickSauce() {
        sauceButton.shouldHave(exist).click();
    }

    @Step("Метод получения текста Соусы.")
    public String sauceHeadGetText() {
        return headTextSauce.getText();
    }

    @Step("Методклика по кнопке Булки.")
    public void clickBun() {
        bunButton.shouldHave(exist).click();

    }

    @Step("Метод получения текста Булки.")
    public String bunHeadGetText() {
        return headTextBun.getText();
    }

    @Step("Методклика по кнопке Начинки.")
    public void clickFilling() {
        fillingButton.shouldHave(exist).click();
    }

    @Step("Метод получения текста Начинки.")
    public String fillingHeadGetText() {
        return headTextFilling.getText();
    }

    @Step("Метод получения текста локатора - (Собери бургер)")
    public String headLogoConstructBurgerGetText() {
        return headLogoConstructBurger.getText();
    }

    @Step("Метод получения текста Оформить Заказ.")
    public String createOrderButtonGetText() {
        return createOrderButton.getText();
    }

}


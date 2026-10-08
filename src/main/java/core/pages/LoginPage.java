package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private SelenideElement usernameField =$("[name='st.email']");
    private SelenideElement passwordField =$("[name='st.password']");
    private SelenideElement loginButton =$("button[data-test-id='enter-action']");
    private SelenideElement forgotPasswordLink=$("[data-test-id='forgot-password-link']");
    private SelenideElement registrationButton=$("[data-test-id='registration-action']");

    // локаторы для кнопок соц сетей
    private SelenideElement vkButton =$("[data-l='t,vkc']");
    private SelenideElement mailRuButton =$("i[role='img'].__mailru");
    private SelenideElement yandexButton =$("i[role='img'].__yandex");

    //локатор для элемента с сообщением об ошибке входа
    private  SelenideElement errorMessage = $("span[data-test-id='login-form-error']");

    // Локатор для перехода к восстановлению
    private SelenideElement goToRecoveryButton = $("a[data-test-id='recovery-action']");
    {
        VerifyPageElements();
    }
    @Step("Проверяем видимость всех элементов страницы")
    private void VerifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);
        vkButton.shouldBe(visible);
        mailRuButton.shouldBe(visible);
        yandexButton.shouldBe(visible);
    }
    @Step("Проверяем видимость сообщения об ошибке входа")
    public boolean isErrorMassageVisible(){
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMassageText(){
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Вход на сайт с логином: {username} и {password}")
    public void login(String username, String password){
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Вход на сайт с логином: {username} и без пароля")
    public void loginWithoutPassword(String username){
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        loginButton.shouldBe(visible).click();
    }
    @Step("Вход на сайт с паролем {password} без логина")
    public void setPassword(String password){
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Кликаем на кнопку Войти")
    public void clickLogin() {
        loginButton.shouldBe(visible).click();
    }

    @Step("Переходим на страницу восстановления пароля")
    public void openFogotPasswordPage(){
        forgotPasswordLink.shouldBe(visible).click();
    }

    @Step("Преходим на страницу регистрации")
    public void openRegistrationPage(){
        registrationButton.shouldBe(visible).click();
    }

    //Методы для перехода на страницы авторизации через соцсети
    @Step("Входим на сайт через ВКонтакте")
    public void loginWithVK(){
        vkButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через mail.ru")
    public void loginWithMailRu(){
        mailRuButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Yandex")
    public void loginWithYandex(){
        yandexButton.shouldBe(visible).click();
    }

    @Step("Нажимаем восстановить профиль")
    public void goToRecovery(){
        goToRecoveryButton.shouldBe(visible).click();
    }
}

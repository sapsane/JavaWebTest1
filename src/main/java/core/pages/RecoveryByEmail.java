package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryByEmail extends BasePage {
    private SelenideElement emailField = $("input[id='field_email']");
    private SelenideElement getCodeButton =$("input[data-l='t,submit']");

    // невидимое поле c ошибкой о вводе email
    private SelenideElement errorMassage3= $("div.input-e");

    {
        VerifyPageElements();
    }
    @Step("Проверяем видимость всех элементов страницы")
    private void VerifyPageElements() {
        emailField.shouldBe(visible);
        getCodeButton.shouldBe(visible);
    }
    @Step("Проверяем видимость сообщения об ошибке входа")
    public boolean isErrorMassageEmailVisible() {
        return errorMassage3.shouldBe(visible).exists();
    }
    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMassageEmail() {
        return errorMassage3.shouldBe(visible).getText();
    }
    @Step("Кликаем на кнопку 'получить код'")
    public void clickButtonGetCodeByEmail(){
        getCodeButton.shouldBe(visible).click();
    }
    @Step("Вводим адрес Email")
    public void enterEmail(String email) {
        emailField.shouldBe(visible).click();
        emailField.shouldBe(visible).setValue(email);
    }

}

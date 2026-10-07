package core.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnonymRecoveryPage {
    private SelenideElement recoveryByPhoneButton = $("a[data-l='t,phone']");
    private SelenideElement recoveryByEmailButton = $("a[data-l='t,email']");
    private SelenideElement goToSupportButton = $("a[data-l='t,support']");

    {
        VerifyPageElements();
    }
    @Step("Проверяем видимость всех элементов страницы")
    private void VerifyPageElements() {
        recoveryByPhoneButton.shouldBe(visible);
        recoveryByEmailButton.shouldBe(visible);
        goToSupportButton.shouldBe(visible);
    }

    @Step("нажимаем на кнопку восстановления через телефон")
    public void goToRecoveryByPhone() {
        recoveryByPhoneButton.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку восстановления через почту")
    public void goToRecoveryByEmail(){
        recoveryByEmailButton.shouldBe(visible).click();
    }

    @Step("Переходим к технической поддержке")
    public void goToSupport(){
        goToSupportButton.shouldBe(visible).click();
    }
}

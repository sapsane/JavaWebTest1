package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.nio.file.Files.exists;

public class AnonymRecoveryPage extends BasePage {
    private SelenideElement recoveryByPhoneButton = $("a[data-l='t,phone']");
    private SelenideElement recoveryByEmailButton = $("a[data-l='t,email']");
    private SelenideElement goToSupportButton = $("a[data-l='t,support']");
    private SelenideElement closeSupportChat = $("span[data-icon-name='ico_close_16']");
    private SelenideElement confirmChatClosure = $x("//button[.//text()='Да']");
    private SelenideElement openChatWindow = $("div.support_chat_user-name");
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

    @Step("Закрыть чат с поддержкой")
    public void setCloseSupportChat(){
        closeSupportChat.shouldBe(visible).click();
    }
    @Step("Подтверждение закрытия чата с поддержкой")
    public void confirmCloseChatSupport(){
        confirmChatClosure.shouldBe(visible).click();
    }
    @Step("открытие окна чата с поддержкой")
    public boolean setOpenChatWindow(){
        return openChatWindow.shouldBe(visible).exists();
    }
    @Step("закрытие окна чата с поддержкой")
    public boolean setCloseChatWindow(){
        return openChatWindow.shouldNotBe(visible).exists();
    }
}

//RecoveryByPhone
package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryByPhone extends BasePage {
    // локаторы
    private SelenideElement phoneField =$("input[name='st.r.phone']");
    private SelenideElement country =$("input[tsid='phone-form_input_d363f7']");
    private SelenideElement GetCodeButton =$("input[data-l='t,submit']");

    //локатор для элемента с сообщением об ошибке ввода телефона
    private  SelenideElement errorMessage = $("div.input-e.js-ph-vl-hint");
    {
        VerifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    private void VerifyPageElements() {
        phoneField.shouldBe(visible);
        country.shouldBe(visible);
        GetCodeButton.shouldBe(visible);
    }
    @Step("Проверяем видимость сообщения об ошибке входа")
    public boolean isErrorMassageTelePhoneVisible() {
        return errorMessage.shouldBe(visible).exists();
    }
    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMassageCodeSMS(){
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Кликаем на кнопку 'получить код'")
    public void clickGetCodeByPhone() {
        GetCodeButton.shouldBe(visible).click();
    }

    @Step("Вводим номер телефона")
    public void enterPhoneNumber(String phone) {
        phoneField.shouldBe(visible).click();
        phoneField.shouldBe(visible).setValue(phone);
    }

    @Step("выбираем код страны по названию: {countryName}")
    public String selectCountryByName(String countryName) {
        country.shouldBe(visible).click();
        // находим нужную страну по названию
        SelenideElement countryItem = $(String.format(".country-select_i[data-name='%s']", countryName));
        countryItem.scrollTo();
        //прокручиваем к стране и выбираем ее
        String countryCode = countryItem.find(".country-select_code").text();
        countryItem.click();

        return countryCode;
    }
}

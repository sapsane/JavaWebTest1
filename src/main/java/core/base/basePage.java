package core.base;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public abstract class basePage {
    // Примеры общих элементов, которые могут использоваться на разных страницах
    protected SelenideElement headerLogo= $("[name='logo-text']");
    protected SelenideElement searchField= $("input#search-input");




}

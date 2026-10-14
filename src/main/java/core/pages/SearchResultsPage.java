package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage extends BasePage {
    private final SelenideElement groupsSection = $("a[data-l='t,userAltGroup'][data-active='true']");

    public SearchResultsPage() {
        groupsSection.shouldBe(visible);
    }

    @Step("выделеная вкладка группы отображается")
    public boolean isGroupSectionVisible() {
        return groupsSection.shouldBe(visible).exists();
    }
}

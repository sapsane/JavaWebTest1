package tests;

import core.base.BasePage;
import core.base.BaseTest;
import core.pages.LoginPage;
import core.pages.SearchResultsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchForGroupsTest extends BaseTest {
    private static LoginPage loginPage;
    private static BasePage basePage;
    @BeforeEach
    public void prepare(){
        open(baseUrl);
        loginPage = new LoginPage();
    }
    @Test
    @DisplayName("Поиск групп")
    public void searchForGroups() {
    loginPage.searchGroup1("тестировщик");
    loginPage.searchWithSuggestion("тестировщик");
    // В тесте два независимых признака перехода: адрес и содержимое

    SearchResultsPage resultsPage = new SearchResultsPage(); // и раздел групп виден
    webdriver().shouldHave(urlContaining("/groups")); // адрес страницы содержит /groups
    boolean actual=resultsPage.isGroupSectionVisible();
    assertTrue (actual,"Выделенное меню группы, не отображается");
    }
}

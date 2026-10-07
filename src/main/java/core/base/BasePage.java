package core.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public abstract class BasePage {
    // Примеры общих элементов, которые могут использоваться на разных страницах
    protected SelenideElement headerLogo= $("a[tsid='toolbar_logo']");
    protected SelenideElement searchField= $("#hook_Block_Header input[name='st.query']");
    protected SelenideElement vkServices = $("div[data-l='t,vk_ecosystem']");

    @Step("выполняем поиск по сайту с запросом: {query}")
    public void  search(String query){
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }

    @Step("открываем VK Services")
    public void openVkServices(){
        vkServices.shouldBe(visible).click();
    }

    @Step("Кликаем на логотип ОК")
        public  void clickLogo(){
            headerLogo.shouldBe(visible).click();
        }
    // другие общие методы, например, для загрузки страницы, аворизации и т.д.


}

package core.base;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public abstract class basePage {
    // Примеры общих элементов, которые могут использоваться на разных страницах
    protected SelenideElement headerLogo= $("a[tsid='toolbar_logo']");
    protected SelenideElement searchField= $("#hook_Block_Header input[name='st.query']");
    protected SelenideElement vkServices = $("div[data-l='t,vk_ecosystem']")

    // метод для  поиска по сайту
    public void  search(String query){
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }

    // Пример общего метода для клика по иконке уведомлений
    public void openVkServices(){
        vkServices.shouldBe(visible).click();
    }

    // Клик на логотип ОК
        public  void clickLogo(){
            headerLogo.shouldBe(visible).click();
        }
    // другие общие методы, например, для загрузки страницы, аворизации и т.д.


}

package tests;

import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoToCustomerSupportTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;

    @BeforeEach
    public void prepare(){
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    @DisplayName("Переход к службе поддержки")
    public void goToCustomerSupport() {
        loginPage.iCanNotLogIn2();
        anonymRecoveryPage= new AnonymRecoveryPage();
        anonymRecoveryPage.goToSupport();
        boolean openChatWindow = anonymRecoveryPage.setOpenChatWindow();
        assertTrue(openChatWindow,"открытие чата с поддержкой не произошло");
        anonymRecoveryPage.setCloseSupportChat();
        anonymRecoveryPage.confirmCloseChatSupport();
        boolean openChatWindow2 = anonymRecoveryPage.setCloseChatWindow();
        assertFalse(openChatWindow2,"закрытие чата с поддержкой не произошло");
    }
}

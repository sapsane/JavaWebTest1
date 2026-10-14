package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QRCodeLoginVerificationTest extends BaseTest {
    private static LoginPage loginPage;

    @BeforeEach
    public void prepare(){
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    @DisplayName("QR-CODE отображение")
    public void qrCodeLoginVerification() {
        loginPage.loginQR_CodeTab();
        boolean actualQR_Image=loginPage.isQrCodeImageVisible();
        assertTrue(actualQR_Image,"QR-code не отображается");
    }
}

//AnonymRecoveryTest
package tests;

import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.LoginPage;
import core.pages.RecoveryByEmail;
import core.pages.RecoveryByPhone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnonymRecoveryTest extends BaseTest {

    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static RecoveryByPhone recoveryByPhone;
    private static RecoveryByEmail recoveryByEmail;

    @BeforeEach
    public void prepare(){
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    @DisplayName("восстановление логина и пароля")
    public void anonymRecoveryTest(){
        // Попытка входа с некорректными даннами
        loginPage.login("incorrectUser","incorrectPassword");

        for (int i= 0; i < 2; i++){
            loginPage.setPassword("1");
        }

        loginPage.goToRecovery();
        anonymRecoveryPage= new AnonymRecoveryPage();
    }


    @Test
    @DisplayName("восстановление логина и пароля по номеру телефона")
    public void recoveryByPhoneTest(){

        // Попытка входа с некорректными даннами
        loginPage.login("incorrectUser","incorrectPassword");

        for (int i= 0; i < 2; i++){
            loginPage.setPassword("1");
        }

        loginPage.goToRecovery();
        anonymRecoveryPage= new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByPhone();

        recoveryByPhone = new RecoveryByPhone();

        String countryCode=recoveryByPhone.selectCountryByName("Алжир");
        String expectCountrycode="+213";
        assertEquals(expectCountrycode,countryCode,"код страны не совпадает с ожидаемым");

        //recoveryByPhone.enterPhoneNumber("929");

        recoveryByPhone.clickGetCodeByPhone();
        String expectErrortext = "Неправильный номер телефона.";
        recoveryByPhone.isErrorMassageTelePhoneVisible();
        String actualErrorMessage= recoveryByPhone.getErrorMassageCodeSMS();
        assertEquals(expectErrortext,actualErrorMessage,"сообщение не совпадает об ошибке номера телефона");

    }

    @Test
    @DisplayName("восстановление логина и пароля по почте email")
    public void recoveryByEmailTest() {
// Попытка входа с некорректными даннами
        loginPage.login("incorrectUser", "incorrectPassword");

        for (int i = 0; i < 2; i++) {
            loginPage.setPassword("1");
        }

        loginPage.goToRecovery();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByEmail();

        recoveryByEmail = new RecoveryByEmail();
        recoveryByEmail.enterEmail("test");
        recoveryByEmail.clickButtonGetCodeByEmail();
        recoveryByEmail.isErrorMassageEmailVisible();
        String expectErrortext="Неправильный формат почты";
        String actualErrorMessage=recoveryByEmail.getErrorMassageEmail();
        assertEquals(expectErrortext,actualErrorMessage,"текст ошибки не совпадает");
    }
}

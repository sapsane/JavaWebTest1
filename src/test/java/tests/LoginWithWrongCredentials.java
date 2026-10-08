package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithWrongCredentials extends BaseTest {
    private static LoginPage loginPage;

    @BeforeEach
    public void prepare(){
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test

    public void loginWithWrongCredentials() {
        // попытка входа с не корректными данными
        loginPage.login("incorrectUser","incorrectPassword");

        // проверка наличия сообщения об ошибке
        assertTrue(loginPage.isErrorMassageVisible(),"Сообщение об ошибке не отображается");

        // проверка текста сообщения об ошибке
        String expectedErrorMassage = "Неправильно указан логин и/или пароль";
        String actualErrorMessage= loginPage.getErrorMassageText();
        assertEquals(expectedErrorMassage, actualErrorMessage,"Текст сообщения об ошибке не совпадает");
    }

    @Test
    @DisplayName("Логин без пароля")
    public void loginWithOutPassword(){
        loginPage.loginWithoutPassword("incorrectUser");

        // проверка наличия сообщения об ошибке
        assertTrue(loginPage.isErrorMassageVisible(),"Сообщение об ошибке не отображается");

        // проверка текста сообщения об ошибке
        String expectedErrorMassage = "Введите пароль";
        String actualErrorMessage= loginPage.getErrorMassageText();
        assertEquals(expectedErrorMassage, actualErrorMessage,"Текст сообщения об ошибке не совпадает");
    }
    @Test
    @DisplayName("Пароль без логина")
    public void passwordWithOutLogin() {
        loginPage.setPassword("incorrectPassword");

        // проверка наличия сообщения об ошибке
        assertTrue(loginPage.isErrorMassageVisible(), "Сообщение об ошибке не отображается");

        String expectedErrorMassage = "Введите логин";
        String actualErrorMessage = loginPage.getErrorMassageText();
        assertEquals(expectedErrorMassage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }
}

import io.qameta.allure.junit4.DisplayName;
import models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AuthorizationTest extends WebDriverSettings {

    @Before
    public void registrationUser() {
        user = User.generateCorrectUser();
        homePage.openHomePage();
        homePage.clickPersonalAccountButton();
        authorizationPage.clickRegistrationButton();
        registrationPage.register(user);
    }

    @Test
    @DisplayName("Вход по кнопке Войти в аккаунт")
    public void userLoginWithButtonLoginTest() {
        homePage.openHomePage();
        homePage.clickLoginButton();
        authorizationPage.loginToUserAccount(user);
        assertTrue("Оформить заказ", homePage.waitOrderButton());
    }

    @Test
    @DisplayName("Вход по кнопке Личный Кабинет")
    public void userLoginWithButtonPersonalAccountTest() {
        homePage.openHomePage();
        homePage.clickPersonalAccountButton();
        authorizationPage.loginToUserAccount(user);
        assertTrue("Оформить заказ", homePage.waitOrderButton());
    }

    @Test
    @DisplayName("Вход по кнопке в форме регистрации")
    public void userLoginWithButtonRegistrationForm() {
        homePage.openHomePage();
        homePage.clickPersonalAccountButton();
        authorizationPage.clickRegistrationButton();
        registrationPage.clickLoginButton();
        authorizationPage.loginToUserAccount(user);
        assertTrue("Оформить заказ", homePage.waitOrderButton());
    }

    @Test
    @DisplayName("Вход по кнопке в форме восстановления пароля")
    public void userLoginWithButtonPasswordRecoveryFormTest() {
        homePage.openHomePage();
        homePage.clickPersonalAccountButton();
        authorizationPage.clickRecoverPasswordButton();
        recoverPasswordPage.clickLoginButton();
        authorizationPage.loginToUserAccount(user);
        assertTrue("Оформить заказ", homePage.waitOrderButton());
    }
}

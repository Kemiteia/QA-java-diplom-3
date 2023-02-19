import io.qameta.allure.junit4.DisplayName;
import models.User;
import org.junit.Test;
import static org.junit.Assert.*;

public class TransferToPersonalAccountTest extends WebDriverSettings {

    @Test
    @DisplayName("Переход авторизованного пользователя в Личный кабинет с главной страницы")
    public void transferToPersonalAccOnHomePageAuthUserTest() {
        user = User.generateCorrectUser();
        homePage.openHomePage();
        homePage.clickPersonalAccountButton();
        authorizationPage.clickRegistrationButton();
        registrationPage.register(user);
        homePage.openHomePage();
        homePage.clickLoginButton();
        authorizationPage.loginToUserAccount(user);
        homePage.clickPersonalAccountButton();
        assertEquals("В этом разделе вы можете изменить свои персональные данные", personalAccountPage.getPersonalAccountInfo());
    }

    @Test
    @DisplayName("Переход авторизованного пользователя в Личный кабинет со страницы Лента Заказов")
    public void transferToPersonalAccOnFeedOrderPageAuthUserTest() {
        user = User.generateCorrectUser();
        homePage.openHomePage();
        homePage.clickPersonalAccountButton();
        authorizationPage.clickRegistrationButton();
        registrationPage.register(user);
        homePage.openHomePage();
        homePage.clickLoginButton();
        authorizationPage.loginToUserAccount(user);
        homePage.clickOrderFeedButton();
        homePage.clickPersonalAccountButton();
        assertEquals("В этом разделе вы можете изменить свои персональные данные", personalAccountPage.getPersonalAccountInfo());
    }

    @Test
    @DisplayName("Переход неавторизованного пользователя в Личный кабинет с Главной страницы")
    public void transferToPersonalAccOnHomePageUnauthUserTest() {
        homePage.openHomePage();
        homePage.clickPersonalAccountButton();
        assertNotEquals(personalAccountPage.getPersonalAccountURL(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход неавторизованного пользователя в Личный кабинет со страницы Лента Заказов")
    public void  transferToPersonalAccOnFeedOrderPageUnauthUserTest() {
        homePage.openHomePage();
        homePage.clickOrderFeedButton();
        homePage.clickPersonalAccountButton();
        assertNotEquals(personalAccountPage.getPersonalAccountURL(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход неавторизованного пользователя в Личный кабинет со страницы авторизации")
    public void transferToPersonalAccOnAuthorizationPageUnauthUserTest() {
        homePage.openHomePage();
        homePage.clickLoginButton();
        authorizationPage.clickPersonalAccountButton();
        assertNotEquals(personalAccountPage.getPersonalAccountURL(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход неавторизованного пользователя в Личный кабинет со страницы регистрации")
    public void transferToPersonalAccOnRegistrationPageUnauthUserTest() {
        homePage.openHomePage();
        homePage.clickLoginButton();
        authorizationPage.clickRegistrationButton();
        registrationPage.clickPersonalAccountButton();
        assertNotEquals( personalAccountPage.getPersonalAccountURL(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход неавторизованного пользователя в Личный кабинет со страницы восстановления пароля")
    public void transferToPersonalAccOnRecoverPasswordPageUnauthdUserTest() {
        homePage.openHomePage();
        homePage.clickLoginButton();
        authorizationPage.clickRecoverPasswordButton();
        recoverPasswordPage.clickPersonalAccountButton();
        assertNotEquals(personalAccountPage.getPersonalAccountURL(), driver.getCurrentUrl());
    }
}

import io.qameta.allure.junit4.DisplayName;
import models.User;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RegistrationTest extends WebDriverSettings {

    @Test
    @DisplayName("Успешная регистрация пользователя")
    public void successfulUserRegistrationTest() {
        user = User.generateCorrectUser();
        homePage.openHomePage();
        homePage.clickPersonalAccountButton();
        authorizationPage.clickRegistrationButton();
        registrationPage.register(user);
        authorizationPage.waitAuthorizationPageToLoad();
        authorizationPage.loginToUserAccount(user);
        homePage.clickPersonalAccountButton();
        personalAccountPage.waitPersonalAccountToLoad();
        assertEquals("В этом разделе вы можете изменить свои персональные данные", personalAccountPage.getPersonalAccountInfo());
    }

    @Test
    @DisplayName("Ошибка при регистрации с некорректным паролем. Минимальный пароль — шесть символов.")
    public void unsuccessfulUserRegistrationTest() {
        user = User.generateIncorrectUser();
        homePage.openHomePage();
        homePage.clickPersonalAccountButton();
        authorizationPage.clickRegistrationButton();
        registrationPage.register(user);
        assertEquals("Некорректный пароль", registrationPage.getErrorMessage());
    }
}

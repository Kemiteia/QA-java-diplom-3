import io.qameta.allure.junit4.DisplayName;
import models.User;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LogOutPersonalAccountTest extends WebDriverSettings {

    @Test
    @DisplayName("Выход из аккаунта")
    public void logOutPersonalAccountTest() {
        user = User.generateCorrectUser();
        homePage.openHomePage();
        homePage.clickPersonalAccountButton();
        authorizationPage.clickRegistrationButton();
        registrationPage.register(user);
        homePage.openHomePage();
        homePage.clickLoginButton();
        authorizationPage.loginToUserAccount(user);
        homePage.clickPersonalAccountButton();
        personalAccountPage.clickLogOutPersonalAccountButton();
        authorizationPage.waitAuthorizationPageToLoad();
        assertEquals(authorizationPage.getAuthorizationURL(), driver.getCurrentUrl());
    }
}

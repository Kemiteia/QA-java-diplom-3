import io.qameta.allure.junit4.DisplayName;
import models.User;
import org.junit.Test;
import static org.junit.Assert.*;

public class TransferToConstructorTest extends WebDriverSettings {

    @Test
    @DisplayName("Переход из Личного кабинета в конструктор")
    public void transferToConstructorFromPersonalAccTest() {
        user = User.generateCorrectUser();
        homePage.openHomePage();
        homePage.clickPersonalAccountButton();
        authorizationPage.clickRegistrationButton();
        registrationPage.register(user);
        homePage.openHomePage();
        homePage.clickLoginButton();
        authorizationPage.loginToUserAccount(user);
        homePage.clickPersonalAccountButton();
        personalAccountPage.clickConstructorButton();
        assertTrue("Соберите бургер", homePage.waitAssembleBurger());
    }
}

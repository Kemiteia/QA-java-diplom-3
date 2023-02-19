import io.github.bonigarcia.wdm.WebDriverManager;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.*;

public class WebDriverSettings {
    WebDriver driver;
    HomePage homePage;
    AuthorizationPage authorizationPage;
    RegistrationPage registrationPage;
    RecoverPasswordPage recoverPasswordPage;
    PersonalAccountPage personalAccountPage;
    User user;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        homePage = new HomePage(driver);
        authorizationPage = new AuthorizationPage(driver);
        registrationPage = new RegistrationPage(driver);
        recoverPasswordPage = new RecoverPasswordPage(driver);
        personalAccountPage = new PersonalAccountPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

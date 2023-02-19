package pageobjects;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends HomePage {
    private final WebDriver driver;
    private final By nameField = By.xpath("//fieldset[1]/div/div/input");
    private final By emailField = By.xpath("//fieldset[2]/div/div/input");
    private final By passwordField = By.xpath("//fieldset[3]/div/div/input");
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By loginButton = By.xpath("//a[text()='Войти']");
    private final By personalAccountButton = By.xpath(".//a[(@class = 'AppHeader_header__link__3D_hX') and (@href='/account')]");
    public final By errorMessage = By.xpath(".//p[text()='Некорректный пароль']");
    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void wait(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void clickLoginButton(){
        wait(loginButton);
        driver.findElement(loginButton).click();
    }

    public void clickPersonalAccountButton(){
        wait(personalAccountButton);
        driver.findElement(personalAccountButton).click();
    }

    public void register(User user) {
        wait(registerButton);
        enterName(user.getName());
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        clickRegisterButton();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}

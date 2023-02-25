package pageobjects;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthorizationPage extends HomePage {
    private final WebDriver driver;
    private final By emailField = By.xpath(".//input[(@name='name')]");
    private final By passwordField = By.xpath(".//input[(@name='Пароль')]");
    private final By loginButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private final By registrationButton =  By.xpath(".//a[(@class='Auth_link__1fOlj') and (@href='/register')]");
    private final By recoverPasswordButton =  By.xpath(".//a[(@class='Auth_link__1fOlj') and (@href='/forgot-password')]");
    private final By personalAccountButton = By.xpath(".//a[(@class='AppHeader_header__link__3D_hX') and (@href='/account')]");
    private final By enterText = By.xpath(".//*[@id=\"root\"]/div/main/div/h2");

    public AuthorizationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void wait(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void putEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void putPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton(){
        wait(loginButton);
        driver.findElement(loginButton).click();
    }

    public void clickRegistrationButton() {
        wait(registrationButton);
        driver.findElement(registrationButton).click();
    }

    public void clickRecoverPasswordButton(){
        wait(recoverPasswordButton);
        driver.findElement(recoverPasswordButton).click();
    }

    public void clickPersonalAccountButton(){
        wait(personalAccountButton);
        driver.findElement(personalAccountButton).click();
    }

    public void waitAuthorizationPageToLoad() {
        wait(recoverPasswordButton);
    }

    public void loginToUserAccount(User user) {
        waitAuthorizationPageToLoad();
        putEmailField(user.getEmail());
        putPasswordField(user.getPassword());
        clickLoginButton();
    }

    public boolean checkExitPersonalAccount() {
        String text = driver.findElement(enterText).getText();
        return (text.equals("Вход"));
    }
}

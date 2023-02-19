package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PersonalAccountPage extends HomePage {
    private final WebDriver driver;
    private final By logOutPersonalAccountButton =  By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']");
    private final By constructorButton = By.xpath(".//a[(@class='AppHeader_header__link__3D_hX') and (@href='/')]");
    private final By personalAccountInfo =  By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']");

    public PersonalAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void wait(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitPersonalAccountToLoad() {
        wait(personalAccountInfo);
    }

    public String getPersonalAccountInfo() {
        wait(personalAccountInfo);
        return driver.findElement(personalAccountInfo).getText();
    }

    public String getPersonalAccountURL() {
        return "https://stellarburgers.nomoreparties.site/account/profile";
    }

    public void clickLogOutPersonalAccountButton(){
        wait(logOutPersonalAccountButton);
        driver.findElement(logOutPersonalAccountButton).click();
    }

    public void clickConstructorButton(){
        wait(constructorButton);
        driver.findElement(constructorButton).click();
    }
}

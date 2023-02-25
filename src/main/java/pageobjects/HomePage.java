package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By personalAccountButton = By.xpath(".//a[(@class = 'AppHeader_header__link__3D_hX') and (@href='/account')]");
    private final By constructorButton = By.xpath(".//a[(@class = 'AppHeader_header__link__3D_hX AppHeader_header__link_active__1IkJo') and (@href='/')]");
    private final By orderFeedButton = By.xpath(".//a[(@class = 'AppHeader_header__link__3D_hX') and (@href='/feed')]");
    private final By bunsButton = By.xpath("//*[text()='Булки']");
    private final By saucesButton = By.xpath("//*[text()='Соусы']");
    private final By ingredientsButton = By.xpath("//*[text()='Начинки']");
    private final By orderButton = By.xpath("//*[text()='Оформить заказ']");
    private final By assembleBurger = By.xpath(".//h1[@class = 'text text_type_main-large mb-5 mt-10']");
    private final By currentTab = By.xpath("//div[contains(@class, 'current')]/span");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        String BASE_URL = "https://stellarburgers.nomoreparties.site/";
        driver.get(BASE_URL);
    }

    public void wait(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public void clickOrderFeedButton(){
        driver.findElement(orderFeedButton).click();
    }

    public void clickBunsButton(){
        driver.findElement(bunsButton).click();
    }

    public void clickSaucesButton(){
        driver.findElement(saucesButton).click();
    }

    public void clickIngredientsButton(){
        driver.findElement(ingredientsButton).click();
    }

    public boolean waitOrderButton() {
        wait(orderButton);
        String text = driver.findElement(orderButton).getText();
        return (text.equals("Оформить заказ"));
    }

    public boolean waitAssembleBurger() {
        String text = driver.findElement(assembleBurger).getText();
        return (text.equals("Соберите бургер"));
    }

    public String getCurrentTab() {
        return driver.findElement(currentTab).getText();
    }
}

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConstructorPageTest extends WebDriverSettings {

    @Test
    @DisplayName("Переход к разделу Булки")
    public void transferToTheBunsTest() {
        homePage.openHomePage();
        homePage.clickIngredientsButton();
        homePage.clickBunsButton();
        String expectedTab = "Булки";
        String currentTab = homePage.getCurrentTab();
        assertEquals("Вкладка не переключилась", expectedTab, currentTab);
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    public void transferToTheIngredientsTest() {
        homePage.openHomePage();
        homePage.clickIngredientsButton();
        String expectedTab = "Начинки";
        String currentTab = homePage.getCurrentTab();
        assertEquals("Вкладка не переключилась", expectedTab, currentTab);
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    public void transferToTheSaucesTest() {
        homePage.openHomePage();
        homePage.clickSaucesButton();
        String expectedTab = "Соусы";
        String currentTab = homePage.getCurrentTab();
        assertEquals("Вкладка не переключилась", expectedTab, currentTab);
    }
}

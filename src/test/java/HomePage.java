import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By searchFlightButton = By.id("search-flight-button-id");
    private By profileButton = By.cssSelector("button[data-test='navigation-menu-profile']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToSearchFlightPage() {
        driver.findElement(searchFlightButton).click();
    }

    public void goToProfilePage() {
        driver.findElement(profileButton).click();
    }
}

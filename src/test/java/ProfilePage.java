import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {

    private By logoutButton = By.cssSelector("button[data-test='logout']");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        driver.findElement(logoutButton).click();
    }
}
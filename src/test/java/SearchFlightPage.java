import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchFlightPage extends BasePage {

    private By departureField = By.id("departure-field-id");
    private By destinationField = By.id("destination-field-id");
    private By searchButton = By.id("search-button-id");

    public SearchFlightPage(WebDriver driver) {
        super(driver);
    }

    public void searchFlight(String departure, String destination) {
        driver.findElement(departureField).sendKeys(departure);
        driver.findElement(destinationField).sendKeys(destination);
        driver.findElement(searchButton).click();
    }
}

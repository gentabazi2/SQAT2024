import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightSearchPage extends BasePage {

    private By departureField = By.id("input-button__departure");
    private By destinationField = By.id("input-button__destination");
    private By searchButton = By.cssSelector("button[data-ref='flight-search-widget__cta']");

    public FlightSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchFlight(String departure, String destination) {
        driver.findElement(departureField).click();
        driver.findElement(departureField).sendKeys(departure);
        driver.findElement(destinationField).click();
        driver.findElement(destinationField).sendKeys(destination);
        driver.findElement(searchButton).click();
    }
}

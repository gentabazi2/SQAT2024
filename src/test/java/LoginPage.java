import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage {

    // Update the selectors based on the provided information
    private By signInButton = By.cssSelector("button[data-test='navigation-menu-signin']");
    private By emailField = By.id("login-email"); // Update this with the actual ID or selector for the email field
    private By passwordField = By.id("login-password"); // Update this with the actual ID or selector for the password field
    private By submitButton = By.cssSelector("button[type='submit']"); // Update this with the actual selector for the submit button

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 2);

        // Wait for the sign-in button and click it
        WebElement signInElement = wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInElement.click();

        // Wait for the email field, then enter the email
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailElement.sendKeys(email);

        // Enter the password
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);

        // Click the submit button
        WebElement submitElement = driver.findElement(submitButton);
        submitElement.click();
    }
}

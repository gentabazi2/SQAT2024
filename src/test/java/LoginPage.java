import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginPage extends BasePage {

    private By signInButton = By.cssSelector("button.ry-button--anchor");
    private By emailField = By.cssSelector("input[name='email']");
    private By passwordField = By.cssSelector("input[name='password']");
    private By submitButton = By.cssSelector("button.auth-submit__button");
    private By loginForm = By.cssSelector("form[data-ref='login_modal']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement signInElement = wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginForm));
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailElement.sendKeys(email);
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.sendKeys(password);
        WebElement submitElement = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitElement.click();
    }
}
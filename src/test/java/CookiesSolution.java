import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookiesSolution {
    public static void addConsentCookie(WebDriver driver) {
        org.openqa.selenium.Cookie consentCookie = new org.openqa.selenium.Cookie("consent_cookie", "true");
        driver.manage().addCookie(consentCookie);
    }

    public static void handleCookieConsent(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement cookiePopup = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-popup-with-overlay")));
            WebElement acceptButton = cookiePopup.findElement(By.cssSelector("button[data-ref='cookie.accept-all']"));
            acceptButton.click();
        } catch (Exception e) {
            System.out.println("Cookie consent popup not found or already handled.");
        }
    }
}
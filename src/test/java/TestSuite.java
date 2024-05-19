import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSuite {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private SearchFlightPage searchFlightPage;
    private ProfilePage profilePage;

    @BeforeClass
    public void setup() {
        driver = WebDriverFactory.getDriver();
        driver.get("https://wizzair.com/");
        CookieManager.addConsentCookie(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        searchFlightPage = new SearchFlightPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Test(description = "Test Login")
    public void testLogin() {
        loginPage.login("beselicaerti@gmail.com", "Prishtina1*");
    }

    @Test(description = "Test Search Flight", dependsOnMethods = {"testLogin"})
    public void testSearchFlight() {
        homePage.goToProfilePage();
        searchFlightPage.searchFlight("Budapest", "London");
    }

    @Test(description = "Test Logout", dependsOnMethods = {"testSearchFlight"})
    public void testLogout() {
        profilePage.logout();
    }

    @Test(description = "Test Hover Over Element")
    public void testHover() {
        HoverTest.hoverOverElement(driver, By.cssSelector("button[data-test='navigation-menu-signin']"));
    }

    @Test(description = "Test Drag and Drop")
    public void testDragAndDrop() {
        DragAndDropTest.dragAndDrop(driver, By.cssSelector("source-selector"), By.cssSelector("target-selector"));
    }

    @Test(description = "Test File Upload")
    public void testFileUpload() {
        FileUploadTest.uploadFile(driver, By.cssSelector("input[type='file']"), "path/to/file");
    }

    @Test(description = "Test Navigate Back")
    public void testNavigateBack() {
        HistoryTest.navigateBack(driver);
    }

    @Test(description = "Test JavaScript Executor")
    public void testJavaScriptExecutor() {
        JavaScriptExecutorTest.executeScript(driver, "alert('Test JavaScript Executor');");
    }

    @Test(description = "Test Download Files")
    public void testDownloadFiles() {
        DownloadFilesTest.configureDownload(driver, "path/to/download/folder");
        DownloadFilesTest.downloadFiles(driver, By.cssSelector("download-button-selector"));
    }

    @Test(description = "Test with Random Data")
    public void testWithRandomData() {
        String randomEmail = RandomDataTest.getRandomString(10) + "@example.com";
        loginPage.login(randomEmail, "RandomPassword123!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

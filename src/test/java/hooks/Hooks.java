package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        // Ensure WebDriverManager automatically sets up the ChromeDriver
        WebDriverManager.chromedriver().setup();
        
        // Fetch user-data-dir from environment variable
        String chromeUserDataDir = System.getenv("CHROME_USER_DATA_DIR");

        // Set ChromeOptions with headless and user-data-dir arguments
        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--user-data-dir=" + chromeUserDataDir);

        // Initialize ChromeDriver with options
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

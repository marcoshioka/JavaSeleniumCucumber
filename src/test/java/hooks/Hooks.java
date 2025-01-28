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
        // Ensure ChromeDriver uses the unique user-data-dir from environment
        String chromeUserDataDir = System.getenv("CHROME_USER_DATA_DIR");

        // Set up ChromeDriver options to use the unique user-data-dir
        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--user-data-dir=" + chromeUserDataDir);

        // Setup WebDriver with ChromeDriver and options
        WebDriverManager.chromedriver().setup();
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

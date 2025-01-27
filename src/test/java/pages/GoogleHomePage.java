package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage {
    WebDriver driver;

    // Constructor
    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By searchBox = By.name("q");

    // Methods
    public void search(String query) {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.sendKeys(query);
        searchInput.submit();
    }
}

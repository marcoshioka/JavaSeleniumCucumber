package pages;

import javax.management.ObjectName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankUserPage {
    WebDriver driver;

    // Constructor
    public BankUserPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By registrarButton = By.xpath("//button[text()= 'Registrar']");
    private By buttonCadastrar = By.xpath("//button[text()= 'Cadastrar']");
    private By email = By.xpath("(//label[text()='E-mail']//following-sibling::input)[2]");
    private By name = By.xpath("//label[text()='Nome']//following-sibling::input");
    private By password = By.xpath("(//label[text()='Senha']//following-sibling::input)[2]");
    private By confirmPassword = By.xpath("//label[text()='Confirmação senha']//following-sibling::input");
    private By closeMessageBox = By.id("btnCloseModal");
    private By emailLogin = By.xpath("(//label[text()='E-mail']//following-sibling::input)[1]");
    private By passwordLogin = By.xpath("(//label[text()='Senha']//following-sibling::input)[1]");
    private By acessarButton = By.xpath("//button[text()= 'Acessar']");
    private By paymentsButton = By.xpath("//button[text()= 'Pagamentos']");

    // Methods
    public void waitAndSelectRegistrarButton() {
        WebElement registrarButtomn = driver.findElement(registrarButton);
        driver.findElement(registrarButton).click();
        driver.findElement(buttonCadastrar).isDisplayed();
    }

    public void searchAndInputData(String field, String input) {
        try {
            // Use reflection to get the By locator dynamically
            By fieldLocator = (By) this.getClass().getDeclaredField(field).get(this);

            if (fieldLocator != null) {
                WebElement searchInput = driver.findElement(fieldLocator);
                searchInput.sendKeys(input); // Send input data to the field
                searchInput.submit(); // Optionally, submit the form
            } else {
                throw new IllegalArgumentException("Field locator not found for: " + field);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error finding locator for field: " + field, e);
        }
    }

    public void checkMessage(String message) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + message + "')]")));
        element.isDisplayed();
    }

    public void checkIfTheUserIsRedirectedToTheLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(closeMessageBox));
        element.click();
        driver.findElement(acessarButton).isDisplayed();
    }

    public void waitAndClickButtonByText(String text) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(18));
        WebElement element = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()= '" + text + "']")));
        element.click();
    }

    public void selectAndVisitPage(String page, String message) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//p[text()= '" + page + "']/preceding-sibling::a")));
        element.click();

        WebElement secondElement = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()= '" + message + "']")));
        secondElement.isDisplayed();
    }

}

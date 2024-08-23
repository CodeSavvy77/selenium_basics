import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicElementHandling {

    public static void main(String[] args) {
        // Set up the WebDriver and launch the browser
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage
        driver.get("https://example.com"); // Replace with a URL that has dynamic elements

        // 1. Explicit Wait for the dynamic element to be present
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement dynamicElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dynamicElementId")));

        // 2. Fluent Wait for an element that might take time to load
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement fluentElement = fluentWait.until(driver1 -> driver.findElement(By.id("anotherDynamicElementId")));

        // 3. Use JavaScript to interact with the element if it's not interactable
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", dynamicElement);

        // Example of clicking an element
        dynamicElement.click();

        // 4. Handle StaleElementReferenceException by retrying
        WebElement element = null;
        for (int i = 0; i < 3; i++) {
            try {
                element = driver.findElement(By.id("dynamicElementId"));
                element.click();
                break;
            } catch (StaleElementReferenceException e) {
                // Retry locating the element
            }
        }

        // Close the browser
        driver.quit();
    }
}

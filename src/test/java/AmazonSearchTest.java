import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class AmazonSearchTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void tearDownDriver() {
        driver.quit();
    }

    @Test
    public void checkAmazonSearch() {
        driver.get("https://www.amazon.in/");

        WebElement searchInput = driver.findElement(By.cssSelector("#twotabsearchtextbox"));

        String searchPhrase = "iphone";

        searchInput.sendKeys(searchPhrase);
        searchInput.sendKeys(Keys.ENTER);

        List<String> actualItems = driver.findElements(By.cssSelector(".a-link-normal.s-underline-text.s-underline-link-text.s-link-style.a-text-normal"))
                .stream()
                .map(element -> element.getText().toLowerCase() + element.getAttribute("href").toLowerCase())
                .collect(Collectors.toList());

        List<String> expectedItems = actualItems.stream().filter(item -> item.contains(searchPhrase)).collect(Collectors.toList());

        Assertions.assertEquals(expectedItems, actualItems);
    }
}

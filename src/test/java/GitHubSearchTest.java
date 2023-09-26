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

public class GitHubSearchTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setUpDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkGitHubSearch(){
        driver.get("https://github.com/");

        WebElement searchInput = driver.findElement(By.cssSelector("body > div.logged-out.env-production.page-responsive.header-overlay.home-campaign > div.position-relative.js-header-wrapper > header > div > div.HeaderMenu--logged-out.p-responsive.height-fit.position-lg-relative.d-lg-flex.flex-column.flex-auto.pt-7.pb-4.top-0 > div > div > qbsearch-input > div.search-input-container.search-with-dialog.position-relative.d-flex.flex-row.flex-items-center.mr-4.rounded > button > span"));

        String searchPhrase = "selenium";
        searchInput.click();
        WebElement searchInput1 = driver.findElement(By.cssSelector("#query-builder-test"));
        searchInput1.sendKeys(searchPhrase);
        searchInput1.sendKeys(Keys.ENTER);

        List<String> actualItems = driver.findElements(By.cssSelector(".Box-sc-g0xbh4-0.bBwPjs.search-title")).stream().map(webElement -> webElement.getText().toLowerCase()).collect(Collectors.toList());

        List<String> expectedItems = actualItems.stream().filter(item -> item.contains(searchPhrase)).collect(Collectors.toList());
        Assertions.assertEquals(expectedItems, actualItems);
    }

    @AfterAll
    public static void tearDownDriver(){
        driver.quit();
    }
}

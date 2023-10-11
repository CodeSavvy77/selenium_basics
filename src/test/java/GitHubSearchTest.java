import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.impl.HomePage;
import pages.impl.SearchResultsPage;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class GitHubSearchTest {

    private static final String SEARCH_PHRASE = "selenium";
    private static WebDriver driver;

    private static WebDriverWait wait;

    @BeforeAll
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeAll
    public static void setUpWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private static void switchOffImplicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    }

    @AfterAll
    public static void tearDownDriver() {
        System.out.println(LocalDateTime.now());
        driver.quit();
    }

    @Test
    public void checkGitHubSearch() {
        driver.get("https://github.com/");

        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        homePage.performSearch(SEARCH_PHRASE);

        List<String> actualItems = searchResultsPage.searchResultsItemsText();
        List<String> expectedItems = searchResultsPage.searchResultsItemsWithText(SEARCH_PHRASE);

        Assertions.assertEquals(expectedItems, actualItems);
    }
}

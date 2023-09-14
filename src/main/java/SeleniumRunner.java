import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumRunner {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com/");

        WebElement searchInput = driver.findElement(By.cssSelector("body > div.logged-out.env-production.page-responsive.header-overlay.home-campaign > div.position-relative.js-header-wrapper > header > div > div.HeaderMenu--logged-out.p-responsive.height-fit.position-lg-relative.d-lg-flex.flex-column.flex-auto.pt-7.pb-4.top-0 > div > div > qbsearch-input > div.search-input-container.search-with-dialog.position-relative.d-flex.flex-row.flex-items-center.mr-4.rounded > button > span"));
        searchInput.click();
        WebElement searchInput1 = driver.findElement(By.cssSelector("#query-builder-test"));
        searchInput1.sendKeys("Selenium");
        searchInput1.sendKeys(Keys.ENTER);

        driver.quit();
    }
}

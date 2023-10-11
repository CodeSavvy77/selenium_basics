package pages.impl;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.WebPage;

public class HomePage extends WebPage {

    @FindBy(css = "body > div.logged-out.env-production.page-responsive.header-overlay.home-campaign > div.position-relative.js-header-wrapper > header > div > div.HeaderMenu--logged-out.p-responsive.height-fit.position-lg-relative.d-lg-flex.flex-column.flex-auto.pt-7.pb-4.top-0 > div > div > qbsearch-input > div.search-input-container.search-with-dialog.position-relative.d-flex.flex-row.flex-items-center.mr-4.rounded > button > span")
    private WebElement searchInput;

    @FindBy(css = "#query-builder-test")
    private WebElement searchInput1;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void performSearch(String searchPhrase) {
        searchInput.click();
        searchInput1.sendKeys(searchPhrase);
        searchInput1.sendKeys(Keys.ENTER);
    }
}

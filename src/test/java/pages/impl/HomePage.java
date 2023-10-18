package pages.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.WebPage;
import pages.components.impl.ClickComponent;
import pages.components.impl.SearchComponent;

public class HomePage extends WebPage {

    private static final By SEARCH_COMPONENT_SELECTOR = By.cssSelector("#query-builder-test");

    private static final By SEARCH_COMPONENT_SELECTOR1 = By.cssSelector("body > div.logged-out.env-production.page-responsive.header-overlay.home-campaign > div.position-relative.js-header-wrapper > header > div > div.HeaderMenu--logged-out.p-responsive.height-fit.position-lg-relative.d-lg-flex.flex-column.flex-auto.pt-7.pb-4.top-0 > div > div > qbsearch-input > div.search-input-container.search-with-dialog.position-relative.d-flex.flex-row.flex-items-center.mr-4.rounded > button");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SearchComponent searchComponent() {
        return new SearchComponent(findElement(SEARCH_COMPONENT_SELECTOR));
    }

    public ClickComponent clickComponent() {
        WebElement element = findElement(SEARCH_COMPONENT_SELECTOR1);
        if (element != null) {
            return new ClickComponent(element);
        } else {
            // Handle the case when the element is not found
            throw new NoSuchElementException("Element not found using SEARCH_COMPONENT_SELECTOR1");
        }
    }

}

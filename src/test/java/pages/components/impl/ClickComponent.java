package pages.components.impl;

import org.openqa.selenium.WebElement;

public class ClickComponent {
    private final WebElement element;

    public ClickComponent(WebElement element) {
        this.element = element;
    }

    public void click() {
        element.click();
    }
}

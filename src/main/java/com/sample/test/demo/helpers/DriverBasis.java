package com.sample.test.demo.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class DriverBasis {
    private WebDriver driver;

    public DriverBasis(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void selectDropdownByText(WebElement dropdown, String text) {
        new Select(dropdown).selectByVisibleText(text);
    }

    /**
     * Selects random option of given dropdown expect first one
     */
    protected String selectAnyValueDropdown(WebElement dropdown) {
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();
        int randomNumber = new Random().nextInt(options.size() - 1) + 1;
        select.selectByIndex(randomNumber);
        return select.getFirstSelectedOption().getText();
    }

    protected String getSelectedValueOfDropdown(WebElement dropdown) {
        Select select = new Select(dropdown);
        return select.getFirstSelectedOption().getText();
    }

    protected String getElementValue(WebElement element) {
        return element.getAttribute("value");
    }

    protected void clearAndType(WebElement input, String text) {
        input.clear();
        input.sendKeys(text);
    }

    protected boolean isElementPresentWithWaiting(final WebElement locator) {
        try {
            new WebDriverWait(getDriver(), 5, 300)
                    .until(ExpectedConditions.visibilityOf(locator));
        } catch (Exception e) {
            return false;
        }
        return true;
    }


}
